# Week 9 Homework

## Doubly linked, circular lists

Consider the singly-linked list as defined in the starter code below,
**which is similar,
yet different from the LinkedList implemented in the videos.**
Write code that will implement the methods `get(int index)`,
`set(int index, E value)`,
`indexOf(E element, int start)`,
`lastIndexOf(E element, int end)`,
`insert(E element, int index)`,
and `remove(int index)` according to the specifications given in the starter code comments.
An implementation of `toString()` for `DoublyLinkedList` is provided to help you debug.

> Make sure that when you are getting to a given index,
you take the shortest path traversing the links.
For example,
for elements in the first half of the list,
traverse forward from the head.
However,
for elements in the second half of the list,
traverse backwards from the "tail".

Remember that we're using a dummy header node and there is no tail pointer anymore.

You may add any additional helper methods you desire, including constructors. However, do not touch the existing method signatures.

*You should be directly working with the links, not trying to use `Collection` or `List` methods here.
The videos for the `LinkedList` should be helpful, though!*

## FilteredCollection decorator

The decorator pattern lets us add or change functionality in an object by selectively overriding methods.
For example,
your textbook shows how to add costs to a beverage by decorating it repeatedly.

In this exercise,
you will decorate a `Collection` object so that it is filtered according to criteria in a `Filter` class.
The original collection may have a mix of objects that match or don't match the filter.
But once we pass it to a `FilteredCollection`,
then it will present a view of the original collection that contains only items that match the filter.
Any operation applied to the view will also affect the original collection.
This is an incredibly common operation in the actual collections hierarchy in Java.

A Filter is a very simple class:

```{java}
public interface Filter<E> {
    public boolean matches(E element);
}
```

The `matches()` method merely returns true or false based on some test for the elements.

For example, a simple `EvenFilter` for an Integer class would look like this:

```{java}
public class EvenFilter implements Filter<Integer> {
    @Override
    public boolean matches(Integer element) {
        return element.intValue() % 2 == 0;
    }
}
```

Now, using this filter, we can create a collection of integers and see a view of it that are only even numbers:

```{java}
ArrayList<Integer> list = new ArrayList<>();
int [] data = {3, 2, 6, 5, 8, 12, 21, 19, 18, 13, 5, 0};
for (int datum : data) {
    list.add(datum);
}
FilteredCollection<Integer> evens = new FilteredCollection(list, new EvenFilter());
System.out.println(evens.toString());   // outputs [2, 6, 8, 12, 18, 0]
evens.add(55); // returns false and doesn't add the odd number
evens.remove(18); // returns true and removes the 18 from the list
System.out.println(evens.toString());   // outputs [2, 6, 8, 12, 0]
System.out.println(list.toString());  // outputs [3, 2, 6, 5, 8, 12, 21, 19, 13, 5, 0]
```

To decorate the collection, implement the methods specified. You'll almost always be calling the same named function on the original.
