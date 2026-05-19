package bg.tu_varna.sit.f24621715.comand;

import bg.tu_varna.sit.f24621715.model.Availability;
import bg.tu_varna.sit.f24621715.model.Guest;
import bg.tu_varna.sit.f24621715.model.Reservation;
import bg.tu_varna.sit.f24621715.model.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class SaveasCommand extends Command {
    public SaveasCommand(
    ) {
        super("saveas",
                "saves changes to chosen file with path <filepath>",
                "saveas <filepath>");
    }

    @Override
    public void execute(String[] arguments, Reservation reservation) throws IOException {
        String currentFile=arguments[1];
        try(PrintWriter writer= new PrintWriter(new FileWriter(currentFile))){
            writer.println("GUESTS");
            for(Guest g : reservation.getGuests().values())
            {
                writer.print(g.getFname()+",");
                writer.print(g.getSname()+",");
                writer.print(g.getLname()+",");
                writer.print(g.getNumber()+",");
                writer.println(g.getRoomNumber());

            }
            writer.println("END_GUESTS");
            writer.println("ROOMS");
            for(Room r:reservation.getRooms().values())
            {
                writer.print(r.getNumber()+",");
                writer.print(r.getNumberBeds());
                writer.println();
                writer.println("RESERVATIONS");
                SimpleDateFormat simpleFormatter=new SimpleDateFormat("yyyy-MM-dd");
                for(Availability a: r.getAvailability())
                {

                    writer.print(simpleFormatter.format(a.getFrom())+",");
                    writer.print(simpleFormatter.format(a.getTo())+",");
                    writer.print(a.getNumberGuest()+",");
                    writer.println(a.getNote());


                }
                writer.println("END_RESERVATIONS");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
