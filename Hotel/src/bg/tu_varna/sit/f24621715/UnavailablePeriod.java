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
}


