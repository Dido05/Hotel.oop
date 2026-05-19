package bg.tu_varna.sit.f24621715.comand;

import bg.tu_varna.sit.f24621715.model.Availability;
import bg.tu_varna.sit.f24621715.model.Reservation;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class CommandConroller {


    private Map<String,Command> commands=new HashMap<>();

    public CommandConroller() {
        AvailabilityCommand availabilityCommand=new AvailabilityCommand();
        commands.put(availabilityCommand.getIndex(),availabilityCommand);
       SaveCommand saveCommand=new SaveCommand();
       commands.put(saveCommand.getIndex(),saveCommand);
        SaveasCommand saveasCommand=new SaveasCommand();
        commands.put(saveasCommand.getIndex(),saveasCommand);
        OpenCommand openCommand=new OpenCommand();
        HelpCommand helpCommand=new HelpCommand(commands);
        commands.put(helpCommand.getIndex(),helpCommand);
    }
    public void start(String input, Reservation reservation) throws IOException, ParseException {
        String[] parts = input.split(" ");

        String commandIndex = parts[0];
        Command command = commands.get(commandIndex);

        if (command != null) {
            command.execute(parts, reservation);
        } else {
            System.out.println("Unknown command");
        }
    }
}
