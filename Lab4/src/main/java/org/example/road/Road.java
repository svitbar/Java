package org.example.road;

import org.example.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle<?>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int res = 0;

        for (Vehicle<?> v: carsInRoad) {
            res += v.getOccupiedSeatCount();
        }

        return res;
    }

    public void addCarToRoad(Vehicle<?> vehicle) {
        if (carsInRoad.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle is already on the road.");
        } else if (vehicle.getCurrentRoad() != null) {
            throw new IllegalArgumentException("Vehicle is already on another road.");
        } else {
            vehicle.setCurrentRoad(this);
            carsInRoad.add(vehicle);
        }
    }

    public void removeCarFromRoad(Vehicle<?> vehicle) {
        if (!carsInRoad.contains(vehicle)) {
            throw new IllegalArgumentException("There is no such a vehicle on the road.");
        } else {
            vehicle.setCurrentRoad(null);
            carsInRoad.remove(vehicle);
        }
    }
}
