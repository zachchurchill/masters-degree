package com.zachurchill.homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StreaksTests {

    @BeforeEach
    public void setUp() {
    }

    private void checker(int expected, int [] input) {
        assertEquals(expected, Streaks.countStreaks(input));
    }

    @Test
    void testExampleOne() {
        int [] input = new int [] {1, 2, 2, 3, 3, 2, 4};
        checker(2, input);
    }

    @Test
    void testExampleTwo() {
        int [] input = new int [] {1, 1, 1, 1};
        checker(1, input);
    }

    @Test
    void testExampleThree() {
        int [] input = new int [] {1, 2, 1, 2};
        checker(0, input);
    }

    @Test
    void testEmpty() {
        int [] input = new int [0];
        checker(0, input);
    }
}
