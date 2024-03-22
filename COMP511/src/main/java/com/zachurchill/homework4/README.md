# Homework 4 Problem Statements

## Classic Encryption Algorithms

As a warmup for the template method and strategy patterns,
you will need to implement two classic encryption algorithms:
a substitution cypher and a transposition cypher.
Each are described below.

### Substitution Cypher

The first classic algorithm is a substitution cypher.
In this algorithm,
you are given a key that is used to substitute one character for another.
The key given to you is a string.
The 0th character in that string is used in place of 'a' and the 26th character is used in place of 'z'.
Given a key,
you are to write an encrypt() and decrypt() method that will perform the forward and backward substitutions.
Here are several examples:
- Given a key of "nopqrstuvwxyzabcdefghijklm",
encrypting "Attack at dawn!" should yield "Nggnpx ng qnja!".
Likewise,
you can decrypt back to the original string.
- Given a key of "qwertyuiopasdfghjklzxcvbnm",
encrypting "Hello, world." should yield "Itssg, vgksr."
Again,
you can decrypt back to the original string.

A couple things to note:
- You will always be given a "good" encryption key of all lower case letters a-z with each letter appearing only once.
- Case should be preserved (note that the "H" in "Hello, world." above becomes an upper-case "I" in the encrypted version).
- Non-character data (spaces, symbols, punctuation, etc.) should be output exactly as they are.
- You may want to look at the Character class for helpful functions such as isAlphabetic, toLowerCase, isUpperCase, and toUpperCase.
The String class method charAt is also helpful.
- You can easily convert a character into a kind of index by subtracting an 'a' character.
For example, 'c'-'a' is 2, and 2 is the "index" of 'c' in the alphabet when starting counting at 0.

### Transposition Cypher

The second classic algorithm is a transposition cypher.
In this algorithm,
you are given a key consisting of two integers -
the number of rows and the number of columns in a matrix.
You create the 2D array of characters using this number of rows and columns and then place the characters by row and then column in the matrix.
Encryption is performed by reading the characters out of the matrix by column and then row.
Here's an example:
Given a key of 3 rows and 5 columns,
encrypting "Attack at dawn!" would produce a matrix as follows:
```
    0   1   2   3   4
    +---+---+---+---+---+
  0 | A | t | t | a | c |
    +---+---+---+---+---+
  1 | k |   | a | t |   |
    +---+---+---+---+---+
  2 | d | a | w | n | ! |
    +---+---+---+---+---+
``` 
When this matrix is read out by column,
it will produce the string "Akdt atawatnc !"

Decryption is done in reverse by making a matrix that has 5 rows and 3 columns and placing the encrypted text by row:
```
    0   1   2
    +---+---+---+
  0 | A | k | d |
    +---+---+---+
  1 | t |   | a | 
    +---+---+---+
  2 | t | a | w |
    +---+---+---+
  3 | a | t | n |
    +---+---+---+
  4 | c |   | ! |
    +---+---+---+
```
When this is read out by column it will yield "Attack at dawn!"

A couple things to note:
- You will always be given a "good" key of two positive, non-zero integers.
- You can be given more characters to encrypt than will fit in the matrix.
In that case,
you will need to extract the data by column,
and then continue with the next batch of characters in the string.
- If a plain text is shorter than the number of elements in the matrix,
use a space character to fill the unused array elements.
So for example,
given the a key of 3 and 5,
encrypting "Hello, world." would yield "H,le dlw.lo or "
- When you decrypt space-padded messages,
you should trim() the string of the added whitespace before returning it.

---

## Strategy Pattern Encryption

Now that you have completing the encryption algorithms,
we're going to use them as a strategy for encrypting files (an InputStream, really).
In this part of the assignment,
you will create a `FileEncryption` class that takes an `EncryptionStrategy` as a parameter.
You will read each line from the file,
encrypt it using the strategy,
and write it out to an OutputStream.

The algorithm breaks down like this:
- Wrap the InputStream in a Scanner by passing it to the Scanner constructor.
- Wrap the OutputStream in a PrintWriter by passing it to the PrintWriter constructor.
- Read lines from the scanner and encrypt/decrypt them.
- Write the encrypted strings to the print writer.
- Stop when the scanner has no more lines to read.

Some helpful hints:
- The Scanner methods hasNextLine and nextLine are helpful.
- You can pass an InputStream to the constructor of the Scanner to easily read from the InputStream
- You can pass an OutputStream to the constructor of a PrintWriter to easily write to the OuptutStream
- System.out is a PrintWriter!
- Make sure to call flush() on your PrintWriter object before returning from your methods.

---

## Template Method Pattern Encryption

Now that you have completing the encryption algorithms,
we're going to use them as subclasses  for encrypting files (an InputStream, really).
In this part of the assignment,
you will create a `FileEncryption` base class and two subclasses (following the template method pattern) that implement the encrypt and decrypt operations.
You will read each line from the file,
encrypt it,
and write it out to an OutputStream.

The algorithm breaks down like this:
- Wrap the InputStream in a Scanner by passing it to the Scanner constructor.
- Wrap the OutputStream in a PrintWriter by passing it to the PrintWriter constructor.
- Read lines from the scanner and encrypt/decrypt them.
- Write the encrypted strings to the print writer.
- Stop when the scanner has no more lines to read.

Some helpful hints:
- The Scanner methods hasNextLine and nextLine are helpful.
- You can pass an InputStream to the constructor of the Scanner to easily read from the InputStream
- You can pass an OutputStream to the constructor of a PrintWriter to easily write to the OuptutStream
- System.out is a PrintWriter!
- Make sure to call flush() on your PrintWriter object before returning from your methods.

---

## Extending the implementation

Consider how you might combine both substitution and transposition cyphers into a composite algorithm that does both to plain text.

- Describe how that would be accomplished with the Strategy pattern
- Describe how that would be accomplished with the Template Method pattern
- Which would be easier to implement and why?
