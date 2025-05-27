package com.sirma.academy.service;

import com.sirma.academy.model.Room;
import com.sirma.academy.model.RoomStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomManager {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    public List<Room> getAvailableRoomsByType(String typeName) {
        return rooms.stream()
                .filter(r -> r.getType().getName().equalsIgnoreCase(typeName))
                .filter(r -> r.getStatus() == RoomStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
