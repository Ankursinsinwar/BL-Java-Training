package app;

import org.junit.jupiter.api.*;

import app.service.BookingService;
import app.model.Guest;


public class BookingServiceTest {

    @Test
    void bookingShouldSucceed() {
        BookingService service = new BookingService();
        Guest guest = new Guest("Test", "test@gmail.com", "8011349068");

        Assertions.assertDoesNotThrow(() ->
                service.bookRoom("STANDERD", guest)
        );
    }
}
