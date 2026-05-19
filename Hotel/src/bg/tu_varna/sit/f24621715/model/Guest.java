package bg.tu_varna.sit.f24621715.model;

public class Guest {
    private String fname;
    private String sname;
    private String lname;
    private int number;
    private int roomNumber;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Guest(String fname, String sname, String lname, int number) {
        this.fname = fname;
        this.sname = sname;
        this.lname = lname;
        this.number = number;
        this.roomNumber=0;
    }

    public String getFname() {
        return fname;
    }

    public int getNumber() {
        return number;
    }

    public String getLname() {
        return lname;
    }

    public String getSname() {
        return sname;
    }


}
