package bg.tu_varna.sit.f24621715.model;

import java.util.Date;

public class Availability {
    private Date from;
    private Date to;
    private String note;
    private int numberGuest;

    public int getNumberGuest() {
        return numberGuest;
    }

    public Availability(Date from, Date to, String note, int numberGuest) {
        this.from = from;
        this.to = to;
        this.note = note;
        this.numberGuest = numberGuest;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "from=" + from +
                ", to=" + to +
                ", note='" + note + '\'' +
                ", numberGuest=" + numberGuest +
                '}';
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }
}
