package com.sirma.academy.model;

public class Booking {
    private int id;
    private String username;
    private int roomId;
    private String date;

    public int getId() { return id; }
    public String getUsername() { return username; }
    public int getRoomId() { return roomId; }
    public String getDate() { return date; }

    public void setId(int id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setRoomId(int roomId) { this.roomId = roomId; }
    public void setDate(String date) { this.date = date; }
}