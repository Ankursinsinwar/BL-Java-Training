package app.validation;

import java.util.regex.Pattern;

public class Validation {
    public static boolean isValidEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email);
    }
    
    public static boolean isValidPhone(String phone) {
        return Pattern.matches("^(\\+91[- ]?)?[6-9]\\d{9}$", phone);
    }
}
