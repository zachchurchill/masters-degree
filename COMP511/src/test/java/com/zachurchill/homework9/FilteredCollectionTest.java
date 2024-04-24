package com.zachurchill.homework9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FilteredCollectionTest {

    private ArrayList<Integer> allNumbers;
    private ArrayList<Integer> oddNumbers;
    private ArrayList<Integer> evenNumbers;

    @BeforeEach
    public void setUp() {
        this.allNumbers = new ArrayList<>();
        this.evenNumbers = new ArrayList<>();
        this.oddNumbers = new ArrayList<>();

        int [] data = {3, 2, 6, 5, 8, 12, 21, 19, 18, 13, 5, 0};
        for (int datum : data) {
            this.allNumbers.add(datum);
        }
        for (int datum : data) {
            if (datum % 2 == 0) {
                this.evenNumbers.add(datum);
            } else {
                this.oddNumbers.add(datum);
            }
        }
    }

    @Test
    void testExample() {
        FilteredCollection<Integer> filteredCollection = new FilteredCollection(
            this.allNumbers, new EvenFilter()
        );
        assertTrue(filteredCollection.containsAll(this.evenNumbers));
        assertFalse(filteredCollection.add(55));
        assertTrue(filteredCollection.remove(18));

        this.evenNumbers.removeIf((x) -> x == 18);
        assertTrue(filteredCollection.containsAll(this.evenNumbers));
    }

    @Test
    void testOddNumbersEvenFilterEmptyCollection() {
        FilteredCollection<Integer> filteredCollection = new FilteredCollection(
            this.oddNumbers, new EvenFilter()
        );
        assertEquals(0, filteredCollection.size());

    }
}
