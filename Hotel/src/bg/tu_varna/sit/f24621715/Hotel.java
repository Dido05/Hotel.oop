package bg.tu_varna.sit.f24621715;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room findRoom(int number) {
        for (Room r : rooms) {
            if (r.getNumber() == number) {
                return r;
            }
        }
        return null;
    }

    public boolean checkIn(int roomNumber, Stay stay) {
        Room room = findRoom(roomNumber);

        if (room != null && room.isAvailable(stay.getFrom(), stay.getTo())) {
            room.addStay(stay);
            return true;
        }

        return false;
    }
    public List<Room> getAvailableRooms(LocalDate from, LocalDate to) {
        List<Room> result = new ArrayList<>();

        for (Room room : rooms) {
            if (room.isAvailable(from, to)) {
                result.add(room);
            }
        }

        return result;
    }

    public Room findRoom(int beds, LocalDate from, LocalDate to) {
        Room bestRoom = null;

        for (Room room : rooms) {
            if (room.getBeds() >= beds && room.isAvailable(from, to)) {

                if (bestRoom == null || room.getBeds() < bestRoom.getBeds()) {
                    bestRoom = room;
                }
            }
        }

        return bestRoom;
    }

    public Room findSpecial(int beds, LocalDate from, LocalDate to) {

        Room normal = findRoom(beds, from, to);
        if (normal != null) return normal;

        for (Room room : rooms) {

            if (room.getBeds() < beds) continue;

            List<Stay> conflicts = new ArrayList<>();

            for (Stay s : room.getStays()) {
                if (s.overlaps(from, to)) {
                    conflicts.add(s);
                }
            }

            if (conflicts.size() > 2) continue;

            boolean canMoveAll = true;

            for (Stay s : conflicts) {
                Room newRoom = findRoom(s.getGuests(), s.getFrom(), s.getTo());

                if (newRoom == null || newRoom == room) {
                    canMoveAll = false;
                    break;
                }
            }

            if (canMoveAll) {
                for (Stay s : new ArrayList<>(conflicts)) {
                    Room newRoom = findRoom(s.getGuests(), s.getFrom(), s.getTo());

                    newRoom.addStay(s);
                    room.getStays().remove(s);
                }
            }
        }

        return null;
    }

    public List<String> report(LocalDate from, LocalDate to) {
        List<String> result = new ArrayList<>();

        for (Room room : rooms) {
            for (Stay stay : room.getStays()) {
                if (stay.overlaps(from, to)) {
                    result.add(
                            "Room " + room.getNumber() + " | " +
                                    stay.getFrom() + " - " + stay.getTo()
                    );
                }
            }
        }

        return result;
    }

    public boolean makeUnavailable(int roomNumber, UnavailablePeriod period) {
        Room room = findRoom(roomNumber);

        if (room != null && room.isAvailable(period.getFrom(), period.getTo())) {
            room.getUnavailablePeriods().add(period);
            return true;
        }

        return false;
    }
}
