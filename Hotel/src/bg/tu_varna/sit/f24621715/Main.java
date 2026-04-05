package bg.tu_varna.sit.f24621715;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // example rooms
        hotel.addRoom(new Room(101, 2));
        hotel.addRoom(new Room(102, 3));
        hotel.addRoom(new Room(103, 4));

        Scanner sc = new Scanner(System.in);

        while (true) {
            String command = sc.next();

            if (command.equals("checkin")) {
                int roomNumber = sc.nextInt();
                LocalDate from = LocalDate.parse(sc.next());
                LocalDate to = LocalDate.parse(sc.next());
                String note = sc.next();
                int guests = sc.nextInt();

                Stay stay = new Stay(from, to, note, guests);

                boolean success = hotel.checkIn(roomNumber, stay);
                System.out.println(success ? "OK" : "Room is not available");
            }

            else if (command.equals("availability")) {
                LocalDate from = LocalDate.parse(sc.next());
                LocalDate to = LocalDate.parse(sc.next());

                for (Room r : hotel.getAvailableRooms(from, to)) {
                    System.out.println(r.getNumber());
                }
            }

            else if (command.equals("find")) {
                int beds = sc.nextInt();
                LocalDate from = LocalDate.parse(sc.next());
                LocalDate to = LocalDate.parse(sc.next());

                Room room = hotel.findRoom(beds, from, to);
                System.out.println(room != null ? room.getNumber() : "No room");
            }

            else if (command.equals("find!")) {
                int beds = sc.nextInt();
                LocalDate from = LocalDate.parse(sc.next());
                LocalDate to = LocalDate.parse(sc.next());

                Room room = hotel.findSpecial(beds, from, to);
                System.out.println(room != null ? room.getNumber() : "No room");
            }

            else if (command.equals("report")) {
                LocalDate from = LocalDate.parse(sc.next());
                LocalDate to = LocalDate.parse(sc.next());

                List<String> report = hotel.report(from, to);

                for (String line : report) {
                    System.out.println(line);
                }
            }

            else if (command.equals("unavailable")) {
                int roomNumber = sc.nextInt();
                LocalDate from = LocalDate.parse(sc.next());
                LocalDate to = LocalDate.parse(sc.next());
                String note = sc.next();

                UnavailablePeriod period = new UnavailablePeriod(from, to, note);

                boolean success = hotel.makeUnavailable(roomNumber, period);
                System.out.println(success ? "OK" : "Cannot mark unavailable");
            }

            else if (command.equals("exit")) {
                break;
            }
        }

    }
}
