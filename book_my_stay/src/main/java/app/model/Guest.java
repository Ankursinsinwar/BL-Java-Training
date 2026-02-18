package app.model;

import java.util.Objects;

public class Guest {
    private String name;
    private String email;
    private String phone;

    public Guest(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
         return name; 
        }
    public String getEmail() {
         return email; 
        }
    public String getPhone() {
         return phone; 
        }

    @Override
    public boolean equals(Object o) {
        Guest g = (Guest) o;
        return Objects.equals(email, g.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
