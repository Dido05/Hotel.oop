package bg.tu_varna.sit.f24621715;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.addRoom(new Room(101, 2));

        int roomNumber = 101;



        Stay stay = new Stay(
                LocalDate.of(2026, 3, 22),
                LocalDate.of(2026, 3, 25),
                "Test",
                2
        );


        boolean success = hotel.checkIn(roomNumber, stay);

        if (success) {
            System.out.println("OK");
        } else {
            System.out.println("Room is not available");
        }



    }

}
