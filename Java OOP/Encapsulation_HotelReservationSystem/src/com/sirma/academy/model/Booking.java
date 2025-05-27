package com.sirma.academy.model;

import java.time.LocalDate;

public class Booking {
    private int reservationId;
    private String username;
    private int roomNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalAmount;

    public Booking() {}

    public Booking(int reservationId, String username, int roomNumber, LocalDate startDate, LocalDate endDate, double totalAmount) {
        this.reservationId = reservationId;
        this.username = username;
        this.roomNumber = roomNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = totalAmount;
    }

    public int getReservationId() { return reservationId; }
    public String getUsername() { return username; }
    public int getRoomNumber() { return roomNumber; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return "Booking ID: " + reservationId + " | Room: " + roomNumber + " | User: " + username + " | From: " + startDate + " To: " + endDate + " | Total: $" + totalAmount;
    }
}
