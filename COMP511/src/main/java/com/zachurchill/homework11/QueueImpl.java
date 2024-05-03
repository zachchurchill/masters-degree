package com.zachurchill.homework11;

import java.util.LinkedList;

public class QueueImpl<E> implements Queue<E> {
    private LinkedList<E> list;
    
    public QueueImpl() {
        this.list = new LinkedList<>();
    }
    
    public void enqueue(E element) {
        this.list.addLast(element);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.list.removeFirst();
    }

    public boolean isEmpty() {
        return this.list.size() == 0;
    }
}

