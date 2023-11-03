package org.example.vehicle;

import org.example.passanger.Firefighter;
import org.example.passanger.Human;
import org.example.passanger.Policeman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Car<Human> car;
    Bus<Human> bus;
    PoliceCar<Policeman> policeCar;
    FireTruck<Firefighter> fireTruck;

    Human jane = new Human("Jane");
    Human rocky = new Human("Rocky");
    Policeman athena = new Policeman("Athena");
    Policeman ben = new Policeman("Ben");
    Policeman billy = new Policeman("Billy");
    Firefighter clark = new Firefighter("Clark");

    @BeforeEach
    void setUp() {
        car = new Car<>(5);
        bus = new Bus<>(20);
        policeCar = new PoliceCar<>(2);
        fireTruck = new FireTruck<>(4);
    }

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
        bus.addPassenger(rocky);
        policeCar.addPassenger(athena);
        policeCar.addPassenger(ben);
        fireTruck.addPassenger(clark);

        assertEquals(1, car.getOccupiedSeatCount());
        assertEquals(1, bus.getOccupiedSeatCount());
        assertEquals(2, policeCar.getOccupiedSeatCount());
        assertEquals(1, fireTruck.getOccupiedSeatCount());

        policeCar.removePassenger(athena);

        assertEquals(1, policeCar.getOccupiedSeatCount());
    }

    @Test
    void testAddPassengerSuccess() {
        car.addPassenger(jane);

        assertSame(jane.getCurrentVehicle(), car);

        car.addPassenger(athena);

        assertSame(athena.getCurrentVehicle(), car);
    }

    @Test
    void testAddPassengerFailed() {
        String noSeats = "No more available seats.";
        String thisVehicle = "This passenger is already inside.";
        String anotherVehicle = "This passenger is already inside another vehicle.";

        policeCar.addPassenger(athena);
        policeCar.addPassenger(billy);

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            policeCar.addPassenger(ben);
        });

        assertEquals(noSeats, ex1.getMessage());

        policeCar.removePassenger(billy);

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            policeCar.addPassenger(athena);
        });

        assertEquals(thisVehicle, ex2.getMessage());

        car.addPassenger(billy);

        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> {
            policeCar.addPassenger(billy);
        });

        assertEquals(anotherVehicle, ex3.getMessage());
    }

    @Test
    void testRemovePassengerSuccess() {
        car.addPassenger(athena);
        car.addPassenger(rocky);

        car.removePassenger(athena);

        assertSame(athena.getCurrentVehicle(), null);
    }

    @Test
    void testRemovePassengerFailed() {
        String noPassenger = "There is no such a passenger.";

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            car.removePassenger(jane);
        });

        assertEquals(noPassenger, ex1.getMessage());
    }
}