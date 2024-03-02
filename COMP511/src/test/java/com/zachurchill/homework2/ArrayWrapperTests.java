package com.zachurchill.homework2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ArrayWrapperTests {

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
    void testSomething() {
        fail("Add your own test cases here");
    }
}
