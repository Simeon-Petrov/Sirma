package com.sirma.academy.manager;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sirma.academy.model.Booking;
import com.sirma.academy.model.Room;
import com.sirma.academy.model.User;
import com.sirma.academy.model.*;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingManager {
    private static final String BOOKINGS_FILE = "src/com/sirma/academy/data/bookings.json";
    private List<Booking> bookings = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final RoomManager roomManager;

    public BookingManager(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    public void loadBookings() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(BOOKINGS_FILE))).trim();
            if (json.isEmpty()) {
                bookings = new ArrayList<>();
            } else {
                bookings = new Gson().fromJson(json, new TypeToken<List<Booking>>(){}.getType());
                if (bookings == null) bookings = new ArrayList<>();
            }
        } catch (IOException e) {
            bookings = new ArrayList<>();
        }
    }

    public void bookRoom(User user) {
        System.out.print("Enter room ID to book: ");
        int id = Integer.parseInt(scanner.nextLine());
        Room room = roomManager.getRoomById(id);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        String status = room.getStatus().trim().toLowerCase();
        if (!status.equals("available")) {
            System.out.println("Unavailable for booking.");
            return;
        }

        Booking booking = new Booking();
        booking.setId(generateBookingId());
        booking.setRoomId(id);
        booking.setUsername(user.getUsername());
        booking.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        bookings.add(booking);

        roomManager.setRoomStatus(id, "booked");
        saveBookings();
        System.out.println("Room booked successfully.");
    }

    public void viewBookings(User user) {
        for (Booking b : bookings) {
            if (b.getUsername().equals(user.getUsername())) {
                System.out.printf("Booking ID: %d | Room ID: %d | Date: %s\n",
                        b.getId(), b.getRoomId(), b.getDate());
            }
        }
    }

    public void updateBooking() {
        System.out.print("Booking ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Booking booking = bookings.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        System.out.print("New Room ID: ");
        int newRoomId = Integer.parseInt(scanner.nextLine());
        Room room = roomManager.getRoomById(newRoomId);

        if (room == null) {
            System.out.println("New room not found.");
            return;
        }

        String status = room.getStatus().trim().toLowerCase();
        if (!status.equals("available")) {
            System.out.println("New room is unavailable.");
            return;
        }

        roomManager.setRoomStatus(booking.getRoomId(), "available");

        booking.setRoomId(newRoomId);
        roomManager.setRoomStatus(newRoomId, "booked");

        saveBookings();
        System.out.println("Booking updated.");
    }

    public void deleteBooking() {
        System.out.print("Booking ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        Booking booking = bookings.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        if (booking != null) {
            roomManager.setRoomStatus(booking.getRoomId(), "available");
            bookings.remove(booking);
            saveBookings();
            System.out.println("Booking deleted.");
        } else {
            System.out.println("Booking not found.");
        }
    }

    private int generateBookingId() {
        return bookings.stream().mapToInt(Booking::getId).max().orElse(0) + 1;
    }

    private void saveBookings() {
        try (FileWriter writer = new FileWriter(BOOKINGS_FILE)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(bookings, writer);
        } catch (IOException e) {
            System.out.println("Error saving bookings.");
        }
    }
    public void syncBookingsWithRoomStatus() {
        List<Booking> updated = new ArrayList<>();
        for (Booking b : bookings) {
            Room room = roomManager.getRoomById(b.getRoomId());
            if (room != null && room.getStatus().equalsIgnoreCase("booked")) {
                updated.add(b);
            }
        }
        bookings = updated;
        saveBookings();
        System.out.println("Bookings synced with current room statuses.");
    }
    public void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        for (Booking b : bookings) {
            System.out.printf("Booking ID: %d | Room ID: %d | User: %s | Date: %s\n",
                    b.getId(), b.getRoomId(), b.getUsername(), b.getDate());
        }
    }
    public void deleteBookingByRoomId() {
        System.out.print("Enter Room ID to delete booking for: ");
        int roomId = Integer.parseInt(scanner.nextLine());

        Booking booking = bookings.stream()
                .filter(b -> b.getRoomId() == roomId)
                .findFirst()
                .orElse(null);

        if (booking != null) {
            roomManager.setRoomStatus(booking.getRoomId(), "available");
            bookings.remove(booking);
            saveBookings();
            System.out.println("Booking for room ID " + roomId + " deleted.");
        } else {
            System.out.println("No booking found for room ID " + roomId);
        }
    }
}