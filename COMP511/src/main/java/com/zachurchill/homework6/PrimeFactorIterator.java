package com.zachurchill.homework6;

import java.lang.Iterable;
import java.util.Iterator;

public class PrimeFactorIterator implements Iterable<Long>, Iterator<Long> {

    private long number;
    private long factor;

    public PrimeFactorIterator(long number) {
        if (number < 2) {
            throw new IllegalArgumentException("number should be greater than or equal to 2");
        }
        this.number = number;
        this.factor = 2;

        if (!this.hasNext()) {
            this.skipToNext();
        }
    }

    public Iterator<Long> iterator() {
        return this;
    }

    private void skipToNext() {
        while (this.number > 1 && !this.hasNext()) {
            if (this.hasNext()) {
                break;
            } else {
                this.factor++;
            }
        }
    }

    public boolean hasNext() {
        return this.number % this.factor == 0;
    }

    public Long next() {
        Long returnedFactor = this.factor;
        this.number /= this.factor;
        this.skipToNext();
        return returnedFactor;
    }
}
