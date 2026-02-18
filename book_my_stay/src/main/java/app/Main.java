package app;

import app.exception.NoRoomAvailableException;
import app.model.Guest;
import app.service.BookingService;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        BookingService service = new BookingService();
        Guest g1 = new Guest("Ankur", "ankur@gmail.com", "9876543210");

        try {
            service.bookRoom("DELUXE", g1);
        } catch (NoRoomAvailableException e) {
            System.out.println(e.getMessage());
        }
    } 
}
