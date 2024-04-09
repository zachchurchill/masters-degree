package com.zachurchill.homework8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Question3Test {

    @Test
    void testContainsAll() {
        Question3<Integer> tester = new Question3<>();
        for(int i=0; i < 10; i++) {
            tester.add(i);
        }

        ArrayList<Integer> good = new ArrayList<>();
        good.add(1);
        good.add(3);
        assertTrue(tester.containsAll(good));
    }

    @Test
    void testRetainAll() {
        Question3<Integer> tester = new Question3<>();
        for(int i=0; i < 10; i++) {
            tester.add(i);
        }

        ArrayList<Integer> oneTwoThree = new ArrayList<>();
        oneTwoThree.add(1);
        oneTwoThree.add(2);
        oneTwoThree.add(3);
        assertTrue(tester.retainAll(oneTwoThree));
        assertEquals(3, tester.size());

        assertFalse(tester.retainAll(oneTwoThree));
        assertEquals(3, tester.size());
    }
}
