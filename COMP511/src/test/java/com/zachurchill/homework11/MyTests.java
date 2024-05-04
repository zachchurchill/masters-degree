package com.zachurchill.homework11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MyTests {
    private QueueImpl<Character> queue;

    @BeforeEach
    public void setUp() {
        this.queue = new QueueImpl<>();
    }

    @Test
    void testQueueInterfaceMethods() {
        assertTrue(queue.isEmpty());
        queue.enqueue('X');
        assertFalse(queue.isEmpty());
        assertEquals('X', queue.dequeue());
        assertTrue(queue.isEmpty());
        queue.enqueue('X');
        queue.enqueue('Y');
        assertEquals('X', queue.dequeue());
        assertEquals('Y', queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testQueueImplThrowsEmptyStackExceptionEmptyDequeue() {
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    void testBadStartingPoint() {
        char [] firstRow = {'.', 'X', 'X', 'X', '.'};
        char [] secondRow = {'.', '.', 'X', '.', '.'};
        char [] thirdRow = {'.', 'X', 'X', 'X', '.'};
        char [][] picture = {firstRow, secondRow, thirdRow};
        FloodFiller filler = new FloodFiller(picture);
        assertThrows(IllegalArgumentException.class, () -> filler.fill(new Point(-1, 0), 'Y'));
        assertThrows(IllegalArgumentException.class, () -> filler.fill(new Point(1, -1), 'Y'));
        assertThrows(IllegalArgumentException.class, () -> filler.fill(new Point(4, 1), 'Y'));
        assertThrows(IllegalArgumentException.class, () -> filler.fill(new Point(1, 5), 'Y'));
    }

    @Test
    void testFillingQueueWithPicture() {
        char [] firstRow = {'.', 'X', 'X', 'X', '.'};
        char [] secondRow = {'.', '.', 'X', '.', '.'};
        char [] thirdRow = {'.', 'X', 'X', 'X', '.'};
        char [][] picture = {firstRow, secondRow, thirdRow};
        FloodFiller filler = new FloodFiller(picture);
        System.out.println(filler.toString());
        filler.fill(new Point(1, 2), 'Y');
        System.out.println(filler.toString());
        char [][] filledPicture = filler.getRawImage();
        assertEquals(3, filledPicture.length);
        assertArrayEquals(new char[] {'.', 'Y', 'Y', 'Y', '.'}, filledPicture[0]);
        assertArrayEquals(new char[] {'.', '.', 'Y', '.', '.'}, filledPicture[1]);
        assertArrayEquals(new char[] {'.', 'Y', 'Y', 'Y', '.'}, filledPicture[2]);
    }

    @Test
    void testProvidedExample() {
        char [] firstRow = {'X', 'X', 'X', 'X', '.', '.', '.', '.', 'X', 'X', 'X', 'X'};
        char [] secondRow = {'X', 'X', '.', '.', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'};
        char [] thirdRow = {'.', 'X', 'X', 'X', '.', '.', '.', 'X', 'X', 'X', 'X', 'X'};
        char [][] picture = {firstRow, secondRow, thirdRow};
        FloodFiller filler = new FloodFiller(picture);
        System.out.println(filler.toString());
        filler.fill(new Point(1, 4), 'Y');
        System.out.println(filler.toString());
        char [][] filledPicture = filler.getRawImage();
        assertEquals(3, filledPicture.length);
        assertArrayEquals(new char[] {'X', 'X', 'X', 'X', '.', '.', '.', '.', 'Y', 'Y', 'Y', 'Y'}, filledPicture[0]);
        assertArrayEquals(new char[] {'X', 'X', '.', '.', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y'}, filledPicture[1]);
        assertArrayEquals(new char[] {'.', 'X', 'X', 'X', '.', '.', '.', 'Y', 'Y', 'Y', 'Y', 'Y'}, filledPicture[2]);
    }
}
