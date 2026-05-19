package bg.tu_varna.sit.f24621715.comand;

import bg.tu_varna.sit.f24621715.model.Reservation;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

public class HelpCommand extends Command{
    private Map<String,Command> commands;

    public HelpCommand( Map<String, Command> commands) {
        super("help",
                "displays all commands",
                "help");
        this.commands = commands;
    }

    @Override
    public void execute(String[] arguments, Reservation reservation) throws IOException, ParseException {
        for(Command c:commands.values())
        {
            System.out.println(c.getSyntax());
            System.out.println(c.getDescription());
            System.out.println();
        }
    }
}
