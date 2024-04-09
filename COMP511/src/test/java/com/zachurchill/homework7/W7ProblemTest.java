package com.zachurchill.homework7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class W7ProblemTest {

    private W7Problem<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new W7Problem<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
    }

    @Test
    void testSomething() {
        //use "list" defined above in your tests
        fail("Add your own test cases here");
    }
}
