package com.sirma.academy.model;

import java.util.List;

public class RoomType {
    private String name;
    private List<String> amenities;
    private int maxPersons;

    public RoomType() {
    }

    public RoomType(String name, List<String> amenities, int maxPersons) {
        this.name = name;
        this.amenities = amenities;
        this.maxPersons = maxPersons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public int getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(int maxPersons) {
        this.maxPersons = maxPersons;
    }

    @Override
    public String toString() {
        return name + " (max: " + maxPersons + ") amenities: " + amenities;
    }
}
