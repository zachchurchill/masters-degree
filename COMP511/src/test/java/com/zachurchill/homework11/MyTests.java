package com.zachurchill.homework11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MyTests {
    private QueueImpl<Integer> queue;

    @BeforeEach
    public void setUp() {
        this.queue = new QueueImpl<>();
    }

    @Test
    void testQueueInterfaceMethods() {
        assertTrue(queue.isEmpty());
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        assertEquals(10, queue.dequeue());
        assertTrue(queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testQueueImplThrowsEmptyStackExceptionEmptyDequeue() {
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }
}
