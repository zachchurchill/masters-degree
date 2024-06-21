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
