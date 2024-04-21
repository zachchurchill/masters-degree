# Lab 3 project - Searching by strategy

## Purpose

To assess your ability to apply the knowledge and skills developed in Modules 6,
7,
and 8.
Emphasis will be placed on linear data structures and the strategy design pattern.

## Introduction

Anytown Public Library was again pleased with your work on the in the last contract.
As a result,
they have approached you again to modify the system.
At this time they do not wish to use arrays to store their items,
having heard about collections and lists.
Your job will be to modify the current project so that books,
audio recordings,
and video recordings are no longer stored using arrays but are stored inside a list.
In addition,
the library wants to allow borrowers to search the collection using various criteria.
Initially they want to add the feature to search by title,
but they want the system designed so that additional search criteria can be easily.

## New Functional Requirements

### `MatchMaker` Strategy

The Strategy design pattern (discussed in your Design Patterns textbook) is used to encapsulate the algorithms for searching for items in the library.
A new interface,
`MatchMaker`,
has been defined that contains a single method.
The method should return true if the item passed in matches the search criterion. 

```{java}
public boolean matches(MediaItem item)
```

You should not modify the `MatchMaker` interface.
But you must implement the interface in three classes,
`AuthorMatch`,
`TitleMatch`,
and `PartialTitleMatch` described below.

**AuthorMatch**

This class encapsulates the behavior needed to find an author using the last name as the search criterion.
For the purposes of this lab,
you can assume that the last name is the part of the string following the last space.
For example,
if a Book contains the author field “Orson Scott Card”,
that book would match a search with the criterion of “Card”.
Note that this search is case-sensitive.

**TitleMatch**

This class encapsulates the behavior needed to find items using the complete title as the search criterion.
Note that the title must be an exact match.

**PartialTitleMatch**

This class encapsulates the behavior needed to find items using part of the title as the search criterion.
For example,
if the search string was “Java Programming”,
the matches method would return true for all the items in the library that contained the phrase “Java Programming” anywhere in the title.
Note that this search should not be case sensitive.

**Modifications to `AnytownLibrary`**

The first modification you must make to the AnytownLibrary class is to change the implementation from an array to a list.
Due to the implementation change,
the library is no longer limited to 500 items.
Note that the `getItems` and `findItems` methods should still return arrays so that no code that uses those methods needs to change.
All the test cases created previously should still work (except for the test case that tested the array limit, which has been deleted removed).
In future releases,
`getItems` and `findItems` may be phased out in favor of the `searchItems` method described below.

The `searchItems` method in the AnytownLibrary class takes a `MatchMaker` object as a parameter,
and returns a list of all matching items.
If there are no matches,
it should return an empty list,
rather than null.

```{java}
public List<MediaItem> searchItems(MatchMaker matchMaker)
```

This method uses the `MatchMaker` strategy to determine eligibility for the `MediaItem` to be included in the resulting list.

## Assignment

Your job is to make the aforementioned changes to the library system.
You need only to focus on the `AnytownLibrary`,
`AuthorMatch`,
`TitleMatch`,
and `PartialTitleMatch` classes.
Carefully examine all the code that has been supplied to you to insure you understand the overall design and what pieces you need to implement to complete this assignment.
A careful study of the functional requirements and documentation provided will direct your efforts.
Be sure to ask for clarification on any of the requirements that are unclear.
You can create additional methods,
if needed,
to fully implement your classes.

You must add comments and update all Javadoc to accurately document your implementation.
Note that no Javadoc or test classes have been provided for the `AuthorMatch`,
`TitleMatch`,
and `PartialTitleMatch` classes or methods.
It is your responsibility to add the Javadoc comments and create the test classes and methods.
