package com.zachurchill.homework8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    private SinglyLinkedList<String> linkedList;

    @BeforeEach
    public void setUp() {
        this.linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testIndexOutOfBoundsForNegativeIndexGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.get(-1));
    }

    @Test
    public void testIndexOutOfBoundsForZeroIndexGetOnNewList() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.get(0));
    }

    @Test
    public void testIndexOutOfBoundsForLargerIndexThanSizeGet() {
        this.linkedList.add("zero");
        assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.get(1));
    }

    @Test
    public void testGetCorrectlyReturnsElement() {
        this.linkedList.add("zero");
        this.linkedList.add("one");
        assertEquals("zero", this.linkedList.get(0));
        assertEquals("one", this.linkedList.get(1));
    }


    @Test
    public void testIllegalArgumentExceptionForLargerIndexThanSizeIndexOf() {
        this.linkedList.add("zero");
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.indexOf("nada", 1));
    }

    @Test
    public void testIndexOfExamples() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        this.linkedList.add("one");
        this.linkedList.add("five");
        this.linkedList.add("nine");
        this.linkedList.add("two");
        this.linkedList.add("six");
        assertEquals(4, this.linkedList.indexOf("five", 0));
        assertEquals(-1, this.linkedList.indexOf("five", 5));
        assertEquals(1, this.linkedList.indexOf("one", 0));
    }

    @Test
    public void testIllegalArgumentExceptionForLargerIndexThanSizeLastIndexOf() {
        this.linkedList.add("zero");
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.lastIndexOf("nada", 99));
    }

    @Test
    public void testLastIndexOfExamples() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        this.linkedList.add("one");
        this.linkedList.add("five");
        this.linkedList.add("nine");
        this.linkedList.add("two");
        this.linkedList.add("six");
        assertEquals(4, this.linkedList.lastIndexOf("five", 7));
        assertEquals(-1, this.linkedList.lastIndexOf("five", 3));
        assertEquals(3, this.linkedList.lastIndexOf("one", 7));
    }

    @Test
    public void testLastIndexOfAtEnd() {
        this.linkedList.add("four");
        this.linkedList.add("six");
        this.linkedList.add("one");
        this.linkedList.add("three");
        this.linkedList.add("nine");
        this.linkedList.add("two");
        this.linkedList.add("four");
        this.linkedList.add("one");
        this.linkedList.add("five");
        this.linkedList.add("twelve");
        this.linkedList.add("three");
        this.linkedList.add("zero");
        this.linkedList.add("one");
        this.linkedList.add("eight");
        this.linkedList.add("three");
        this.linkedList.add("thirty one");
        assertEquals(12, this.linkedList.lastIndexOf("one", 12));
    }

    @Test
    public void testSliceIllegalArgumentExceptionStartNegative() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.slice(-1, 2));
    }

    @Test
    public void testSliceIllegalArgumentExceptionStopNegative() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.slice(1, -2));
    }

    @Test
    public void testSliceIllegalArgumentExceptionStartLargerThanSize() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.slice(3, 5));
    }

    @Test
    public void testSliceIllegalArgumentExceptionStopLargerThanSize() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.slice(1, 5));
    }

    @Test
    public void testSliceIllegalArgumentExceptionStopLessThanStart() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        this.linkedList.add("one");
        this.linkedList.add("five");
        this.linkedList.add("nine");
        this.linkedList.add("two");
        this.linkedList.add("six");
        assertThrows(IllegalArgumentException.class, () -> this.linkedList.slice(2, 1));
    }

    @Test
    public void testSliceExamples() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        this.linkedList.add("one");
        this.linkedList.add("five");
        this.linkedList.add("nine");
        this.linkedList.add("two");
        this.linkedList.add("six");

        SinglyLinkedList<String> example1 = new SinglyLinkedList<>();
        example1.add("four");
        example1.add("one");
        assertEquals(example1.toString(), this.linkedList.slice(2, 4).toString());

        SinglyLinkedList<String> example2 = new SinglyLinkedList<>();
        assertEquals(example2.toString(), this.linkedList.slice(2, 2).toString());
    }

    @Test
    public void testIndexOutOfBoundsErrorForSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.linkedList.set(1, "fifty"));
    }

    @Test
    public void testSet() {
        this.linkedList.add("three");
        this.linkedList.add("one");
        this.linkedList.add("four");
        this.linkedList.add("one");
        this.linkedList.add("five");
        this.linkedList.add("nine");
        this.linkedList.add("two");
        this.linkedList.add("six");
        assertEquals("five", this.linkedList.set(4, "fifty"));
        assertEquals("fifty", this.linkedList.get(4));
    }
}
