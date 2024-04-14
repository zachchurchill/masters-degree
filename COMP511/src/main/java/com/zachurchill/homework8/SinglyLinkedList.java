package com.zachurchill.homework8;

public class SinglyLinkedList<E> {

    // All members are public for testing
    public Link<E> head;
    public Link<E> tail;
    public int size;

    public SinglyLinkedList() {
        // don't change this constructor
        head = tail = null;
        size = 0;
    }

    public static class Link<E> {
        // All members are public for testing
        public E data;
        public Link<E> next;
    }

    /**
     * Retrieves the data in the linked list at the given "index".
     * This should not alter the list in any way. Valid indices should
     * be between 0 and size-1.
     * @param index the index of the element to retrieve
     * @return the data element at that index
     * @throws IndexOutOfBoundsException for bad indices
     */
    public E get(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Overwrite the data in the linked list at the given "index"
     * with the new value. It should return the old value at that index.
     * Valid indices should be between 0 and size-1.
     * @param index the index of the element to overwrite
     * @param value the value to overwrite with
     * @return the previous data element at that index
     * @throws IndexOutOfBoundsException for bad indices
     */
    public E set(int index, E value) {
        throw new UnsupportedOperationException();
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
     */
    public int indexOf(E element, int start) {
        throw new UnsupportedOperationException();
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
     * @return the index where it is found or -1 if not found
     */
    public int lastIndexOf(E element, int start) {
        // this is tricky because you can't move backwards
        // through a singly linked list.
        throw new UnsupportedOperationException();
    }

    /**
     * Create a copy of the list between [start, stop) indices.
     * this should return a new list with new links with the data
     * contained in those links. For example, given a list of
     * integers like [3, 1, 4, 1, 5, 9, 2, 6], then
     * slice(2, 4) should return [4, 1]
     * slice(2, 2) should return [] (an empty list)
     * @param start the left bound (inclusive) of the slice
     * @param stop the right bound (exclusive) of the slice
     * @return a new list with the data between the indices
     * @throws IllegalArgumentException when the indices are invalid
     */
    public SinglyLinkedList<E> slice(int start, int stop) {
        throw new UnsupportedOperationException();
    }

    /**
     * This might help you debug
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Link<E> link = this.head;
        builder.append("[");
        while (link != null) {
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
}

