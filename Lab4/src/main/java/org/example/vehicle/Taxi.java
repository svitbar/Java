package org.example.vehicle;

import org.example.passanger.Human;

public class Taxi<T extends Human> extends Car<T> {
    public Taxi(int maxSeatCount) {
        super(maxSeatCount);
    }
}
