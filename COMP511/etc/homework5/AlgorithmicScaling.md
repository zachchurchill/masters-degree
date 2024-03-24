# Algorithmic Scaling

## Question 1

If a O(n^2) algorithm takes 15 seconds to complete on an input size of 40,
how many seconds will it take to complete on an input size of 240?

Steps:
- 240^2 / 40^2 = x / 15
- (240 / 40)^2 * 15 = x
- x = 36 * 15 = 540

## Question 2

If a O(log n) algorithm takes 2700 ms to complete on an input size of 512,
how many milliseconds will it take to complete on an input size of 65,536?

You may want to consult some
[rules of logarithms](https://www.rapidtables.com/math/algebra/Logarithm.html).

Steps:
- log2(65536) / log2(512) = x / 2700
- 16 / 9 * 2700 = x
- x ~= 4800

## Question 3

If a O(2^n) algorithm takes 96 minutes to complete on an input size of 100,
how many minutes will it take to complete on an input size of 96?

You may want to consult some
[rules of exponents](https://www.rapidtables.com/math/number/exponent.html).

Steps:
- 2^96 / 2^100 = x / 96
- 2^(-4) * 96 = x
- 1 / 16 * 96 = x
- x = 6

## Question 4

If a O(1) algorithm takes 32 milliseconds to complete on an input size of 32,
how many milliseconds will it take to complete on an input size of 64?

x = 32

constant time.

## Question 5

If a O(n) algorithm takes 45 milliseconds to complete on an input size of 900,
how many milliseconds will it take to complete on an input size of 300?

Steps:
- 300 / 900 = x / 45
- 300 / 900 * 45 = x
- x = 15
