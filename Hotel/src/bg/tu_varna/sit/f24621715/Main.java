package bg.tu_varna.sit.f24621715;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        hotel.addRoom(new Room(101, 2));
        hotel.addRoom(new Room(102, 3));
        hotel.addRoom(new Room(103, 4));

        try {
            Scanner sc = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter("output.txt");

            while (sc.hasNext()) {
                String command = sc.next();

                if (command.equals("checkin")) {
                    int roomNumber = sc.nextInt();
                    LocalDate from = LocalDate.parse(sc.next());
                    LocalDate to = LocalDate.parse(sc.next());
                    String note = sc.next();
                    int guests = sc.nextInt();

                    Stay stay = new Stay(from, to, note, guests);

                    boolean success = hotel.checkIn(roomNumber, stay);
                    out.println(success ? "OK" : "Room is not available");
                }

                else if (command.equals("availability")) {
                    LocalDate from = LocalDate.parse(sc.next());
                    LocalDate to = LocalDate.parse(sc.next());

                    for (Room r : hotel.getAvailableRooms(from, to)) {
                        out.println(r.getNumber());
                    }
                }

                else if (command.equals("find")) {
                    int beds = sc.nextInt();
                    LocalDate from = LocalDate.parse(sc.next());
                    LocalDate to = LocalDate.parse(sc.next());

                    Room room = hotel.findRoom(beds, from, to);
                    out.println(room != null ? room.getNumber() : "No room");
                }

                else if (command.equals("find!")) {
                    int beds = sc.nextInt();
                    LocalDate from = LocalDate.parse(sc.next());
                    LocalDate to = LocalDate.parse(sc.next());

                    Room room = hotel.findSpecial(beds, from, to);
                    out.println(room != null ? room.getNumber() : "No room");
                }

                else if (command.equals("report")) {
                    LocalDate from = LocalDate.parse(sc.next());
                    LocalDate to = LocalDate.parse(sc.next());

                    List<String> report = hotel.report(from, to);

                    for (String line : report) {
                        out.println(line);
                    }
                }

                else if (command.equals("unavailable")) {
                    int roomNumber = sc.nextInt();
                    LocalDate from = LocalDate.parse(sc.next());
                    LocalDate to = LocalDate.parse(sc.next());
                    String note = sc.next();

                    UnavailablePeriod period = new UnavailablePeriod(from, to, note);

                    boolean success = hotel.makeUnavailable(roomNumber, period);
                    out.println(success ? "OK" : "Cannot mark unavailable");
                }

                else if (command.equals("exit")) {
                    break;
                }
            }

            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
