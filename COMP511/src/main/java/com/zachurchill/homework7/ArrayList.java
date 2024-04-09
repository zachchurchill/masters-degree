package com.zachurchill.homework7;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<E> extends AbstractList<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    protected E [] data;
    protected int size;
    protected int modCount;

	protected void ensureCapacity(int requiredCapacity) {
        // etc.
    }

	public int size() {
		return this.size;
	}

	protected class ArrayListIterator implements ListIterator<E> {
        protected int cursor;
        protected int priorCursor;
        protected int expectedModCount;

        protected void checkForComodification() {
            // etc.
        }
        
        protected void updateAndSynchronizeModeCounts() {
            // etc
        }
    }

	/**
     * finds and removes duplicate values (based on equals()) from
     * the list given as a parameter. Use iterators in your solution,
     * not the 'get' method with indices
     */
    public static <T> void removeListDuplicates(List<T> list) {
        for (int index = 0; index < list.size(); index++) { 
            // create a ListIterator object starting from the 1st unreviewed position
            ListIterator<T> li = list.listIterator(index);
            // get the marker
            T item = li.next();
            // review the rest of the data elements and see if there are duplicates
            while (li.hasNext()) {
                if (item.equals(li.next())) {
                    li.remove();
                }
            }
        }
        

    }

    /**
     * finds and removes duplicate values (based on equals()) from
     * the list given as a parameter. Use iterators in your solution
     */
    public static <T> void removeCollectionDuplicates(Collection<T> coll) {
        for (int index = 0; index < coll.size(); index++) { 
            Iterator<T> iter = coll.iterator();
            // skip those data elements already reviewed
            for (int j = 0; j < index; j++) { 
                iter.next(); 
            }
            T item = iter.next(); // get the marker
            // inspect the rest of the data elements in the iterator
            while (iter.hasNext()) { 
                if (item.equals(iter.next())) {
                    iter.remove();
                }
            }
        }
    }
}
