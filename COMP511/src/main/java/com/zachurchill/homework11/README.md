# Flood filling using queues

This exercise uses a queue to solve a problem:
flood filling a picture.
You will first implement a `Queue` by adapting a `LinkedList`,
and then you will use that `Queue` to solve the flood fill problem.

**Your overall enqueue and dequeue algorithms must be O(1) time complexity.**

To simplify the assignment,
there is the queue interface.

```{java}
public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
```

Start by implementing the class `QueueImpl` that uses an `LinkedList` as its backing store.
Then use your `QueueImpl` to implement the flood fill algorithm as follows:
- Given a `Point`,
look at what "color" is there (as represented by a character) and store it as the original color.
- If the point is within the bounds of the "image" then enqueue the point.
- Loop until the queue is empty, doing the following:
	- Dequeue a point.
    - Replace the "color" of the point with the substitute color.
    - Look at each of the neighbors of the point to the north, south, east, and west (keeping within the bounds of the image)
    - If the neighbor is the same color as the original starting point then enqueue it

Here is an example flood fill. Given the following "picture":

```
XXXX....XXXX
XX..XXXXXXXX
.XXX...XXXXX
```

Then a flood fill starting at point (1, 4) with replacement character 'Y' would yield

```
XXXX....YYYY
XX..YYYYYYYY
.XXX...YYYYY
```

Notice that flood filling doesn't use the diagonals from the original point (to the north-east, north-west, south-east, or south-west) and therefore it won't jump from (1, 4) to (0, 3)
