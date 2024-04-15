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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("provide valid index");
        }
        Link<E> current = head;
        for (int i = 0; i < size; ++i) {
            if (i == index) {
                break;
            } else {
                current = current.next;
            }
        }
        return current.data;
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
        if (start < 0 || start >= size) {
            throw new IllegalArgumentException("provide valid index");
        }
        for (int i = start; i < size; ++i) {
            if (get(i) == element) {
                return i;
            }
        }
        return -1;
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
    public int lastIndexOf(E element, int end) {
        if (end < 0 || end > size) {
            throw new IllegalArgumentException("provide valid index");
        }
        int lastIndex = -1;
        for (int i = 0; i <= end; ++i) {
            E el = get(i);
            if (el == element) {
                lastIndex = i;
            }
        }
        return lastIndex;
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

    /* ~~~~~~~~ Following methods from week8.jar file ~~~~~~~~ */

    /**
     * This method will append copies of the links
     * of the parameter list to "this" list at the
     * end. The method should not change the other list.
     * 
     * For example, given two lists:
     *  list_1 = [1, 2, 3]
     *  list_2 = [4, 5, 6]
     * then list_1.append(list_2) should make list_1
     * contain [1, 2, 3, 4, 5, 6] and list_2 should
     * still be [4, 5, 6]
     * 
     * @param other - the list to append onto this one
     */
    public void append(SinglyLinkedList<E> other) {
        if (other.size != 0)  {
            Link<E> node = other.head; // arrive at the 1st node
            while (node != null) {
                add(node.data); // add the value into the 1at list
                node = node.next;
            }
        } 
    }
    
    public boolean add(E value) {
        Link<E> node = new Link<>();
        node.data = value;
        node.next = null;

        if (this.size == 0) { // 1st node to be added
            head = tail = node;

        } else { // appending the node to the tail end
            tail.next = node;
            tail = node;
             
        }
        size++;
        return true;
    }

    /**
     * This method will prepend copies of the links
     * of the parameter list to "this" list at the
     * front. The method should not change the other list.
     * 
     * For example, given two lists:
     *  list_1 = [1, 2, 3]
     *  list_2 = [4, 5, 6]
     * then list_1.prepend(list_2) should make list_1
     * contain [4, 5, 6, 1, 2, 3] and list_2 should
     * still be [4, 5, 6]
     * 
     * @param other - the list to append onto this one
     */
    public void prepend(SinglyLinkedList<E> other) {
        SinglyLinkedList<E> thirdList = new SinglyLinkedList<>();
        if (other.size != 0) {
            thirdList.append(other);
            thirdList.append(this);
            
            this.head = thirdList.head;
            this.tail = thirdList.tail;
            this.size = thirdList.size;
        }
    }

    /**
     * This function returns a copy of this SinglyLinkedList
     * except that the head element is removed. This list
     * should remain unchanged. This is similar to how the
     * Lisp function cdr() works.
     * 
     * For example, given the list:
     *  list_1 = [5, 4, 3, 2, 1]
     * then
     *  list_2 = list_1.cdr()
     * should yield:
     *  list_1 as [5, 4, 3, 2, 1]
     *  list_2 as [4, 3, 2, 1]
     * 
     */
    public SinglyLinkedList<E> cdr() {
        SinglyLinkedList<E> cdrList = new SinglyLinkedList<>();
        if (this.size > 1) {
            Link<E> node = head; // 1st node in the list
            node = node.next; // 2nd node in the list
            while (node != null) {
                cdrList.add(node.data);
                node = node.next;
            }
        } else if (this.size == 0) {
            cdrList = null;
        } // if this.size == 1 return cdrList, i.e., empty list
        
        return cdrList;
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

