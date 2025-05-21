package com.sirma.academy.service;

import com.sirma.academy.model.Room;
import com.sirma.academy.model.RoomStatus;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAvailableRoomsByType(String typeName) {
        List<Room> result = new ArrayList<>();
        for (Room r : rooms) {
            if (r.getStatus() == RoomStatus.AVAILABLE && r.getType().getName().equalsIgnoreCase(typeName)) {
                result.add(r);
            }
        }
        return result;
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) return r;
        }
        return null;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
}

