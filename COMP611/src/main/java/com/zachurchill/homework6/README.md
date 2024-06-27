# Homework 6

## add()

Given a min-heap that stores its data in an ArrayList,
implement the add() method.
add() will insert the new value at the end of the array,
and then swap it upward until the heap property is restored.
The Heap constructor takes a parameter that determines how many children each node has,
and this will affect the organization of the array.
For most of the test cases,
your code only needs to work for a binary heap, 
and parentPosition() and childPosition() methods have been supplied that work in this case.
To pass all of the test cases,
the heap will need to work with three children per node as well as two,
and you will need to generalize the parentPosition() and childPosition() methods (and possibly add()) to make this work.

## isHeap()

Implement an isHeap() method that checks the current min-heap to see if it is valid.
Once again,
you can pass some test cases by handling a binary heap,
but you will have to generalize the code to pass the rest.

## extractMin()

Given a min-heap that stores its data in an ArrayList,
implement the extractMin() method.
extractMin() will remove the root of the heap,
replacing it with the last value in the array,
and then perform the down-heap operation to restore the heap property.
Again,
for most of the test cases,
your code only needs to work for a binary heap,
and parentPosition() and childPosition() methods have been supplied that work in this case.
To pass all of the test cases,
the heap will need to work with three children per node as well as two,
and you will need to generalize the parentPosition(), childPosition(), and extractMin() methods to make this work.

## Weekly short answer

This week we learned about an abstract data type called a priority queue through heaps. Heaps are a specific type of tree where there are specifications that the tree must be complete with the parents either always being smaller than the children in a min-heap or larger in a max-heap. Given that the tree must always be complete means that we are able to efficiently represent this also using an array over a tree, linked-objects representation. Furthermore, we learned how the data structure handles insertion and removal by using a trickling technique that makes use of the O(log n) time complexity due to the tree structure. Lastly, we learned a couple of applications of a priority queue though I still need to get my head around the Huffman Trees.
My question: what area of software engineering/problem solving do you find yourself regularly doing at your job? I've been diving back into IaaC with Terraform in Azure and although I enjoy the constructive nature of IaaC, I do think it's fairly narrow and I might be better suited to continue working on some backend services code (C# using Azure Functions) if I want to solve more interesting problems.
