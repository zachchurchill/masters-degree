# Lab 1 project - AnytownLibrary

## Purpose

To assess your ability to apply the knowledge and skills developed in Module 1,
Module 2 and Module 3.
Emphasis will be placed on interfaces and polymorphism. 

## Introduction

You have been contracted by Anytown,
USA to develop the first phase of their public library system.
The system will keep track of media items that are available from the library.
There are three different types of media items:
books,
audio recordings,
and video recordings.
In the initial phase of the project,
the operations that must be supported by the system include adding a new item to the library,
deleting an item from the library,
checking an item out to a borrower,
checking an item back in to the library,
calculating late fees for overdue items,
and finding all copies of an item.

## Functional Requirements

### Adding an item

As books,
audio recordings,
or videos are purchased or donated to the library,
they must be added into the system.
Each item has a call number that is used to identify the item as well as determine where it is shelved in the library.
Because the library may have more than one copy of a particular item,
a copy number is also used to identify different copies of the same book,
audio recording,
or video recording.
When an item is added to the library,
the system must first check to see if an item with that call number already exists.
If it does not exist in the library system,
the copy number is 1.
The copy number is incremented for each subsequent copy of the item that is added to the library.

A maximum of 500 items may be added to the library.
The method to add an item must return a Boolean value of true if the item was successfully added.
Otherwise the method must return false.

### Deleting an item

An item is deleted from the library if it was lost or stolen.
The method to delete an item takes the call number and the copy number of the item to be deleted as parameters and returns a Boolean value of true if the item was successfully deleted and false if it was not deleted. If there are multiple copies of the item in the library, the copy numbers of the other copies are not changed.

### Checking out an item

Given a call number,
copy number,
borrower id,
and date checked out,
an item can be successfully checked out only if it exists in the library system and has not been checked out by another borrower.
Checking out an item sets the borrower id and the due date.
The due date should be set to 30 days from the current date.
If the item does not exist or is already checked out,
the method should return null.
Otherwise the method should return the due date.

### Checking in an item

Given a call number and copy number,
an item can be checked into the library only if it exists and is checked out.
Checking in an item sets the borrower id and the due date to null.
If the item does not exist or has not been checked out,
the method to check in the item should return false.
Otherwise the method should return true.

### Calculating late fees

Late fees are calculated according to the number of days the item is overdue.
A borrower is charged 25 cents for every day a book is overdue.
A borrower is charged 50 cents for every day an audio or video recording is overdue.
If the item is not overdue,
the borrower is not charged any fees.

### Finding items

Given a call number,
this method retrieves all items that match that call number.
This allows the librarian or others using the library system to find all copies of a particular media item.

## Assignment

Your job is to implement the methods specified in the interfaces in concrete classes.
You must document and test all classes you implement.
A careful study of the functional requirements and documentation in the provided interface classes will direct your efforts.
You may ask your professor for clarification on any of the methods that are imprecisely defined.
Any method containing the comment /*# TODO: insert Code here */ should be modified to perform the task documented in the associated interface.
You are responsible for creating any needed instance fields.
You also must add comments and update all Javadoc documentation to accurately document your implementation.
You can create additional methods,
as needed,
to fully implement your classes. 

Note that some additional classes and interfaces are provided as part of the project.
In particular,
the Money interface and the concrete implementation Dollar are available for specifying the cost of an item. 

You will need to use the GregorianCalendar class for the due date.
The Javadoc for the GregorianCalendar class can be found at
[https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html](https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html).
To determine the due date for an item from the date it was checked out,
create a copy of the GregorianCalendar object using the clone method.
Then use the add method to add 30 days to the date as shown below:

```{java}
GregorianCalendar dueDate =(GregorianCalendar)dateCheckedOut.clone();
dueDate.add(Calendar.DAY_OF_MONTH, 30);
```

When calculating overdue fees,
you will want to use the compareTo method in the GregorianCalendar class to determine whether an item is overdue.
In addition,
the `AnytownLibrary.calculateDateDiff` method has been supplied for you that takes two GregorianCalendar objects as parameters and returns the difference (the number of days) between the two dates.

Note that some additional classes and interfaces are provided as part of the project.
In particular,
the Money interface and the concrete implementation Dollar are available for specifying the cost of an item.
JavaDoc for Money and Dollar can be found in doc folder.

Note that a user interface is NOT part of this project.
If you wish to create a user interface for your own use,
you may do so in the RunMe.java file,
which will not be graded.

1. You must use the provided starter project and develop your solution.
2. Do NOT change the name, return type, or parameter order/type of any of the methods in class or test class. These are used by the instructor grading scripts  to grade your submission, and you will end up losing points if they are changed.
3. Each class constructor and method should be unit tested. Besides serving to verify that your code is accomplishing what you intended, writing unit test methods helps you understand how the objects should behave (how the methods create, access and mutate the object). That is, writing the test methods first helps guide your class coding efforts. Follow these steps to complete the classes:
    - Review & complete the code of the 1st test case as needed. Note that proper testing includes making manual calculations to verify that expected values for a method action are equivalent to actual results. Be careful with the tolerance used when comparing two decimal/floating-point numbers. If the tolerance is too small, e.g., 0.000001, the test might fail easily. If the tolerance is too big, e.g., 0.1, that will render the test meaningless.
    - Once you feel the unit test method is a valid and robust test of the method’s expected behavior, review the corresponding class constructor or method and complete the coding if necessary.
    - Run the JUnit test for the method. If it does not pass, review and correct the code for this method.
    - When the test passes, continue in like manner for the next and subsequent methods, iteratively completing tests and developing your class or classes. All class methods must be tested. 
4. All classes must compile cleanly. 
