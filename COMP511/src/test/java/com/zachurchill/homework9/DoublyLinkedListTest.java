package com.zachurchill.homework9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> linkedList;

    @BeforeEach
    public void setUp() {
        this.linkedList = new DoublyLinkedList<>();
        ListIterator<Integer> itr = this.linkedList.listIterator();
        int [] data = {1, 2, 3, 4, 5};
        for (int datum : data) {
            itr.add(datum);
        }
    }

    @Test
    void testGetGoodIndices() {
        assertEquals(1, this.linkedList.get(0));
        assertEquals(3, this.linkedList.get(2));
        assertEquals(5, this.linkedList.get(4));
    }

    @Test
    void testGetBadIndices() {
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.get(-1));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.get(5));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.get(1000));
    }

    @Test
    void testSetGoodIndices() {
        assertEquals(2, this.linkedList.set(1, 99));
        assertEquals(99, this.linkedList.get(1));
    }

    @Test
    void testSetBadIndices() {
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.set(-1, null));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.set(5, null));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.set(1000, null));
    }

    @Test
    void testRemoveHead() {
        this.linkedList.remove(0);
        assertEquals(4, this.linkedList.size());
        assertEquals(2, this.linkedList.get(0));
    }

    @Test
    void testRemoveMiddle() {
        this.linkedList.remove(2);
        assertEquals(4, this.linkedList.size());
        assertEquals(4, this.linkedList.get(2));
    }

    @Test
    void testRemoveTail() {
        this.linkedList.remove(4);
        assertEquals(4, this.linkedList.size());
        assertEquals(4, this.linkedList.get(3));
    }

    @Test
    void testRemoveBadIndices() {
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.remove(-1));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.remove(5));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.remove(1000));
    }

    @Test
    void testInsertBadIndices() {
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.insert(null, -1));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.insert(null, 6));  // size() ok
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.insert(null, 1000));
    }

    @Test
    void testInsertHead() {
        this.linkedList.insert(99, 0);
        assertEquals(6, this.linkedList.size());
        int [] expectedData = {99, 1, 2, 3, 4, 5};
        for (int i = 0; i < 6; ++i) {
            assertEquals(expectedData[i], this.linkedList.get(i));
        }
    }

    @Test
    void testInsertMiddle() {
        this.linkedList.insert(99, 2);
        assertEquals(6, this.linkedList.size());
        int [] expectedData = {1, 2, 99, 3, 4, 5};
        for (int i = 0; i < 6; ++i) {
            assertEquals(expectedData[i], this.linkedList.get(i));
        }
    }

    @Test
    void testInsertTail() {
        this.linkedList.insert(99, 5);
        assertEquals(6, this.linkedList.size());
        int [] expectedData = {1, 2, 3, 4, 5, 99};
        for (int i = 0; i < 6; ++i) {
            assertEquals(expectedData[i], this.linkedList.get(i));
        }
    }

    @Test
    void testIndexOfInvalidIndex() {
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.indexOf(1, -1));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.indexOf(1, 5));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.indexOf(1, 1000));
    }

    @Test
    void testIndexOfAtStart() {
        // Add duplicates for testing
        this.linkedList.insert(3, 5);
        this.linkedList.insert(2, 6);
        assertEquals(1, this.linkedList.indexOf(2, 0));
    }

    @Test
    void testIndexOfAfter() {
        // Add duplicates for testing
        this.linkedList.insert(3, 5);
        this.linkedList.insert(2, 6);
        assertEquals(6, this.linkedList.indexOf(2, 3));
    }

    @Test
    void testIndexNotFound() {
        // Add duplicates for testing
        this.linkedList.insert(3, 5);
        this.linkedList.insert(2, 6);
        assertEquals(-1, this.linkedList.indexOf(99, 0));
    }

    @Test
    void testLastIndexOfInvalidIndex() {
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.lastIndexOf(1, -1));
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.lastIndexOf(1, 6));  // size() ok
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.lastIndexOf(1, 1000));
    }

    @Test
    void testLastIndexNotFound() {
        // Add duplicates for testing
        this.linkedList.insert(3, 5);
        this.linkedList.insert(2, 6);
        assertEquals(-1, this.linkedList.lastIndexOf(99, 7));
    }

    @Test
    void testLastIndexOfAtEndStart() {
        // Add duplicates for testing
        this.linkedList.insert(3, 5);
        this.linkedList.insert(2, 6);
        assertEquals(6, this.linkedList.lastIndexOf(2, 7));
    }

    @Test
    void testLastIndexOfAtEnd() {
        // Add duplicates for testing
        this.linkedList.insert(3, 5);
        this.linkedList.insert(2, 6);
        assertEquals(6, this.linkedList.lastIndexOf(2, 6));
    }

    @Test
    void testLastIndexOfAfter() {
        // Add duplicates for testing
        this.linkedList.insert(3, 5);
        this.linkedList.insert(2, 6);
        assertEquals(1, this.linkedList.lastIndexOf(2, 5));
    }
}
