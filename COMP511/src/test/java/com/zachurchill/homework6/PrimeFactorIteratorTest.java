package com.zachurchill.homework6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimeFactorIteratorTest {

    @Test
    void testThrowsErrorForNumbersLessThanTwo() {
        boolean caught = false;
        try {
            PrimeFactorIterator primes = new PrimeFactorIterator((long) 1);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);

        caught = false;
        try {
            PrimeFactorIterator primes = new PrimeFactorIterator((long) -1);
        } catch (IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    void testExampleAlgorithmResults() {
        long number = 9699690;
        PrimeFactorIterator primes = new PrimeFactorIterator(number);

        assertTrue(primes.hasNext());
        assertEquals(2, primes.next());
        assertTrue(primes.hasNext());
        assertEquals(3, primes.next());
        assertTrue(primes.hasNext());
        assertEquals(5, primes.next());
        assertTrue(primes.hasNext());
        assertEquals(7, primes.next());
        assertTrue(primes.hasNext());
        assertEquals(11, primes.next());
        assertTrue(primes.hasNext());
        assertEquals(13, primes.next());
        assertTrue(primes.hasNext());
        assertEquals(17, primes.next());
        assertTrue(primes.hasNext());
        assertEquals(19, primes.next());

        assertFalse(primes.hasNext());
    }

    @Test
    void test104053() {
        long primeNumber = 104053;
        PrimeFactorIterator primes = new PrimeFactorIterator(primeNumber);
        assertTrue(primes.hasNext());
        assertEquals(primeNumber, primes.next());
        assertFalse(primes.hasNext());
    }
}
