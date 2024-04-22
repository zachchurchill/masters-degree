package com.zachurchill.lab3;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Utilizing the ArrayList from week 7 homework,
 * where I've gone back through the videos to fill in the required methods.
 *
 * @author  Franklin University
 * @version 3.0.0.0
 */
public class ArrayList<E> extends AbstractList<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    protected E [] data;
    protected int size;
    protected int modCount;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        size = 0;
        data = Utilities.newArray(null, initialCapacity);
        modCount = 0;
    }

    /**
     * Helper method to ensure we will have enough capacity set aside to
     * perform an addition to the data.
     */
	private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > data.length) {
            int newCapacity = data.length * 2 + 1;
            if (requiredCapacity > newCapacity) {
                newCapacity = requiredCapacity;
            }
            E [] temp = Utilities.newArray(this.data, newCapacity);
            for (int i = 0; i < size; ++i) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    /**
     * Provides the size of the data stored.
     */
	public int size() {
		return this.size;
	}

    /**
     * Returns a restricted subList available for editing.
     * <Not used>
     */
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * Adds all elements from parameter collection at specified index.
     */
	@Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        if (coll.size() == 0) {
            return false;
        }

        ArrayList<E> newData = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            newData.add(this.get(i));
        }
        for (Iterator<?> collItr = coll.iterator(); collItr.hasNext(); ) {
            newData.add((E) collItr.next());
        }
        for (Iterator<E> itr = listIterator(index); itr.hasNext(); ) {
            newData.add(itr.next());
        }
        clear();
        for (Iterator<E> itr = newData.iterator(); itr.hasNext(); ) {
            this.add(itr.next());
        }
        return true;
    }

    /**
     * Returns an Iterator object to traverse the data.
     */
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    /**
     * Returns a ListIterator over the elements in the list.
     */
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /**
     * Returns a ListIterator at a specific index in the list.
     */
    public ListIterator<E> listIterator(int startIndex) {
        return new ArrayListIterator(startIndex);
    }

    /**
     * Provides mechanism to iterate through ArrayList
     */
	private class ArrayListIterator implements ListIterator<E> {
        private int cursor;
        private int priorCursor;
        private static final int BAD_CURSOR = -1;
        private int expectedModCount;

        public ArrayListIterator(int startIndex) {
            if (startIndex < 0 || startIndex > size()) {
                throw new IndexOutOfBoundsException();
            }
            cursor = startIndex;
            priorCursor = BAD_CURSOR;
            expectedModCount = modCount;
        }

        /**
         * Returns true if there are more elements in the list; otherwise, false.
         */
        public boolean hasNext() {
            return cursor < size();
        }

        /**
         * Returns the next element in the list.
         */
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            priorCursor = cursor;
            return data[cursor++];
        }

        /**
         * Returns true if there is a previous element in the list; otherwise, false.
         */
        public boolean hasPrevious() {
            return cursor > 0;
        }

        /**
         * Returns the previous element in the list.
         */
        public E previous() {
            checkForComodification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            priorCursor = --cursor;
            return data[cursor];
        }

        /**
         * Returns the next index provided the list has a next element.
         */
        public int nextIndex() {
            return cursor;
        }

        /**
         * Returns the previous index provided the list has a previous element.
         */
        public int previousIndex() {
            return cursor - 1;
        }

        /**
         * Removes the previously returned element from the iteration.
         * @throws NoSuchElementException when next is not called immediately before remove.
         * @throws ConcurrentModificationException
         */
        public void remove() {
            checkForComodification();
            if (priorCursor == BAD_CURSOR) {
                throw new NoSuchElementException("no prior call to next or previous");
            }
            for (int i = priorCursor; i < size - 1; ++i) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            cursor = priorCursor;
            --size;
            priorCursor = BAD_CURSOR;
            updateAndSynchronizeModCounts();
        }

        /**
         * Inserts specified element into the list at the present iterator position.
         * @throws NoSuchElementException when next is not called immediately before add.
         * @throws ConcurrentModificationException
         */
        public void add(E obj) {
            checkForComodification();
            ensureCapacity(size + 1);
            for (int i = size; i > cursor; --i) {
                data[i] = data[i - 1];
            }
            data[cursor] = obj;
            ++cursor;
            ++size;
            updateAndSynchronizeModCounts();
        }

        /**
         * Replaces the last element returned by next or previous.
         */
        public void set(E obj) {
            checkForComodification();
            data[priorCursor] = obj;
        }

        protected void checkForComodification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
        
        protected void updateAndSynchronizeModCounts() {
            ++modCount;
            expectedModCount = modCount;
        }
    }
}
