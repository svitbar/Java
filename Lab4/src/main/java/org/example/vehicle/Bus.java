package org.example.vehicle;

import org.example.passanger.Human;

public class Bus<T extends Human> extends Vehicle<T> {
    public Bus(int seatCount) {
        super(seatCount);
    }
}
