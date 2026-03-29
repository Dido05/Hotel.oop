package bg.tu_varna.sit.f24621715;

import java.time.LocalDate;

public class UnavailablePeriod {

    private LocalDate from;
    private LocalDate to;
    private String note;

    public UnavailablePeriod(LocalDate from, LocalDate to, String note) {
        this.from = from;
        this.to = to;
        this.note = note;
    }

    public boolean overlaps(LocalDate from, LocalDate to) {
        return !(to.isBefore(this.from) || from.isAfter(this.to));
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }
}


