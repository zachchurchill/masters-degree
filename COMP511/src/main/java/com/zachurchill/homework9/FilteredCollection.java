package com.zachurchill.homework9;

import java.util.Collection;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A decorator around a collection that is a "view" of the decorated
 * collection that is filtered to those that match the filter criteria.
 */
public class FilteredCollection<E> extends AbstractCollection<E> {
    // the original collection that we're decorating
    private Collection<E> original;
    // the filter used to select elements from the original
    private Filter<E> filter;

    public FilteredCollection(Collection<E> original, Filter<E> filter) {
        this.original = original;
        this.filter = filter;
    }

    @Override
    public int size() {
        int count = 0;
        for (E el : this.original) {
            if (this.filter.matches(el)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean add(E element) {
        if (this.filter.matches(element)) {
            return this.original.add(element);
        }
        return false; 
    }

    public Iterator<E> iterator() {
        return new FilteredCollectionIterator();
    }

    /**
     * Decorate an iterator over the original collection
     */
    public class FilteredCollectionIterator implements Iterator<E> {
        Iterator<E> iterator;
        int count;

        public FilteredCollectionIterator() {
            iterator = original.iterator();
            count = size();
        }

        public E next() {
            // use the iterator to locate and return the next matching
            // element in the original collection using the filter.
            // Decrement the count of elements remaining to be seen.
            if (count == 0 || !this.iterator.hasNext()) {
                throw new NoSuchElementException("no remaining elements");
            }
            while (this.iterator.hasNext()) {
                E nextElement = this.iterator.next();
                if (filter.matches(nextElement)) {
                    --count;
                    return nextElement;
                }
            }
            throw new NoSuchElementException("no remaining elements");
        }

        public boolean hasNext() {
            return count > 0;
        }

        public void remove() {
            this.iterator.remove();
        }
    }
}
