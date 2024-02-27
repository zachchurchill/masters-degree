package com.zachurchill.homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FinderTests {

    @BeforeEach
    public void setUp() {
    }

    private void checker(int expected, String s) {
        assertEquals(expected, Finder.findAndAdd(s), " for string '" + s + "'");
    }

    @Test
    void testExampleOne() {
        String s = "xyz432abc";
        checker(432, s);
    }

    @Test
    void testExampleTwo() {
        String s = "xyz432abc444";
        checker(876, s);
    }

    @Test
    void testExampleThree() {
        String s = "123";
        checker(123, s);
    }

    @Test
    void testExampleFour() {
        String s = "1 1 2 3 5";
        checker(12, s);
    }

    @Test
    void testExampleFive() {
        String s = "abcxyz";
        checker(0, s);
    }
}
