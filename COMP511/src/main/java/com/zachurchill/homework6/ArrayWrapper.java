package com.zachurchill.homework6;

/**
 * ArrayWrapper is an abstraction to simplify access to an
 * array, allowing adding elements, removing elements, retrieving
 * elements, and replacing elements.
 */
public class ArrayWrapper<T> {

    // the array to hold the data
    private T [] data;
    // the next available index for adding an element
    private int next;

    /**
     * Initializes the instance fields to legitimate values
     * (data and next).
     * @param arraySize - the capacity of the array to allocate
     */
    @SuppressWarnings("unchecked")
    public ArrayWrapper(int arraySize) {
        data = (T[])(new Object[arraySize]);
        next = 0;
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
     * Inserts the parameter value into the array at the next
     * available slot (if there is one).
     * @param value - the value to store in the array
     * @return true if the add was successful, false otherwise.
     */
    public boolean add(T value) {
        if (this.next < this.data.length) {
            this.data[this.next] = value;
            this.next++;
            return true;
        } else {
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
    public T get(int index) {
        this.checkIndex(index);
        return this.data[index];
    }

    /**
     * Replaces the value at the given index with a new one. You
     * can only replace an element that is already in the array.
     * You can't use this to add new elements to the array.
     * @param index - where to overwrite in the range [0, size()-1]
     * @param value - what to overwrite with
     * @return the old value that was stored at that index
     */
    public T put(int index, T value) {
        this.checkIndex(index);
        T oldValue = this.data[index];
        this.data[index] = value;
        return oldValue;
    }
    
    /**
     * Removes the element in the array at the specified index by
     * shifting all elements to the right of the index back by one.
     * Use checkIndex to make sure that the index is valid.
     * @param index - the index of the element to remove in the range [0, size()-1]
     * @returns true if the deletion was successful, false otherwise.
     */
    public boolean delete(int index) {
        if (index < this.size()) {
            for (int i = index; i < this.size() - 1; i++) {
                this.data[i] = this.data[i+1];
            }
            this.next--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Uses a callback to implement the accumulator pattern -- see homework 3.
     */
    public void accumulate(Worker<T> worker) {
        for (int i = 0; i < this.size(); i++) {
            worker.work(this.get(i));
        }
    }

    /**
     * Swaps the elements at positions i and j
     * (assuming that those positions are valid)
     * @param i - the first index [0, size() - 1]
     * @param j - the second index [0, size() - 1]
     */
    public void swap(int i, int j) {
        T oldValue = this.put(i, this.get(j));
        this.put(j, oldValue);
    }
}
