package bg.tu_varna.sit.f24621715;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private int number;
    private int beds;

    private List<Stay> stays;    //checkins
    private List<UnavailablePeriod> unavailablePeriods;

    public Room(int number, int beds) {
        this.number = number;
        this.beds = beds;
        this.stays = stays;
        this.unavailablePeriods = unavailablePeriods;
    }

    public int getNumber() {
        return number;
    }

    public int getBeds() {
        return beds;
    }

    public List<Stay> getStays() {
        return stays;
    }

    public List<UnavailablePeriod> getUnavailablePeriods() {
        return unavailablePeriods;
    }

    public boolean isAvailable(LocalDate from, LocalDate to) {

        for (Stay stay : stays) {
            if (stay.overlaps(from, to)) {
                return false;
            }
        }

        for (UnavailablePeriod p : unavailablePeriods) {
            if (p.overlaps(from, to)) {
                return false;
            }
        }

        return true;
    }

    public void addStay(Stay stay) {
        stays.add(stay);
    }
}
