package com.sirma.academy.model;

import java.util.List;

public class RoomType {
    private String name;
    private List<String> amenities;
    private int maxOccupancy;

    public RoomType() {}

    public RoomType(String name, List<String> amenities, int maxOccupancy) {
        this.name = name;
        this.amenities = amenities;
        this.maxOccupancy = maxOccupancy;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getAmenities() { return amenities; }
    public void setAmenities(List<String> amenities) { this.amenities = amenities; }

    public int getMaxOccupancy() { return maxOccupancy; }
    public void setMaxOccupancy(int maxOccupancy) { this.maxOccupancy = maxOccupancy; }

    @Override
    public String toString() {
        return name + " (max: " + maxOccupancy + ") amenities: " + amenities;
    }
}
