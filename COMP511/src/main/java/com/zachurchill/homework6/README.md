# Homework 6

## Array Wrapper Revisited

In Homework 2 you implemented an ArrayWrapper class that abstracted some of the operations on an array of integers.
In Homework 3 you again extended this concept to use a Worker as a callback.

In this exercise you are rewriting ArrayWrapper and Worker so that the array can be of any type --
not just integers.
You should be able to reuse many of the algorithms from those homeworks.

Follow the specifications in each method's documentation to implement the following methods:
constructor,
size,
add,
get,
and delete.
A helper method that will check to see if an index is valid has been included for you.
You only need to call checkIndex and any code after that method call will only execute if the index is valid.

## Prime Factor Iterator

In this exercise you are writing an iterator that,
when given a long number,
repeatedly returns the next prime factor of that number.
The starter code sets up the `PrimeFactorIterator` object to implement both the `Iterable` and the `Iterator` interfaces.
Anything that is `Iterable` can be used as the source of a for/each loop in Java.

Your job is to turn the following algorithm,
which uses loops internally,
into an Iterator that will return results one-at-a-time.
In doing so,
your methods should calculate a new factor with each call to `next()`.
You may not generate all factors in the constructor and just return them one-by-one.
You must calculate each factor on the fly.

```{java}
public class RunMe {

    public static String primeFactorsOf(long num) {
        long factor = 2;
        StringBuffer sb = new StringBuffer();
        while (num > 1) {
            if (num % factor == 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(factor);
                num /= factor;
            } else {
                ++factor;
            }
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        long num = 9699690;
        System.out.println(primeFactorsOf(num));
    }
}
```

After converting this algorithm to an `Iterator`,
this code will also yield the same sequence of numbers:

```{java}
long num = 9699690;
for (long l : new PrimeFactorIterator(num)) {
    System.out.println(l);
}
```

Hints:

- The constructor should handle the initialization step of the loop.
It should reject (with an `IllegalArgumentException`) finding the factors of any number smaller than 2.
- The `hasNext()` function should handle the condition of the loop.
- The `next()` function should produce the result of each iteration of the loop as well as advancing the state of the iterator towards `hasNext()` eventually returning `false`.

You can use the runnable program above to generate as much test data as you wish. Simply change the value of `num` in `main()`and rerun the program.
