# Homework 5

## DebugVisitor

Starting with the BinaryExpression learning activity solution from this week,
write a new class DebugVisitor that visits an expression tree and returns a list of the calls made to the visitor.
For example,
if the expression tree represented the expression 3 + 5,
then the output would be:

 preVisit AddExpression

 visit ConstantExpression 3

 visit AddExpression

 visit ConstantExpression 5

 postVisit AddExpression

Hint: You can use obj.getClass().getSimpleName() to get the name of an object.

## PostfixVisitor

Starting with the BinaryExpression learning activity solution from this week,
write a new class PostfixVisitor that visits an expression tree and returns the expression in postfix notation,
with each part of the expression separated by spaces.
For example,
if the tree represented the expression 3 + 5,
then the postfix result would be “3 5 +”

## SearchVisitor

Given a tree of nodes that each have a name,
we can look at each node as if it has a path.
For example,
if we had a root node "root" with children called "child1" and "child2",
the paths of the nodes would be:

"/root"

"/root/child1"

"/root/child2"

Write a SearchVisitor that is given a search string,
and then finds nodes whose paths contain the search string.
It will return a list of the names of the matching nodes in pre-order,
so if /root and /root/child1 were both in the results,
root would appear first.

If we had the nodes above,
and the search string was "child1",
then the result would be "child1".
If the search string was "root/",
then the result would be "child1", "child2".

## Weekly short answer

This week was all about patterns. Specifically, we learned about the Composite design pattern and how it is typically mischaracterized and the Visitor design pattern. The Composite design pattern is characterized by a whole-part relationship between objects where it is key that they share the same interface. Similar to the example given in class on how to mistakenly say something is using the Composite design pattern could be the construction of a computer. While a computer is composed of many different parts that come together to make something functioning, these parts do not share the same interface (input/output sources, power supply, e.g.). This contrasts the examples shared in class where each component of an XML document has the same interface and it's more of a matter of how they fit together to make the structure meaningful. The Visitor design pattern makes use of a best practice of separating what changes from what remains the same in code. That is, we learned that to apply a visitor pattern we need to set up our tree traversal to make use of steps that can be performed by a given object without that object being knowledgeable of the tree traversal algorithm - we write the tree traversal code once and provide the ability for an object to be passed in to perform actions defined in the visitor.
Weekly question: Although both are important for a well-rounded software engineer/problem solver, do you fall back on your knowledge of advanced data structures or reach for design patterns more often in your project work?
