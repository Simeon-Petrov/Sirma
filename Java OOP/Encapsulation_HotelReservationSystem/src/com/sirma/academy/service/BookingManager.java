package com.sirma.academy.service;

import com.sirma.academy.model.*;

import java.time.LocalDate;
import java.util.*;

public class BookingManager {
    private int nextId = 1;
    private List<Booking> bookings = new ArrayList<>();

    public Booking createBooking(User user, Room room, LocalDate start, LocalDate end) {
        long nights = end.toEpochDay() - start.toEpochDay();
        double total = nights * room.getPricePerNight();
        Booking booking = new Booking(nextId++, user.getUsername(), room.getRoomNumber(), start, end, total);
        bookings.add(booking);
        user.addBooking(booking);
        room.setStatus(RoomStatus.BOOKED);
        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}
