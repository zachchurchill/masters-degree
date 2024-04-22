package com.zachurchill.lab3;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import static com.zachurchill.lab3.Utilities.nullSafeEquals;

/**
 * The base class from which to derive List implementations.  A list is a
 * sequence of objects kept in a container.  Typical operations are to add,
 * remove, and iterate over the elements.  This class provides implementations
 * for all operations except <tt>size</tt>, and <tt>listIterator</tt> (though
 * the provided implementations may be inefficient for some concrete classes).
 * Many of these operations can (and should) be overridden in derived
 * classes to increase the efficiency of the operation.  In particular,
 * <tt>addAll</tt> is a good candidate for advanced collections.
 * 
 * @param <E> the type of data to hold in the collection
 * 
 * @author  Franklin University
 * @version 3.0.0.0
 */
public abstract class AbstractList<E>
extends AbstractCollection<E>
implements List<E>
{
    /**
     * Inserts an element into a collection.  Returns true if the collection
     * is changed as a result of the operation, and false otherwise.
     * @param obj the object to add to the collection
     * @return true if the collection is altered
     */
    @Override
    public boolean add(E element) {
        listIterator(size()).add(element);
        return true;
    }
    
    /**
     * Returns the element of the list located at the specified index.
     * @param index the location of the element
     * @return the element at the index
     */
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("invalid index: " + index);
        }
        return listIterator(index).next();
    }

    /**
     * Inserts the element into the list at the given location.
     * @param index the location at which to insert
     * @param obj the object to add to the collection
     */
    public void add(int index, E obj) {
        listIterator(index).add(obj);
    }

    /**
     * Removes the element from the list at the specified index.
     * @param index the index of the object to be removed
     * @returns the thing that was removed
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("invalid index: " + index);
        }
        ListIterator<E> itr = listIterator(index);
        E result = itr.next();
        itr.remove();
        return result;
    }

    /**
     * Sets the element at a particular index and returns previous object.
     */
    public E set(int index, E obj) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("invalid index: " + index);
        }
        ListIterator<E> itr = listIterator(index);
        E result = itr.next();
        itr.set(obj);
        return result;
    }

    /**
     * Returns the location in the list of the first element that matches
     * the parameter object <tt>obj</tt> according to its equals method.
     * @param obj the object for which to search
     * @return the first index (from 0) where the object is found, or -1
     * if the object is not found in the list
     */
    public int indexOf(Object obj) {
        ListIterator<E> itr = listIterator(0);
        while (itr.hasNext()) {
            if (nullSafeEquals(obj, itr.next())) {
                return itr.previousIndex();
            }
        }
        return -1;
    }

    /**
     * Returns the location in the list of the last element that matches
     * the parameter object <tt>obj</tt> according to its equals method.
     * @param obj the object for which to search
     * @return the last index (from 0) where the object is found, or -1
     * if the object is not found in the list
     */
    public int lastIndexOf(Object obj) {
        ListIterator<E> itr = listIterator(size());
        while (itr.hasPrevious()) {
            if (nullSafeEquals(obj, itr.previous())) {
                return itr.nextIndex();
            }
        }
        return -1;
    }

	/**
	 * Searches this collection to see if every element in parameter collection
     * exists in this collection.
	 */
	public boolean containsAll(Collection<?> coll) {
        ArrayList<Boolean> doesContain = new ArrayList<>();
        Iterator<?> itr = coll.iterator();
        while(itr.hasNext()) {
            doesContain.add(this.contains(itr.next()));
        }
        return !doesContain.contains(false);
    }

    /**
     * Retains all the elements in this collection that match those in the
     * parameter collection.
     */
	public boolean retainAll(Collection<?> coll) {
        boolean altered = false;
        for (Iterator<E> itr = this.iterator(); itr.hasNext(); ) {
            E el = itr.next();
            if (!coll.contains(el)) {
                System.out.println("removing...");
                itr.remove();
                altered = altered || true;
            }
        }
        return altered;
    }
}
