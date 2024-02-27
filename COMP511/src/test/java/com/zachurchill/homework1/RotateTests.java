package com.zachurchill.homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class RotateTests {

    @BeforeEach
    public void setUp() {
    }

    @Test
    void testNoRotation() {
        int [] array = new int [] {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int [] result = Rotate.rotateArray(array, 0);
        assertNotSame(array, result);
        assertEquals(array.length, result.length);
        assertArrayEquals(array, result);
    }
    
    @Test
    void testExampleOne() {
        int [] array = new int [] {1, 2, 3, 4, 5};
        int [] result = Rotate.rotateArray(array, -1);
        int [] expected = new int [] {2, 3, 4, 5, 1};
        assertNotSame(array, result);
        assertEquals(expected.length, result.length);
        assertArrayEquals(expected, result);
    }

    @Test
    void testExampleTwo() {
        int [] array = new int [] {-12, 55};
        int [] result = Rotate.rotateArray(array, -3);
        int [] expected = new int [] {55, -12};
        assertNotSame(array, result);
        assertEquals(expected.length, result.length);
        assertArrayEquals(expected, result);
    }

    @Test
    void testExampleThree() {
        int [] array = new int [] {1, 1, 2, 3, 5, 8, 11};
        int [] result = Rotate.rotateArray(array, 2);
        int [] expected = new int [] {8, 11, 1, 1, 2, 3, 5};
        assertEquals(expected.length, result.length);
        assertArrayEquals(expected, result);
    }

    @Test
    void testExampleFour() {
        int [] array = new int [] {};
        int [] result = Rotate.rotateArray(array, 1);
        int [] expected = new int [] {};
        assertNotSame(array, result);
        assertEquals(expected.length, result.length);
        assertArrayEquals(expected, result);
    }
}
