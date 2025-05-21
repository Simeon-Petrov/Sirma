package com.sirma.academy.model;

public class Room {
    private int roomNumber;
    private RoomType type;
    private double pricePerNight;
    private double cancellationFee;
    private RoomStatus status;

    public Room() {
    }

    public Room(int roomNumber, RoomType type, double pricePerNight, double cancellationFee, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.cancellationFee = cancellationFee;
        this.status = status;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getCancellationFee() {
        return cancellationFee;
    }

    public void setCancellationFee(double cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " - " + type.getName() + " [Status: " + status + ", $" + pricePerNight + "]";
    }
}















