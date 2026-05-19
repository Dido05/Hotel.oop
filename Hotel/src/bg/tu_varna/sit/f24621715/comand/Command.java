package bg.tu_varna.sit.f24621715.comand;

import bg.tu_varna.sit.f24621715.model.Reservation;

import java.io.IOException;
import java.text.ParseException;

public abstract class Command {
    private String index;
    private String description;
    private String syntax;

    public Command(String index, String description, String syntax) {
        this.index = index;
        this.description = description;
        this.syntax = syntax;
    }

    public String getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    public String getSyntax() {
        return syntax;
    }
    public abstract void execute(String[] arguments, Reservation reservation) throws IOException, ParseException;
}
