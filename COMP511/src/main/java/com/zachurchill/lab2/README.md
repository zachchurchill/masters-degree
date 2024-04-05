# Lab 2 project - Renewing, refactoring, and exceptions

## Purpose

To assess your ability to apply the knowledge and skills developed in Modules 3,
4,
and 5.
Emphasis will be placed on inheritance,
polymorphism,
and exceptions. 

## Introduction

Because the first phase of the library project went well,
you’ve been asked to do the second phase of the project.
Anytown Public Library would like you to enhance the system so that books can be renewed.
A borrower can renew a single book or all books currently checked out to that borrower.

In addition to the changes the customer wants,
you suggest a few changes that will make the system more robust and easier to change.
In particular,
when you worked on the first phase of the project,
you noticed that the Book,
AudioRecording,
and VideoRecording classes had redundant code in their implementations,
so you suggest that those classes be cleaned up by refactoring the implementations into an inheritance hierarchy.
Also,
there was nothing in the original design that performed validation of parameters,
so you suggest that code be added to ensure no objects can be created with or set to an invalid state.
The customer likes your suggestions,
the contract is signed,
and you are employed for another two weeks!

## New Functional Requirements

### Renewing a book

Given a call number,
copy number,
borrower id,
and the date the renewal was requested,
a book can be renewed for an additional 14 days from the due date.
Note that only books can be renewed.
Audio and video recordings cannot.
If the item is not a book,
does not exist,
is overdue,
or is not checked out by the borrower requesting the renewal,
the method should return null.
Otherwise,
the method should return the new due date.

### Renewing all books for a borrower

Given a borrower id and the date the renewal was requested,
all books currently checked out to the borrower can be renewed for an additional 14 days.
Note that if a book is already overdue,
it cannot be renewed.
All the books that are renewed are returned by this method.
The length of the returned array must be equal to the number of books that were renewed.

### Assignment

Carefully examine all the code that has been supplied to you to ensure you understand the overall design and what pieces you need to implement to complete this assignment.
You must document and test all your code.
A careful study of the functional requirements and documentation in the supplied code and javadoc will direct your efforts.
You may ask your professor for clarification on any of the methods that are imprecisely defined.
Comments that begin with /*# TODO: insert Code here */ will help you to find some of the areas where you need to add code.
You must add comments and update all javadoc to accurately document your implementation.
You can create additional methods,
if needed,
to fully implement the classes.

#### Task 1: Redesign and refactor the MediaItem hierarchy

The abstract class AbstractMediaItem provides empty implementations of all the methods defined in the MediaItem interface.
Fill in the implementations.
Override these methods,
if needed,
and add any additional methods needed in the Book,
AudioRecording,
and VideoRecording classes.
Fields and methods specific to each type of media item should go into the respective classes. 

#### Task 2: Implement the code needed to renew books

Implement the overloaded renew methods in the AnytownLibrary class.
Be sure to write test cases to fully test your code. 

#### Task 3: Validate parameters passed to constructors and setters

Up to this point,
no validation was performed on the data passed into constructors and setter methods.
For example,
it is possible to set a title to be null or the empty string,
which is not valid.
A borrower id or due date,
however,
can be null.
For each of the parameters used in the constructors or set methods throughout the project,
you must validate the parameter to insure it contains a valid value.
If the parameter is not valid,
the method or constructor must throw an IllegalArgumentException.
Note that this exception should be thrown only from constructors or setters. 

Consider carefully what the definition of valid or invalid values are for each parameter.
While most of the String objects passed into the set methods can contain anything but the empty string or null,
the String object passed into the setCallNumber method should only contain numbers (0-9),
letters (a-z or A-Z),
a space,
and the decimal point (.) character.
Be sure to include test cases that test both valid and invalid parameters.
