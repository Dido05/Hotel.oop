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
}
