package app.validation;


import app.annotation.BookingValidation;
import app.exception.InvalidBookingException;
import app.model.Guest;
import java.lang.reflect.Method;

public class BookingValidationProcessor {

    public static void validate(Method method, Guest guest) {
        if (method.isAnnotationPresent(BookingValidation.class)) {
            BookingValidation v = method.getAnnotation(BookingValidation.class);

            if (v.emailRequired() &&
                !Validation.isValidEmail(guest.getEmail())) {
                throw new InvalidBookingException("Invalid email");
            }
        }
    }
}
