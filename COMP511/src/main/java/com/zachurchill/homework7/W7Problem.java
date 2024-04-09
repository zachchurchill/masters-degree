package com.zachurchill.homework7;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Write a description of class W7Problem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class W7Problem<E> extends ArrayList<E>
{
    // Scaffolding for the problem. Don't touch.
    public W7Problem() {
        super();
    }

    // Scaffolding for the problem. Don't touch.
    public W7Problem(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Inserts all the elements of <tt>coll</tt> into this collection at
     * the specified location.  If both this collection and the parameter
     * are the same collection, then the operational behavior is undefined
     * (i.e. bad things can happen).
     * @param index the location at which to insert
     * @param coll the collection from which to draw elements for addition.
     * @return true when this collection is modified as a result.
     * 
     * Time complexity: TODO___________
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        // TODO: your code goes here
        throw new UnsupportedOperationException();
    }

    // Scaffolding for the problem. Don't touch.
    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    // Scaffolding for the problem. Don't touch.
    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    // Scaffolding for the problem. Don't touch.
    @Override
    public ListIterator<E> listIterator(int index) {
        return new W7ProblemIterator(index);
    }

    private class W7ProblemIterator extends ArrayList<E>.ArrayListIterator {
        // Scaffolding for the probmem. Don't touch.
        public W7ProblemIterator(int startIndex) {
            super(startIndex);
        }

        /**
         * Replaces the last element returned by either <tt>next</tt> or
         * <tt>previous</tt>.  Cannot be called immediately after <tt>add</tt>
         * or <tt>remove</tt>.
         * @param obj the object with which to replace the one returned
         * earlier.
         * 
         * Time complexity: TODO___________
         */
        @Override
        public void set(E obj) {
            // TODO: Your code goes here
            throw new UnsupportedOperationException();
        }
    }
}

