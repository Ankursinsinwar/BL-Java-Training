package app.service;

import app.annotation.BookingValidation;
import app.exception.NoRoomAvailableException;
import app.model.*;
import app.validation.BookingValidationProcessor;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingService {

    private List<Booking<? extends Room>> bookings = new ArrayList<>();
    private Queue<Guest> waitList = new LinkedList<>();
    private Stack<Booking<?>> undoStack = new Stack<>();
    private Set<Guest> guests = new HashSet<>();

    private Map<String, AtomicInteger> inventory = new ConcurrentHashMap<>();

    public BookingService() {
        inventory.put("STANDERD", new AtomicInteger(1));
        inventory.put("DELUXE", new AtomicInteger(2));
        inventory.put("SUITE", new AtomicInteger(3));
    }

    @BookingValidation
    public void bookRoom(String type, Guest guest) throws NoRoomAvailableException, NoSuchMethodException, SecurityException {

        try {
            Method m = BookingService.class.getMethod("bookRoom", String.class, Guest.class);
            BookingValidationProcessor.validate(m, guest);

            AtomicInteger count = inventory.get(type);
            if (count == null || count.get() == 0) {
                waitList.add(guest);
                throw new NoRoomAvailableException("No rooms for " + type);
            }

            count.decrementAndGet();
            guests.add(guest);

            Room room = type.equals("SUITE") ? new SuiteRoom() : (type.equals("STANDERD")? new StanderdRoom() : new DeluxeRoom());

            Booking<?> booking = new Booking<>(room, guest);
            bookings.add(booking);
            undoStack.push(booking);

        } finally {
            System.out.println("Booking attempt completed");
        }
    }

    @Deprecated
    public void oldBookingMethod() {
        System.out.println("Deprecated booking logic");
    }

    public List<Booking<? extends Room>> getBookings() {
        return bookings;
    }
}