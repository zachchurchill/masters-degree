package com.zachurchill.homework2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * The test class Car.
 *
 * @author Zach Churchill
 * @version 2024-03-03
 */
class CarTests {

    private double defaultTankCapacity;
    private double defaultEfficiency;

    @BeforeEach
    void setUp() {
        this.defaultTankCapacity = 15;
        this.defaultEfficiency = 15;
    }

    @Test
    void testMinimumTankCapacity() {
        Car lessThanFifteen = new Car(10, this.defaultEfficiency);
        Car equalToFifteen = new Car(15, this.defaultEfficiency);
        Car moreThanFifteen = new Car(20, this.defaultEfficiency);
        
        assertEquals(15, lessThanFifteen.getTankCapacity());
        assertEquals(15, equalToFifteen.getTankCapacity());
        assertEquals(20, moreThanFifteen.getTankCapacity());
    }

    @Test
    void testMinimumEfficiency() {
        Car lessThanFifteen = new Car(this.defaultTankCapacity, 10);
        Car equalToFifteen = new Car(this.defaultTankCapacity, 15);
        Car moreThanFifteen = new Car(this.defaultTankCapacity, 20);
        
        assertEquals(15, lessThanFifteen.getEfficiency());
        assertEquals(15, equalToFifteen.getEfficiency());
        assertEquals(20, moreThanFifteen.getEfficiency());
    }

    @Test
    void testTankDefaultsToZero() {
        Car newCar = new Car(this.defaultTankCapacity, this.defaultEfficiency);
        assertEquals(0, newCar.getRemainingGas());
    }

    @Test
    void testOdometerDefaultsToZero() {
        Car newCar = new Car(this.defaultTankCapacity, this.defaultEfficiency);
        assertEquals(0, newCar.getMilesDriven());
    }

    @Test
    void testFillCapsOutAtTankCapacity() {
        double tankCapacity = 15;
        Car newCar = new Car(tankCapacity, this.defaultEfficiency);
        newCar.fill(10);
        assertEquals(10, newCar.getRemainingGas());

        // 10 + 10 > tankCapacity; thus, tankCapacity with spillage
        newCar.fill(10);
        assertEquals(tankCapacity, newCar.getRemainingGas());
    }

    @Test
    void testDrivingCapsOutWhenFuelsGone() {
        double tankCapacity = 20;
        double efficiency = 20;
        Car newCar = new Car(tankCapacity, efficiency);

        // Only 1 gallon to simplify things
        newCar.fill(1);

        newCar.drive(10);
        assertEquals(10, newCar.getMilesDriven());
        assertEquals(0.5, newCar.getRemainingGas());

        // 20 + 10 > 20 MPG * 1 G; thus, drive until out of gas - 10 more miles
        newCar.drive(20);
        assertEquals(20, newCar.getMilesDriven());
        assertEquals(0, newCar.getRemainingGas());
    }
}
