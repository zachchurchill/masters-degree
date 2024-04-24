package com.zachurchill.homework9;

public class EvenFilter implements Filter<Integer> {
    @Override
    public boolean matches(Integer element) {
        return element.intValue() % 2 == 0;
    }
}
