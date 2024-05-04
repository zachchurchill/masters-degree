# Lab 4 project - Adapting other lendable items

## Purpose

To assess your ability to apply the knowledge and skills developed in Modules 9-12.
Emphasis will be placed on linear data structures and the adapter design pattern.

## Introduction

Anytown Public Library was again pleased with the results of the prior contract.
The new library system is a success,
and as a result,
the customer wants to expand its capabilities.
The Anytown Chamber of Commerce has a collection of software packages that they lend out to small businesses to try before they buy.
The town has decided they would like to integrate the Chamber of Commerce system with the Anytown Public Library system and would like you to “adapt” the Chamber of Commerce business software objects to be used in the Anytown Library system.
Unfortunately,
the source code for the Chamber of Commerce system is no longer available.
Only the object code (in a jar file) and the javadoc files (in the jardoc folder) are available to you.

Note that the Chamber of Commerce system did not use call numbers or copy numbers.
The collection was small enough that everything was identified by the publisher and application name.
In general,
the fields in the Chamber of Commerce system correspond to fields in the Anytown Public Library system as shown below:

|MediaItem Field|BusinessSoftware Field|
|:---|:---|
|callNumber|no corresponding field|
|copyNumber|no corresponding field|
|title|The `publisher` and `applicationName` (separated by ':') e.g., "Microsoft:Word 2007", null if both fields null|
|dueDate|dateToBeReturned in the format mm/dd/yyyy|
|borrower|businessId where 0 corresponds to a null borrower|

## New Functional Requirements

__`BusinessSoftwareAdapter`__

You must create a `BusinessSoftwareAdapter` class that implements the `MediaItem` interface.
You need to create the class,
test class,
and javadoc for the adapter.
Note that all the set methods should include parameter validation and throw an `IllegalArgumentException` if the parameter is not valid.
When setting the title,
if the title string does not contain a colon (:),
it is an illegal argument.
Because only businesses can check out the business software,
the borrower passed in to the `setBorrower` method must contain only digits so that it can be converted into a business id.

The only instance fields that should be included in the `BusinessSoftwareAdapter` class are:

```
private BusinessSoftware businessSoftware;
private String callNumber;
private int copyNumber;
```

In addition to implementing the methods in the `MediaItem` interface,
the class must include a constructor that takes a `BusinessSoftware` object as a parameter.

```
public BusinessSoftwareAdapter(BusinessSoftware software) {
    // your code here
}
```

Note that overdue fees are $1 per day for business software.
Be careful when creating the `Dollar` object returned from the calculateFees method.
You must pass a float or double into the `Dollar` constructor for the value to be interpreted as dollars,
not cents.
You also should not use dates in March or April to test your `calculateFees` method because of the daylight savings time bug.
Note that business software cannot be renewed.

## Assignment

Your job is to create the `BusinessSoftwareAdapter` class as described above.
Your class must include the appropriate javadoc comments,
although you do not need to generate the HTML from the javadoc comments.
You must also create a test class to test your `BusinessSoftwareAdapter` class. 

You must not make any changes to the `AnytownLibrary` class,
but you need to add a minimal amount of testing to `AnytownLibraryTest` to insure that `BusinessSoftwareAdapter` objects can be used with the methods in the `AnytownLibrary` class.

A careful study of the functional requirements and documentation provided will direct your efforts.
Be sure to ask for clarification on any of the requirements that are unclear.
You can create additional methods,
if needed,
to fully implement your classes.
