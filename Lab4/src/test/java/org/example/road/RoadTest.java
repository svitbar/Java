package org.example.road;

import org.example.passanger.Firefighter;
import org.example.passanger.Human;
import org.example.passanger.Policeman;
import org.example.vehicle.Bus;
import org.example.vehicle.Car;
import org.example.vehicle.FireTruck;
import org.example.vehicle.PoliceCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {
    Road road1;
    Road road2;

    Car<Human> car1;
    Car<Human> car2;
    Bus<Human> bus;
    PoliceCar<Policeman> policeCar;
    FireTruck<Firefighter> fireTruck;

    Human jane = new Human("Jane");
    Human alice = new Human("Alice");
    Policeman athena = new Policeman("Athena");
    Policeman ben = new Policeman("Ben");
    Firefighter abby = new Firefighter("Abby");

    @BeforeEach
    void setUp() {
        road1 = new Road();
        road2 = new Road();
        car1 = new Car<>(5);
        car2 = new Car<>(2);
        bus = new Bus<>(20);
        policeCar = new PoliceCar<>(2);
        fireTruck = new FireTruck<>(3);
    }

    @Test
    void testGetCountOfHumans() {
        car1.addPassenger(abby);
        road1.addCarToRoad(car1);

        assertEquals(1, road1.getCountOfHumans());

        car1.addPassenger(jane);
        car1.addPassenger(alice);
        car1.addPassenger(ben);

        assertEquals(4, road1.getCountOfHumans());

        car1.removePassenger(jane);

        assertEquals(3, road1.getCountOfHumans());

        policeCar.addPassenger(athena);
        road1.addCarToRoad(policeCar);

        assertEquals(4, road1.getCountOfHumans());
    }

    @Test
    void testAddCarToRoadSuccess() {
        car1.addPassenger(athena);
        road1.addCarToRoad(car1);

        assertSame(car1.getCurrentRoad(), road1);

        car2.addPassenger(ben);
        road1.addCarToRoad(car2);

        assertSame(car2.getCurrentRoad(), road1);

        fireTruck.addPassenger(abby);
        road2.addCarToRoad(fireTruck);

        assertSame(fireTruck.getCurrentRoad(), road2);
    }

    @Test
    void testAddCarToRoadFailed() {
        String thisRoad = "Vehicle is already on this road.";
        String anotherRoad = "Vehicle is already on another road.";
        String withoutDriver = "Vehicle cannot be without a driver.";

        car1.addPassenger(jane);
        road1.addCarToRoad(car1);

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            road1.addCarToRoad(car1);
        });

        assertEquals(thisRoad, ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            road2.addCarToRoad(car1);
        });

        assertEquals(anotherRoad, ex2.getMessage());

        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> {
            road1.addCarToRoad(bus);
        });

        assertEquals(withoutDriver, ex3.getMessage());
    }

    @Test
    void testRemoveCarFromRoadSuccess() {
        car1.addPassenger(athena);
        road1.addCarToRoad(car1);

        car2.addPassenger(ben);
        road1.addCarToRoad(car2);

        fireTruck.addPassenger(abby);
        road2.addCarToRoad(fireTruck);

        road1.removeCarFromRoad(car1);

        assertSame(car1.getCurrentRoad(), null);

        road2.removeCarFromRoad(fireTruck);

        assertSame(car1.getCurrentRoad(), null);
    }

    @Test
    void testRemoveCarFromRoadFailed() {
        String noVehicle = "There is no such a vehicle on the road.";

        car1.addPassenger(jane);

        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            road1.removeCarFromRoad(car1);
        });

        assertEquals(noVehicle, ex1.getMessage());
    }
}