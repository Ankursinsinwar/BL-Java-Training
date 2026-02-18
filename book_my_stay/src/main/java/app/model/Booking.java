package app.model;

public class Booking<T extends Room> {
    private T room;
    private Guest guest;

    public Booking(T room, Guest guest) {
        this.room = room;
        this.guest = guest;
    }

    public T getRoom() {
        return room;
    }
    public Guest getGuest() {
        return guest;
    }
}
