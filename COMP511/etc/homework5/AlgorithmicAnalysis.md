# Algorithmic Analysis

For each of the following algorithms,
identify the efficiency.
Provide an explanation justifying your answer.
Assume that m and n are non-negative integers and that `doSomething()` is a constant time method call.

### Algorithm (A)
```{java}
public void algorithmFun1(int n) {
    for (int i = 0; i < n; ++i) {
        for (int j = i; j > 0; j = j / 2) {
            doSomething();
        }
    }
}
```
**Time complexity:** O(n * log(n))
**Explanation:**
outer loop: O(n)
inner loop: log2(n) * O(1) => O(log(n))
therefore, O(n * log(n))

### Algorithm (B)
```{java}
public void algorithmFun2(int n) {
    while (n > 0) {
        algorithmFun1(n);
        algorithmFun1(n/2);
        n = n - 1;
    }
}
```
**Time complexity:** O(n^2 * log(n))
**Explanation:**
loop: O(n)
within loop: O(n * log(n)) + O(n/2 * log(n/2)) => O(n * log(n))
therefore, O(n) * O(n * log(n)) => O(n^2 * log(n))


### Algorithm (C)
```{java}
public void algorithmFun3(int n, int m) {
    for (int i = 0; i < n; i = i + 2) {
        doSomething();
        while (m > 0) {
            doSomething();
            m = m / 3;
        }
    }
}
```
**Time complexity:**  O(n * log(m))
**Explanation:**
inner loop: log3(m) * O(1) => O(log(m))
outer loop: n/2 * O(1) => O(n)
therefore, O(n) * O(log(m)) => O(n * log(m))
