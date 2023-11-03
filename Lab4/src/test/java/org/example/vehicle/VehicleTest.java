package org.example.vehicle;

import org.example.passanger.Firefighter;
import org.example.passanger.Human;
import org.example.passanger.Policeman;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Car<Human> car = new Car<>(5);
    Bus<Human> bus = new Bus<>(20);
    PoliceCar<Policeman> policeCar = new PoliceCar<>(2);
    FireTruck<Firefighter> fireTruck = new FireTruck<>(4);

    Human jane = new Human("Jane");
    Human rocky = new Human("Rocky");
    Human rosy = new Human("Rosy");
    Policeman athena = new Policeman("Athena");
    Policeman ben = new Policeman("Ben");
    Policeman kate = new Policeman("Kate");
    Firefighter abby = new Firefighter("Abby");
    Firefighter clark = new Firefighter("Clark");
    Firefighter billy = new Firefighter("Billy");

//    @BeforeEach
//    void setUp() {
//        car.addPassenger();
//    }

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void testGetMaxSeatCount() {
        assertEquals(5, car.getMaxSeatCount());
        assertEquals(20, bus.getMaxSeatCount());
        assertEquals(2, policeCar.getMaxSeatCount());
        assertEquals(4, fireTruck.getMaxSeatCount());
    }

    @Test
    void testGetOccupiedSeatCount() {
        assertEquals(0, car.getOccupiedSeatCount());
        assertEquals(0, bus.getOccupiedSeatCount());
        assertEquals(0, policeCar.getOccupiedSeatCount());
        assertEquals(0, fireTruck.getOccupiedSeatCount());

        car.addPassenger(jane);
    }

    @Test
    void testAddPassenger() {
    }

    @Test
    void testRemovePassenger() {
    }
}