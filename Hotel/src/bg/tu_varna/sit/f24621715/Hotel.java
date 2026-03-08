package bg.tu_varna.sit.f24621715;

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
}
