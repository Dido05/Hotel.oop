package bg.tu_varna.sit.f24621715.model;

import java.util.*;

public class Room {

    private int number;
    private int numberBeds;
   List<Availability> availability=new ArrayList<>();


    public Room(int number, int numberBeds) {
        this.number = number;
        this.numberBeds = numberBeds;

    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +

                ", numberBeds=" + numberBeds +
                ", availability=" + availability +
                '}';
    }

    public int getNumber() {
        return number;
    }


    public int getNumberBeds() {
        return numberBeds;
    }

    public List<Availability> getAvailability() {
        return availability;
    }


    public void reserve(Date from, Date to,int numberGuesests,String note)
    {
        Availability availability1=new Availability(from,to,note,numberGuesests);
        availability.add(availability1);
    }

    public void addAvailability(Availability availability) {


    }
}
