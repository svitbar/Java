package org.example.passanger;

import org.example.vehicle.Vehicle;

public class Human {
    private final String name;
    private Vehicle<?> currentVehicle;

    public Human(String name) {
        this.name = name;
        this.currentVehicle = null;
    }

    public Vehicle<?> getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(Vehicle<?> currentVehicle) {
        this.currentVehicle = currentVehicle;
    }
}
