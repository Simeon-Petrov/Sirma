package com.sirma.academy.manager;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sirma.academy.model.Room;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class RoomManager {
    private static final String ROOMS_FILE = "src/com/sirma/academy/data/rooms.json";;
    private List<Room> rooms = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void loadRooms() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(ROOMS_FILE)));
            rooms = new Gson().fromJson(json, new TypeToken<List<Room>>(){}.getType());
        } catch (IOException e) {
            System.out.println("Error loading rooms.");
        }
    }

    public void viewRooms() {
        for (Room r : rooms) {
            System.out.printf("ID: %d; Room: %s; Type: %s; Floor: %d; Status: %s; Price: %.2f; Cancel: %.2f\n",
                    r.getId(), r.getNumber(), r.getType(), r.getFloor(), r.getStatus(), r.getPrice(), r.getCancelFee());
        }
    }

    public Room getRoomById(int id) {
        return rooms.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    public void updateRoom() {
        System.out.print("Room ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Room room = getRoomById(id);
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.print("New Status (booked/available): ");
        String status = scanner.nextLine().trim().toLowerCase();
        room.setStatus(status);

        System.out.print("New Price: ");
        room.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("New Cancellation Fee: ");
        room.setCancelFee(Double.parseDouble(scanner.nextLine()));

        saveRooms();
        System.out.println("Room updated successfully.");
    }

    public void deleteRoom() {
        System.out.print("Room ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        rooms.removeIf(r -> r.getId() == id);
        saveRooms();
    }

    public void saveRooms() {
        try (FileWriter writer = new FileWriter(ROOMS_FILE)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(rooms, writer);
        } catch (IOException e) {
            System.out.println("Error saving rooms.");
        }
    }

    public void setRoomStatus(int id, String status) {
        Room room = getRoomById(id);
        if (room != null) {
            room.setStatus(status);
            saveRooms();
        }
    }
}