package org.example.vehicle;

import org.example.passanger.Policeman;

public class PoliceCar<T extends Policeman> extends Car<T> {

    public PoliceCar(int seatCount) {
        super(seatCount);
    }
}
