# Homework 5

2 out of the 3 problems existing in the `etc/homework5` folder.

## Throwing Exceptions

Recall the `BankAccount` class from Homework 1.
In the prior exercise,
we silently ignored illegal transactions
(e.g. attempting to deposit a negative amount,
transferring money between accounts with different owners,
etc.)
Now that we have studied exceptions,
however,
we can throw exceptions in response to bad inputs or states.

We will,
however,
be using our own exception hierarchy to convey additional information.
All exceptions will descend from a `BankAccountException` class that itself descends from `RuntimeException`:
-`InsufficientFundsException` - any attempt to overdraft an account should throw this exception
- `BadAmountException` - any illegal amount for deposit, withdraw, or transfer should throw this exception
- `AccountOwnerException` - any attempt to transfer between two accounts that aren't owned by the same person should throw this exception as should the constructor when given a bad owner name.

Each method has been described in the starter file.
Implement the class by adding instance fields and implementing the specified methods.
Create the inheritance hierarchy of exceptions as specified.
