# Homework 4

## getHeight()

Write a method that returns the height of the binary tree when called on the node at the root of the tree.
A single node tree should return one.

## isFull()

Given a binary tree node,
return true if the tree rooted at that node is a full tree.
That is,
return true if every node in the tree has either zero or two children.

## valuesInLevelOrder()

Write a O(n) method valuesInLevelOrder() that returns a list of the nodes of a binary tree in level-order.
That is,
the method should return the root,
then the nodes at depth 1,
followed by the nodes at depth 2,
and so on.
Your algorithm should begin by putting the tree root on an initially empty queue.
Then dequeue a node,
add it to the output,
and enqueue its left and right children (if they exist).
Repeat until the queue is empty.
