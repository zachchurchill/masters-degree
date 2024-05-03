package com.zachurchill.homework11;

/**
 * For your information only. Don't change this file.
 * Any changes will be overwritten during testing.
 */
public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
