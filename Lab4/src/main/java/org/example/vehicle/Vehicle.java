package org.example.vehicle;

import org.example.passanger.Human;
import org.example.road.Road;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Human> {
    private final int maxSeatCount;
    private final List<T> passengers = new ArrayList<>();
    private Road currentRoad;

    public Vehicle(int maxSeatCount) {
        this.maxSeatCount = maxSeatCount;
        this.currentRoad = null;
    }

    public Road getCurrentRoad() {
        return currentRoad;
    }

    public void setCurrentRoad(Road currentRoad) {
        this.currentRoad = currentRoad;
    }

    public int getMaxSeatCount() {
        return maxSeatCount;
    }

    public int getOccupiedSeatCount() {
        return passengers.size();
    }

    public void addPassenger(T passenger) {
        if (passengers.size() >= maxSeatCount) {
            throw new IllegalArgumentException("No more available seats.");
        } else if (passengers.contains(passenger)) {
            throw new IllegalArgumentException("This passenger is already inside.");
        } else if (passenger.getCurrentVehicle() != null) {
            throw new IllegalArgumentException("This passenger is already inside another vehicle.");
        } else {
            passenger.setCurrentVehicle(this);
            passengers.add(passenger);
        }
    }

    public void removePassenger(T passenger) {
        if (!passengers.contains(passenger)) {
            throw new IllegalArgumentException("There is no such a passenger.");
        } else {
            passenger.setCurrentVehicle(null);
            passengers.remove(passenger);
        }
    }
}
