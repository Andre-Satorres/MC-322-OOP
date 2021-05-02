package hotel;

public class Room {
    private final boolean vip;
    private boolean occupied;
    private int days;

    public Room(boolean vip) {
        this.vip = vip;
        this.occupied = false;
    }

    public boolean isVip() {
        return vip;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getDays() {
        return days;
    }

    public void book(int days) {
        this.occupied = true;
        this.days = days;
    }

    public void release() {
        this.occupied = false;
        this.days = 0;
    }
}
