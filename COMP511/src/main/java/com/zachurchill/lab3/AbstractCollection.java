package com.zachurchill.lab3;

import java.util.Collection;
import java.util.Iterator;

import static com.zachurchill.lab3.Utilities.newArray;
import static com.zachurchill.lab3.Utilities.nullSafeEquals;

/**
 * Utilizing the AbstractionCollection from week 7 homework.
 *
 * @author  Franklin University
 * @version 3.0.0.0
 */
public abstract class AbstractCollection<E> implements Collection<E>
{
    /**
     * Returns true if the collection contains no elements.
     * @return true if the collection is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Searches the collection to determine if the collection contains
     * an element that matches the specified object.  If the specified
     * object is null, it will look for a null in the collection.  Otherwise
     * it will use the <tt>equals</tt> method of the given object to 
     * determine equality.  That is, <tt>o == null ? element == null : 
     * o.equals(element)</tt>.
     * @param obj the object to match
     * @return true if the collection contains a matching element
     */
    public boolean contains(Object obj) {
        Iterator<E> itr = this.iterator();
        while(itr.hasNext()) {
            if (nullSafeEquals(obj, itr.next())) {
                return true;
            }
        }
        // for (int i = 0; i < size; ++i) {
        // if (nullSafeEquals(obj, data[i])) {
        // return true;
        // }
        // }
        return false;
    }

    /**
     * Removes the first element of this collection matching the parameter
     * object <tt>obj</tt>.  If the colleciton is altered as a result of
     * the operation, <tt>remove</tt> returns <tt>true</tt>.
     * @param obj the object to match
     * @return true if the collection is altered, false otherwise.
     */
    public boolean remove(Object obj) {
        Iterator<E> itr = this.iterator();
        while (itr.hasNext()) {
            if (nullSafeEquals(obj, itr.next())) {
                itr.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all elements from the collection.  The collection will
     * be empty after calling this method.
     */
    @Override
    public void clear() {
        Iterator<E> itr = this.iterator();
        while(itr.hasNext()) {
            itr.next();
            itr.remove();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (E element : this) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(String.valueOf(element));
        }

        return "[" + builder.toString() + "]";
    }

    /**
     * Inserts all the elements of <tt>coll</tt> into this collection.  If
     * both this collection and the parameter are the same collection, then
     * the operational behavior is undefined (i.e. bad things can happen).
     * @param coll the collection from which to draw elements for addition.
     * @return true when this collection is modified as a result.
     */
    public boolean addAll(Collection<? extends E> coll) {
        boolean changed = false;

        for (E element : coll) {
            changed = this.add(element) || changed;
        }

        return changed;
    }

    /**
     * Removes all elements in this collection that match those in the
     * parameter collection <tt>coll</tt>.  When the operation completes,
     * the two collections will be disjoint.
     * @param coll the collection of elements to be removed from this one.
     * @return true if this collection is altered as a result of the call.
     */
    public boolean removeAll(Collection<?> coll) {
        int oldSize = size();

        for (Iterator<E> itr = this.iterator(); itr.hasNext(); ) {
            if (coll.contains(itr.next())) {
                itr.remove();
            }
        }

        return oldSize != size();
    }

    /**
     * Creates and returns an array containing the data from this collection.
     * If this collection preserves order, then the order in the array
     * will be the same as the order of the collection.  The array returned
     * will always be safe to be modified (i.e. it will be different from
     * the underlying collection's array if the collection is array-backed).
     * @return an array containing references to the collections elements.
     */
    public Object [] toArray() {
        Object [] result = new Object[this.size()];

        int i = 0;
        for (E element : this) {
            result[i] = element;
            ++i;
        }

        return result;
    }

    /**
     * Returns an array containing the data from this collection.  If the
     * parameter array is large enough to hold the collection, then it is
     * filled and returned.  Otherwise, a new array of the same type is
     * allocated, filled, and returned.  If this collection preserves order
     * then the order in the array will be the same as the order of the
     * collection. The array returned will always be safe to be modified
     * (i.e. it will be different from the underlying collection's array
     * if the collection is array-backed). The last element of the array
     * will be set to null if there is sufficient room.
     * 
     * @param a - the array to fill with the elements of this collection. If
     * the array is large enough, then the elements [0, size()-1] will be
     * overwritten. Otherwise, a new array will be constructed.
     * @return an array containing references to the collections elements.
     */
    public <T> T[] toArray(T[] arr) {
        Object [] result = null;

        if (arr == null || arr.length < this.size()) {
            arr = newArray(arr, this.size());
        }

        result = arr;
        int i = 0;
        for (E element : this) {
            result[i] = element;
            ++i;
        }
        while (i < arr.length) {
            result[i] = null;
            ++i;
        }

        return arr;
    }
}
