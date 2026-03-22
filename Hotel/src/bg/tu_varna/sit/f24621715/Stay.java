package bg.tu_varna.sit.f24621715;

import java.time.LocalDate;

public class Stay {

    private LocalDate from;
    private LocalDate to;
    private String note;
    private int guests;

    public Stay(LocalDate from, LocalDate to, String note, int guests) {
        this.from = from;
        this.to = to;
        this.note = note;
        this.guests = guests;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public String getNote() {
        return note;
    }

    public int getGuests() {
        return guests;
    }

    public boolean overlaps(LocalDate from, LocalDate to) {
        return !(to.isBefore(this.from) || from.isAfter(this.to));
    }
}
