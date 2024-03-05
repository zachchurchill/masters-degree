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
    void testAddIncreasesSizeUpToCapacity() {
        for (int i = 0; i < this.CAPACITY; i++) {
            assertTrue(this.wrapper.add(i));
        }
    }

    @Test
    void testAddFailsWhenAtCapacity() {
        for (int i = 0; i < this.CAPACITY; i++) {
            this.wrapper.add(i);
        }
        assertFalse(this.wrapper.add(20));
    }

    @Test
    void testGetWorksForDefinedIndexes() {
        this.wrapper.add(10);
        assertEquals(10, this.wrapper.get(0));
        this.wrapper.add(20);
        assertEquals(10, this.wrapper.get(0));
        assertEquals(20, this.wrapper.get(1));
    }

    @Test
    void testGetThrowsIndexExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.wrapper.get(2));
    }

    @Test
    void testPutWorksForDefinedIndexes() {
        this.wrapper.add(10);
        int oldValue = this.wrapper.put(0, 100);
        assertEquals(10, oldValue);
        assertEquals(100, this.wrapper.get(0));

        this.wrapper.add(20);
        oldValue = this.wrapper.put(0, 1000);
        assertEquals(100, oldValue);
        assertEquals(1000, this.wrapper.get(0));
        assertEquals(20, this.wrapper.get(1));
    }

    @Test
    void testPutThrowsIndexExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.wrapper.put(2, 10));
    }

    @Test
    void testDeleteWorksForDefinedIndexes() {
        this.wrapper.add(0);
        assertTrue(this.wrapper.delete(0));
        assertEquals(0, this.wrapper.size());

        this.wrapper.add(0);
        this.wrapper.add(10);
        this.wrapper.add(20);
        this.wrapper.add(30);
        assertEquals(4, this.wrapper.size());

        assertTrue(this.wrapper.delete(2));
        assertEquals(3, this.wrapper.size());
        assertEquals(0, this.wrapper.get(0));
        assertEquals(10, this.wrapper.get(1));
        assertEquals(30, this.wrapper.get(2));

        assertTrue(this.wrapper.delete(0));
        assertEquals(2, this.wrapper.size());
        assertEquals(10, this.wrapper.get(0));
        assertEquals(30, this.wrapper.get(1));
    }

    @Test
    void testDeleteThrowsIndexExceptionForInvalidIndex() {
        assertFalse(this.wrapper.delete(0));
        assertFalse(this.wrapper.delete(2));
    }
}
