package org.example.vehicle;

import org.example.passanger.Firefighter;

public class FireTruck<T extends Firefighter> extends Car<T> {
    public FireTruck(int seatCount) {
        super(seatCount);
    }
}
