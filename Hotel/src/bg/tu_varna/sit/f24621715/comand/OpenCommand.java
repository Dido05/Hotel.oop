package bg.tu_varna.sit.f24621715.comand;

import bg.tu_varna.sit.f24621715.model.Availability;
import bg.tu_varna.sit.f24621715.model.Guest;
import bg.tu_varna.sit.f24621715.model.Reservation;
import bg.tu_varna.sit.f24621715.model.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenCommand  extends Command {
    public OpenCommand() {
        super("open",
                "opens file with <filepath>",
                "open <filepath>");
    }
    @Override

    public void execute(String[] arguments, Reservation reservation)
            throws IOException, ParseException {
        String filepath = arguments[1];
        reservation.setFilepath(filepath);
        File file = new File(filepath);
        if (!file.exists()) {
            file.createNewFile();
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Room currentRoom = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equals("GUESTS")) {
                    while (!(line = reader.readLine().trim()).equals("END_GUESTS")) {
                        String[] parts = line.split("\\s*,\\s*");
                        String fname = parts[0];
                        String sname = parts[1];
                        String lname = parts[2];
                        int number = Integer.parseInt(parts[3]);
                        int roomNumber = Integer.parseInt(parts[4]);
                        Guest guest = new Guest(fname, sname, lname, number);
                        guest.setRoomNumber(roomNumber);
                        reservation.addGuest(guest);
                    }
                }
                else if (line.equals("ROOMS")) {
                    while ((line = reader.readLine()) != null) {
                        line = line.trim();
                        if (line.isEmpty()) {
                            continue;
                        }
                        if (!line.equals("RESERVATIONS")) {
                            String[] parts = line.split("\\s*,\\s*");
                            int roomNumber = Integer.parseInt(parts[0]);
                            int beds = Integer.parseInt(parts[1]);
                            currentRoom = new Room(roomNumber, beds);
                            reservation.addRoom(currentRoom);
                        }
                        else {
                            while (!(line = reader.readLine().trim())
                                    .equals("END_RESERVATIONS")) {
                                String[] parts = line.split("\\s*,\\s*", -1);
                                Date from = formatter.parse(parts[0]);
                                Date to = formatter.parse(parts[1]);
                                int numberGuest = Integer.parseInt(parts[2]);
                                String note = parts.length > 3 ? parts[3] : "";
                                currentRoom.reserve(from, to, numberGuest, note);
                            }
                        }
                    }
                }
            }
        }
    }
}
