package bg.tu_varna.sit.f24621715.comand;

import bg.tu_varna.sit.f24621715.model.Reservation;
import bg.tu_varna.sit.f24621715.model.Room;

import java.util.Date;
import java.util.List;

public class AvailabilityCommand extends Command{


        public AvailabilityCommand() {

            super("availability",

                    "Shows available rooms for a given date",

                    "availability <date>");

        }

    @Override
    public void execute(String[] arguments, Reservation reservation) {
        Date date;


        if (arguments.length == 1) {
            date = new Date();
        } else {

            date = java.sql.Date.valueOf(arguments[1]);
        }

        List<Room> availableRooms = reservation.availability(date);

        for (Room room : availableRooms) {
            System.out.println(room);
        }
    }
}


