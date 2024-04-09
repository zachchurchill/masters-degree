package com.zachurchill.homework7;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static com.zachurchill.homework7.Utilities.nullSafeEquals;
import static com.zachurchill.homework7.Utilities.newArray;

/**
 * Write a description of class ArrayCollection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayCollection<E> extends AbstractCollection<E>
{
    private int size;
    private E [] data;

    @SuppressWarnings("unchecked")
    public ArrayCollection(int initialSize) {
        init(initialSize);
    }

    public ArrayCollection() {
        this(10);
    }

    private void init(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("size must be >= 0");
        }
        this.size = 0;
        data = (E[])(new Object[initialSize]);
    }

    /**
     * Returns the number of elements in the collection.
     * @return the number of elements in the collection.
     */
    public int size() {
        return this.size;
    }

    /**
     * Inserts an element into a collection.  Returns true if the collection
     * is changed as a result of the operation, and false otherwise.
     * @param obj the object to add to the collection
     * @return true if the collection is altered
     */
    @Override
    public boolean add(E element) {
        if (size >= data.length) {
            return false;
        }
        data[size] = element;
        ++size;
        return true;
    }

    /**
     * Returns an iterator over the elements in this collection. There are
     * no guarantees concerning the order in which the elements are returned
     * (unless this collection is an instance of some class that provides a
     * guarantee).
     * 
     * @return an iterator object.
     */
    public Iterator<E> iterator() {
        return new ArrayCollectionIterator();
    }

    @Override
    public void clear() {
        init(data.length);
    }

    /**
     * Searches this collection to determine if every element of <tt>coll</tt>
     * exists in this collection.  Comparison is based on the same algorithm
     * as for <tt>contains</tt>.
     * @param coll the collection to be checked for containment in this on
     * @return true if all elements of <tt>coll</tt> also exist in this.
     */
    public boolean containsAll(Collection<?> coll) {
        /*# TODO: this is a Homework problem :( */
        throw new UnsupportedOperationException("This must be overridden");
    }

    /**
     * Retains all the elements in this collection that match those in
     * the parameter collection <tt>coll</tt>.  That is, it will remove
     * all elements in this collection that have no match in <tt>coll</tt>.
     * @parma coll the collection of elements to be matched against
     * @return true if this collection is altered as a result of the call.
     */
    public boolean retainAll(Collection<?> coll) {
        /*# TODO: this is a Homework problem :( */
        throw new UnsupportedOperationException("This must be overridden");
    }

    /**
     * Compares the parameter object <tt>obj</tt> against this collection
     * for equality.  Care should be taken to ensure symmetry, transitivity,
     * and reflexivity properties of equality.  That is: if
     * <tt>a.equals(b)</tt> is true then <tt>b.equals(a)</tt> should also be
     * true (symmetry); if <tt>a.equals(b)</tt> and <tt>b.equals(c)</tt> then
     * <tt>a.equals(c)</tt> should be true (transitivity); and also
     * <tt>a.equals(a)</tt> should also be true.
     * 
     * The contract between <tt>equals</tt> and <tt>hashCode</tt> should
     * also be kept.  That is, if <tt>a.equals(b)</tt> is true then
     * <tt>a.hashCode() == b.hashCode()</tt> should also be true.  The
     * reverse is not true (equal hash codes do not imply object equality).
     * 
     * A typical way to implement <tt>equals</tt> would be do do a value
     * comparison of the contents of the collection.
     * 
     * @param obj the object against which to compare this collection.
     * @return true if the object is equal to this collection.
     */
    public boolean equals(Object obj) {
        return this.toString().equals(String.valueOf(obj));
    }

    /**
     * Returns the hash code value for this collection.  A typical
     * implementation would be to somehow aggregate the hash codes of the
     * individual elements of the collection.  Be sure that hashCode is
     * also overridden if equals is overridden.
     * @return the hash code of the collection.
     */
    public int hashCode() {
        return this.toString().hashCode();
    }

    private class ArrayCollectionIterator implements Iterator<E> {
        // position x represents between x-1 and x as indices
        private int index;
        private boolean nextCalled;

        public ArrayCollectionIterator() {
            index = 0;
            nextCalled = false;
        }

        public boolean hasNext() {
            return index < size();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Index out of bounds");
            }
            nextCalled = true;
            return data[index++];
        }

        public void remove() {
            if (!nextCalled) {
                throw new IllegalStateException("No prior call to next");
            }
            --index;
            data[index] = data[size - 1];
            data[size - 1] = null;
            --size;
            nextCalled = false;
        }
    }

}
