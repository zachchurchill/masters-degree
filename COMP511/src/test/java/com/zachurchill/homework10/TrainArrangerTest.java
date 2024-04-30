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
            // stacks are LIFO so we need to check in reverse
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
        TrainYard yard;
        int [] cars1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] cars2 = {4, 5, 6, 1, 2, 3, 10, 9, 8, 7};
        Car [] expectedOrdering1 = {new Car(1), new Car(2), new Car(10), new Car(9), new Car(3), new Car(4), new Car(8), new Car(7), new Car(5), new Car(6)};
        Car [] expectedOrdering2 = {new Car(10), new Car(1), new Car(9), new Car(2), new Car(8), new Car(3), new Car(7), new Car(4), new Car(6), new Car(5)};

        // INPUT {1, ..., 10}; OUTPUT {Car(1), Car(2), Car(10), Car(9), Car(3), Car(4), Car(8), Car(7), Car(5), Car(6)};
        yard = new TrainYard(cars1);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering1);
        checkArrangedYard(yard, expectedOrdering1);

        // INPUT {1, ..., 10}; OUTPUT {Car(10), Car(1), Car(9), Car(2), Car(8), Car(3), Car(7), Car(4), Car(6), Car(5)};
        yard = new TrainYard(cars1);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering2);
        checkArrangedYard(yard, expectedOrdering2);

        // INPUT {4, 5, 6, 1, 2, 3, 10, 9, 8, 7}; OUTPUT {Car(1), Car(2), Car(10), Car(9), Car(3), Car(4), Car(8), Car(7), Car(5), Car(6)};
        yard = new TrainYard(cars2);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering1);
        checkArrangedYard(yard, expectedOrdering1);

        // INPUT {4, 5, 6, 1, 2, 3, 10, 9, 8, 7}; OUTPUT {Car(10), Car(1), Car(9), Car(2), Car(8), Car(3), Car(7), Car(4), Car(6), Car(5)};
        yard = new TrainYard(cars2);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering2);
        checkArrangedYard(yard, expectedOrdering2);
    }

    @Test
    void test20Cars() {
        TrainYard yard;
        int [] cars1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int [] cars2 = {4, 5, 6, 1, 2, 3, 10, 9, 8, 7, 19, 18, 12, 13, 11, 14, 17, 20, 15, 16};
        Car [] expectedOrdering = {
            new Car(1), new Car(2), new Car(10), new Car(9), new Car(3), new Car(4), new Car(8), new Car(7), new Car(5), new Car(6),
            new Car(20), new Car(11), new Car(13), new Car(12), new Car(19), new Car(17), new Car(18), new Car(15), new Car(14), new Car(16)
        };

        yard = new TrainYard(cars1);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering);
        checkArrangedYard(yard, expectedOrdering);

        yard = new TrainYard(cars2);
        checkInitialState(yard);
        this.trainArranger.arrange(yard, expectedOrdering);
        checkArrangedYard(yard, expectedOrdering);
    }
}
