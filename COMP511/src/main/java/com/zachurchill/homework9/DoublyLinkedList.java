package com.zachurchill.homework9;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    // All members are public for testing
    public Link<E> head;
    public int size;

    public DoublyLinkedList() {
        // don't change this constructor
        // set up circular property and dummy header
        head = new Link<E>();
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public static class Link<E> {
        // All members are public for testing
        public E data;
        public Link<E> next;
        public Link<E> prev;

        public Link() {
        }

        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            this.data = null;
        }

        public Link<E> append(E data) {
            Link<E> link = new Link();
            link.prev = this;
            link.data = data;
            link.next = this.next;

            // Update `this` pointers
            this.next.prev = link;
            this.next = link;
            return link;
        }

        public Link<E> prepend(E data) {
            Link<E> link = new Link();
            link.prev = this.prev;
            link.data = data;
            link.next = this;

            // Update `this` pointers
            this.prev.next = link;
            this.prev = link;
            return link;
        }
    }

    public int size() {
        return this.size;
    }

    /**
     * Retrieves the data in the linked list at the given "index".
     * This should not alter the list in any way. Valid indices should
     * be between 0 and size-1. You should take the shorter path
     * to reach the index (working backward from the end or forward
     * from the beginning).
     * @param index the index of the element to retrieve
     * @return the data element at that index
     * @throws IllegalArgumentException for bad indices
     */
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        ListIterator<E> itr = this.listIterator(index);
        return itr.next();
    }

    /**
     * Overwrite the data in the linked list at the given "index"
     * with the new value. It should return the old value at that index.
     * Valid indices should be between 0 and size-1. You should take the
     * shorter path to reach the index (working backward from the end
     * or forward from the beginning).
     * @param index the index of the element to overwrite
     * @param value the value to overwrite with
     * @return the previous data element at that index
     * @throws IllegalArgumentException for bad indices
     */
    public E set(int index, E value) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        ListIterator<E> itr = this.listIterator(index);
        E result = itr.next();
        itr.set(value);
        return result;
    }

    /**
     * Find the first index (relative to the starting index) of the
     * parameter element  in the list. For example, given a list of
     * integers like [3, 1, 4, 1, 5, 9, 2, 6], then
     * indexOf(5, 0) should return 4 because 5 is at the 4th index from 0
     * indexOf(5, 5) should return -1 because no 5 appears after index 5
     * indexOf(1, 0) should return 1 because 1 is found at index 1 after 0
     * indexOf(3, 99) should throw an IllegalArgumentException because
     *     the list only contains 8 elements.
     * @param element the thing to find
     * @param start the starting index for the search
     * @return the index where it is found or -1 if not found
     * @throws IllegalArgumentException for bad indices
     */
    public int indexOf(E element, int start) {
        if (start < 0 || start >= size()) {
            throw new IllegalArgumentException();
        }
        int foundIndex = -1;
        ListIterator<E> itr = this.listIterator(start);
        while (itr.hasNext()) {
            if (itr.next() == element) {
                foundIndex = itr.previousIndex();
                break;
            }
        }
        return foundIndex;
    }

    /**
     * Find the last index (relative to the ending index) of the
     * parameter element  in the list. For example, given a list of
     * integers like [3, 1, 4, 1, 5, 9, 2, 6], then
     * lastIndexOf(5, 8) should return 4 because 5 is at the 4th when
     * working backwards form 8
     * lastIndexOf(5, 3) should return -1 because no 5 appears before index 3
     * lastIndexOf(1, 8) should return 3 because 1 is found at index 3
     * when working backwards from index 8
     * indexOf(3, 99) should throw an IllegalArgumentException because
     *     the list only contains 8 elements.
     * @param element the thing to find
     * @param end the end index for the search
     * @throws IllegalArgumentException for bad indices
     * @return the index where it is found or -1 if not found
     */
    public int lastIndexOf(E element, int start) {
        if (start < 0 || start > size()) {
            throw new IllegalArgumentException();
        }
        int foundIndex = -1;
        ListIterator<E> itr = start == size() ? this.listIterator(start) : this.listIterator(start + 1);
        while (itr.hasPrevious()) {
            if (itr.previous() == element) {
                foundIndex = itr.nextIndex() - 1;
                break;
            }
        }
        return foundIndex;
    }

    /**
     * Inserts the element into the list at the given index.
     * For example, given a list of integers like
     * [3, 1, 4, 1, 5, 9, 2, 6], then
     *   insert(99, 0) should yield a list [99, 3, 1, 4, 1, 5, 9, 2, 6]
     *   insert(99, 8) should yield a list [3, 1, 4, 1, 5, 9, 2, 6, 99]
     *   insert(99, 4) should yield a list [3, 1, 4, 1, 99, 5, 9, 2, 6]
     * @param element the thing to insert
     * @param index the index at which to insert
     * @throws IllegalArgumentException for bad indices
     */
    public void insert(E element, int index) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException();
        }
        ListIterator<E> itr = this.listIterator(index);
        itr.add(element);
    }

    /**
     * Removes the element from the list at the specified index.
     * For example, given a list of integers like
     * [3, 1, 4, 1, 5, 9, 2, 6], then
     *   remove(0) should yield a list [1, 4, 1, 5, 9, 2, 6]
     *   remove(7) should yield a list [3, 1, 4, 1, 5, 9, 2]
     *   remove(4) should yield a list [3, 1, 4, 1, 9, 2, 6]
     * @param element the thing to insert
     * @param index the index at which to insert
     * @throws IllegalArgumentException for bad indices
     */
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        ListIterator<E> itr = this.listIterator(index);
        itr.next();
        itr.remove();
    }

    /**
     * This might help you debug
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Link<E> link = this.head.next;
        builder.append("[");
        while (link != head) {
            if (builder.length() == 1) {
                builder.append(String.valueOf(link.data));
            } else {
                builder.append(", ");
                builder.append(String.valueOf(link.data));
            }
            link = link.next;
        }
        builder.append("]");
        return builder.toString();
    }

    public Iterator<E> iterator() {
        return listIterator();
    }
    
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        return new DoublyLinkedListIterator(index);
    }

    private class DoublyLinkedListIterator implements ListIterator<E> {

        public Link<E> cursor;
        public Link<E> priorCursor;
        public int cursorIndex;

        public DoublyLinkedListIterator(int startIndex) {
            if (startIndex < 0 || startIndex > size()) {
                throw new IndexOutOfBoundsException("invalid index");
            }
            if (startIndex < size() / 2) {
                this.cursor = head.next;
                for (int i = 0; i < startIndex; ++i) {
                    this.cursor = this.cursor.next;
                }
            } else {
                this.cursor = head;
                for (int i = size(); i > startIndex; --i) {
                    this.cursor = this.cursor.prev;
                }
            }
            this.cursorIndex = startIndex;
        }

        public boolean hasNext() {
            return this.cursor != head;
        }

        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            E result = this.cursor.data;
            this.priorCursor = this.cursor;
            this.cursor = this.cursor.next;
            ++cursorIndex;
            return result;
        }

        public boolean hasPrevious() {
            return this.cursor.prev != head;
        }

        public E previous() {
            if (!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            cursor = cursor.prev;
            priorCursor = cursor;
            --cursorIndex;
            return cursor.data;
        }

        public void remove() {
            if (this.priorCursor == this.cursor) {
                this.cursor = this.cursor.next;  // called previous
            } else {
                --cursorIndex;  // called next
            }
            this.priorCursor.remove();
            this.priorCursor = null;
            --size;
            
        }

        public void add(E element) {
            this.cursor.prepend(element);
            ++size;
            ++this.cursorIndex;
        }

        public void set(E element) {
            this.priorCursor.data = element;
        }

        public int nextIndex() {
            return cursorIndex + 1;
        }

        public int previousIndex() {
            return cursorIndex - 1;
        }
    }
}

