package com.zachurchill.homework6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ArrayWrapperTest {

    private ArrayWrapper wrapper;
    private int CAPACITY = 20;

    @BeforeEach
    public void setUp() {
        wrapper = new ArrayWrapper(CAPACITY);
    }

    @Test
    void testConstruction() {
        assertEquals(0, wrapper.size(), "Size wrong on newly constructed ArrayWrapper");
    }

    @Test
    void testAdd() {
        for (int i = 0; i < this.CAPACITY; i++) {
            assertTrue(wrapper.add(i));
        }
        assertFalse(wrapper.add(1000));
    }

    @Test
    void testGet() {
        wrapper.add(10);
        wrapper.add(20);
        assertEquals(10, wrapper.get(0));
        assertEquals(20, wrapper.get(1));

        boolean caught = false;
        try {
            wrapper.get(2);
        } catch (IndexOutOfBoundsException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    void testPut() {
        wrapper.add(10);
        wrapper.add(20);
        assertEquals(10, wrapper.put(0, 100));
        assertEquals(100, wrapper.get(0));

        boolean caught = false;
        try {
            wrapper.put(2, 1000);
        } catch(IndexOutOfBoundsException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    void testDelete() {
        wrapper.add(10);
        wrapper.add(20);
        wrapper.add(30);
        assertTrue(wrapper.delete(0));
        assertEquals(2, wrapper.size());
        assertEquals(20, wrapper.get(0));
        assertEquals(30, wrapper.get(1));

        assertFalse(wrapper.delete(2));
    }

    @Test
    void testSwap() {
        wrapper.add(10);
        wrapper.add(20);
        wrapper.add(30);
        wrapper.swap(0, 2);
        assertEquals(30, wrapper.get(0));
        assertEquals(20, wrapper.get(1));
        assertEquals(10, wrapper.get(2));

        boolean caught = false;
        try {
            wrapper.swap(1, 3);
        } catch (IndexOutOfBoundsException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    void testAccumulate() {
        class CallCountWorker implements Worker<Integer> {
            private int calls = 0;

            public void work(Integer input) {
                this.calls++;
            }

            public int getCallCount() {
                return this.calls;
            }
        }
        CallCountWorker callCount = new CallCountWorker();
        wrapper.add(10);
        wrapper.add(20);
        wrapper.accumulate(callCount);
        assertEquals(2, callCount.getCallCount());
    }
}
