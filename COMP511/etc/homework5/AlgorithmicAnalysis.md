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
**Time complexity:**
**Explanation:**

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
**Time complexity:**
**Explanation:**

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
**Time complexity:**
**Explanation:**
