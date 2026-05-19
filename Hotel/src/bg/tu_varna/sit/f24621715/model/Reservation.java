package bg.tu_varna.sit.f24621715.model;

import java.time.LocalDate;
import java.util.*;

public class Reservation {
   Map <Integer,Room>rooms=new HashMap();
    private Map<Integer, Guest> guests = new HashMap<>();
    private String filepath;
public void addData(){
    Room room1=new Room(107,3);
    Room room2=new Room(101,4);
    Room room3=new Room(415,2);
    Room room4=new Room(320,5);
    Room room5=new Room(500,2);
    Room room6=new Room(127,3);
    Room room7=new Room(350,3);
    Room room8=new Room(200,4);
    Room room9=new Room(423,3);
    Room room10=new Room(401,2);
    rooms.put(room1.getNumber(),room1);
    rooms.put(room2.getNumber(),room2);
    rooms.put(room3.getNumber(),room3);
    rooms.put(room4.getNumber(),room4);
    rooms.put(room5.getNumber(),room5);
    rooms.put(room6.getNumber(),room6);
    rooms.put(room7.getNumber(),room7);
    rooms.put(room8.getNumber(),room8);
    rooms.put(room9.getNumber(),room9);
    rooms.put(room10.getNumber(),room10);
    Guest guest1 = new Guest( "John", "Doe", "Smith", 1);
    Guest guest2 = new Guest( "Anna",  "Ivanova",  "Petrova",  2);
    Guest guest3 = new Guest( "Peter",  "Johnson",  "Brown",  3);
    Guest guest4 = new Guest( "Maria",  "Georgieva",  "Dimitrova",  4);
    Guest guest5 = new Guest( "Ivan",  "Petrov",  "Kolev",  5);
    guests.put(guest1.getNumber(),guest1);
    guests.put(guest2.getNumber(),guest2);
    guests.put(guest3.getNumber(),guest3);
    guests.put(guest4.getNumber(),guest4);
    guests.put(guest5.getNumber(),guest5);
}

    public Map<Integer, Room> getRooms() {
        return rooms;
    }

    public Map<Integer, Guest> getGuests() {
        return guests;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }


    public List<Room> availability(Date date) {

        List<Room> result = new ArrayList<>();

        for (Room room : rooms.values()) {
            if(room.getAvailability().isEmpty())
            {
                result.add(room);
            }
            for (Availability availability : room.getAvailability()) {

                if (date.before(availability.getFrom()) || date.after(availability.getTo())) {

                    result.add(room);
                    break;

                }

            }

        }

        return result;

    }

    public void addRoom(Room room){
        rooms.put(room.getNumber(),room);
}
public void addGuest(Guest guest)
{
    guests.put(guest.getNumber(),guest);
}
}
