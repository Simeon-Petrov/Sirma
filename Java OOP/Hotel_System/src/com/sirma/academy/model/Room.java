package com.sirma.academy.model;

public class Room {
    private int id;
    private String number;
    private String type;
    private int floor;
    private String status;
    private double price;
    private double cancelFee;

    public int getId() { return id; }
    public String getNumber() { return number; }
    public String getType() { return type; }
    public int getFloor() { return floor; }
    public String getStatus() { return status; }
    public double getPrice() { return price; }
    public double getCancelFee() { return cancelFee; }

    public void setStatus(String status) { this.status = status; }
    public void setPrice(double price) { this.price = price; }
    public void setCancelFee(double cancelFee) { this.cancelFee = cancelFee; }
}