# Week 7 Homework

## containsAll and retainAll in Collection

Based on the lectures this week, we implemented ArrayCollection -- a fixed sized,
unordered collection based on an underlying array.
However,
two methods were left unimplemented:
`containsAll` and `retainAll`.
In this problem you are to implement those methods.
A suite of test cases is provided.
Consulting the documentation for Collection may be helpful.

Indicate the time complexity for each method in the provided comment.

You will have access to all the other developed methods of `AbstractCollection` and `ArrayCollection` and its iterator per the videos and code therein.
The only change is that the following data are now `protected` instead of `private` (although you should not need these) 

```{java}
public class ArrayCollection<E> extends AbstractCollection<E> {
    protected int size;
    protected E [] data;
    // etc.
}
```

Additional grading criteria:
- Each method's time complexity specified: up to 1 point

## addAll at index, iterator set in List

Based on the lectures this week,
we implemented `ArrayList` -- an order-dependent collection that grows as more data is added to it.
Overall,
it was based on an underlying array.
However,
two methods were left unimplemented:
`ArrayList.addAll(int index, Collection<? extends E>)` and `ArrayListIterator.set(E element)`.
In this problem you are to implement those methods.
A suite of test cases is provided.
Consulting the documentation for `List` and `ListIterator` may be helpful.

You should not need access to any private fields,
but based on the presentation in class,
the following data and methods have been made `protected` instead of `private` so that you may access them:

```{java}
public class ArrayList<E> extends AbstractList<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    protected E [] data;
    protected int size;
    protected int modCount;

    protected void ensureCapacity(int requiredCapacity) {
        // etc.
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
}
```

You may also wish to download and look at the code for Week 7 in Canvas.

Indicate the time complexity in the provided comment.

Additional grading critieria:
- Time complexities given for each method: up to 1 point each.

## Overriding for efficiency

Recall in Week 6 that we had an implementation of `clear()` in AbstractCollection that used the iterator and repeatedly called `next()` followed by `remove()` to wipe out the collection.
This implementation was O(n).
However,
for the sake of efficiency,
it was overridden in `ArrayCollection` with an implementation that just created a new empty array and set the size to zero.
That implementation was O(1).

In the same manner,
there are methods of `AbstractList` that have working implementations that are less efficient than they could be if direct access to the instance fields.
What method(s) of `AbstractCollection` and `AbstractList` should be overridden in `ArrayList` in order to improve efficiency
(i.e., what method(s) could execute faster if a different algorithm had direct access to the instance fields)?
Think about all the “slow” algorithms in `AbstractList` applied to array-based collections and think creatively about how they could be made faster by doing fewer “shifts.”
Justify your answer with a high-level algorithmic explanation.

Hints:
- What is the impact of the iterator's remove method in `ArrayList` being O(n) instead of O(1)?
- What is the impact of adding an element in the middle of the array being O(n) instead of O(1) at the end?
- What if larger "gaps" were opened when adding to the array instead of just a single element?
- What if we used "tombstones" (unique objects that replace a deleted item) to mark off elements -- as was done in `AbstractCollection.equals()` -- for deletion and then the "gaps" were closed in one pass?

Grading criteria:
- Methods identified and approach described: up to 5 points

(see `etc/homework7` for these responses)
