package com.zachurchill.homework10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainArrangerTest {

    private TrainArranger trainArranger;

    @BeforeEach
    void setUp() {
        this.trainArranger = new TrainArranger();
    }

    private void checkInitialState(TrainYard yard) {
        assertNotNull(yard.frontOf(Track.INPUT));
        assertNull(yard.frontOf(Track.SIDING));
        assertNull(yard.frontOf(Track.OUTPUT));
    }

    private void checkArrangedYard(TrainYard yard, Car [] expectedOrdering) {
        assertNull(yard.frontOf(Track.INPUT));
        assertNull(yard.frontOf(Track.SIDING));
        assertNotNull(yard.frontOf(Track.OUTPUT));
        Rail outputRail = yard.getOutputRail();
        for (int i = expectedOrdering.length - 1; i >= 0; --i) {
            // stacks are last-in-first-out so we need to check in reverse
            assertEquals(expectedOrdering[i], outputRail.pop());
        }
    }

    @Test
    void testNoCars() {
        int [] cars = {};
        TrainYard yard = new TrainYard(cars);
        assertNull(yard.frontOf(Track.INPUT));
        assertNull(yard.frontOf(Track.SIDING));
        assertNull(yard.frontOf(Track.OUTPUT));

        Car [] expectedOrdering = {};
        this.trainArranger.arrange(yard, expectedOrdering);
        assertNull(yard.frontOf(Track.INPUT));
        assertNull(yard.frontOf(Track.SIDING));
        assertNull(yard.frontOf(Track.OUTPUT));
    }

    @Test
    void test1Car() {
        int [] cars = {1};
        TrainYard yard = new TrainYard(cars);
        checkInitialState(yard);
        Car [] expectedOrdering = {new Car(1)};
        this.trainArranger.arrange(yard, expectedOrdering);
        checkArrangedYard(yard, expectedOrdering);
    }

    @Test
    void test2Cars() {
        TrainYard yard;
        int [] cars1 = {1, 2};
        int [] cars2 = {2, 1};
        Car [] expectedOrdering1 = {new Car(1), new Car(2)};
        Car [] expectedOrdering2 = {new Car(2), new Car(1)};

        // INPUT {1, 2}; OUTPUT {Car(1), Car(2)}
        yard = new TrainYard(cars1);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering1);
        checkArrangedYard(yard, expectedOrdering1);

        // INPUT {1, 2}; OUTPUT {Car(2), Car(1)}
        yard = new TrainYard(cars1);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering2);
        checkArrangedYard(yard, expectedOrdering2);

        // INPUT {2, 1}; OUTPUT {Car(1), Car(2)}
        yard = new TrainYard(cars2);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering1);
        checkArrangedYard(yard, expectedOrdering1);

        // INPUT {2, 1}; OUTPUT {Car(2), Car(1)}
        yard = new TrainYard(cars2);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering2);
        checkArrangedYard(yard, expectedOrdering2);
    }

    @Test
    void test10Cars() {
        fail("Write your test case here.");
    }

    @Test
    void test20Cars() {
        fail("Write your test case here.");
    }
}
