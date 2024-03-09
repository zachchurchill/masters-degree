/**
 * Interfaces as callbacks
 *
 * This test class will contain tests of all the worker callbacks by utilizing
 * the ArrayWrapperExt class.
 */

package com.zachurchill.homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayWrapperExtTests {

    private ArrayWrapperExt wrapper;
    private int CAPACITY = 20;

    private static final double DELTA = 1E-6;

    @BeforeEach
    void setUp() {
        this.wrapper = new ArrayWrapperExt(this.CAPACITY);
    }

    @Test
    void testMinMaxWorker() {
        int[] data = {1, 2, 3, 4, 5};
        for (int i = 0; i < data.length; i++) {
            this.wrapper.add(data[i]);
        }

        MinMaxWorker mm = new MinMaxWorker();
        this.wrapper.accumulate(mm);

        assertEquals(mm.getMin(), 1);
        assertEquals(mm.getMax(), 5);
    }

    @Test
    void testMinMaxWorkerSameNumber() {
        int[] data = {1, 1, 1, 1};
        for (int i = 0; i < data.length; i++) {
            this.wrapper.add(data[i]);
        }

        MinMaxWorker mm = new MinMaxWorker();
        this.wrapper.accumulate(mm);

        assertEquals(mm.getMin(), 1);
        assertEquals(mm.getMax(), 1);
    }

    @Test
    void testAverageWorker() {
        int[] data = {1, 2, 3, 4};
        for (int i = 0; i < data.length; i++) {
            this.wrapper.add(data[i]);
        }

        AverageWorker avg = new AverageWorker();
        this.wrapper.accumulate(avg);

        assertEquals(avg.getAverage(), 2.5, DELTA);
    }

    @Test
    void testCountEqualsWorkerNoMatching() {
        int[] data = {1, 2, 3};
        for (int i = 0; i < data.length; i++) {
            this.wrapper.add(data[i]);
        }

        CountEqualsWorker ceq = new CountEqualsWorker(0);
        this.wrapper.accumulate(ceq);

        assertEquals(ceq.getCount(), 0);
    }

    @Test
    void testCountEqualsWorkerAllMatching() {
        int[] data = {1, 1, 1, 1};
        for (int i = 0; i < data.length; i++) {
            this.wrapper.add(data[i]);
        }

        CountEqualsWorker ceq = new CountEqualsWorker(1);
        this.wrapper.accumulate(ceq);

        assertEquals(ceq.getCount(), 4);
    }

    @Test
    void testCountEqualsWorkerSomeMatching() {
        int[] data = {1, 1, 2};
        for (int i = 0; i < data.length; i++) {
            this.wrapper.add(data[i]);
        }

        CountEqualsWorker ceq = new CountEqualsWorker(1);
        this.wrapper.accumulate(ceq);

        assertEquals(ceq.getCount(), 2);
    }
}

