/**
 * Array Wrapper
 * In this exercise you are writing a set of methods that will encapsulate
 * an array of integers in a safe way. One of the drawbacks of standard
 * arrays is that they aren't self-managing; you need to manually keep
 * track of the next index to add elements, know how many elements are
 * occupied, manually remove elements from the array and shift values
 * around, etc. This wrapper around an array will encapsulate all
 * those functions.
 *
 * Follow the specifications in each method's documentation to implement
 * the following methods: constructor, size, add, get, and delete. A
 * helper method that will check to see if an index is valid has been
 * included for you. You only need to call checkIndex and any code after
 * that method call will only execute if the index is valid. 
 */
package com.zachurchill.homework2;

import java.util.Arrays;

/**
 * ArrayWrapper is an abstraction to simplify access to an
 * array, allowing adding elements, remove elements, retrieving
 * elements, and replacing elements.
 */
public class ArrayWrapper {
    // the array to hold the data
    private int [] data;
    // the next available index for adding an element
    private int next;

    /**
     * Initializes the instance fields to legitimate values (data and next).
     * @param arraySize - the capacity of the array to allocate.
     */
    public ArrayWrapper(int arraySize) {
        this.data = new int[arraySize];
        this.next = 0;
    }

    /**
     * Returns the count of data elements in the array
     * @return the number of slots in the data array that are
     * occupied with valid data.
     */
    public int size() {
        return this.next;
    }

    /**
     * Inserts the parameter number into the array at the next
     * available slot (if there is one).
     * @param number - the number to store in the array
     * @return true if the add was successful, false otherwise
     */
    public boolean add(int number) {
        try {
            this.data[this.next] = number;
            this.next++;
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        } 
    }

    /**
     * A helper function to ensure that the index is valid.
     * @param index - the index to check.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Bad index: " + index);
        }
    }

    /**
     * Returns the data stored in the array at the given index.
     * Use checkIndex to make sure that the index is valid.
     */
    public int get(int index) {
        this.checkIndex(index);
        return this.data[index];
    }

    /**
     * Replaces the value at the given index with a new one.
     * You can only replace an element that is already in the array.
     * You can't use this to add new elements to the array.
     * @param index - where to overwrite in the range [0, size() - 1]
     * @param number -  what to overwrite with
     * @return the old value that was stored at that index
     */
    public int put(int index, int value) {
        this.checkIndex(index);
        int oldValue = this.data[index];
        this.data[index] = value;
        return oldValue;
    }

    /**
     * Removes the element in the array at the specified index by
     * shifting all elements to the right of the index back by one.
     * Use checkIndex to make sure that the index is valid.
     * @param index - the index of the element to remove in the
     * range [0, size() - 1]
     * @returns true if the deletion was successful, false otherwise.
     */
    public boolean delete(int index) {
        try {
            this.checkIndex(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        for (int i = 1; i < (this.size() - index); i++) {
            this.data[index + i - 1] = this.data[index + i];
        }
        this.next--;
        return true;
    }
}
