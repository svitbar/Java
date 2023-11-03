package org.example.vehicle;

import org.example.passanger.Human;

public class Car <T extends Human> extends Vehicle<T> {

    public Car(int seatCount) {
        super(seatCount);
    }
}
