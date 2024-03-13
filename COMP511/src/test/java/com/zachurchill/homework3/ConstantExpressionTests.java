package com.zachurchill.homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ConstantExpressionTests {

    private MathExpression five;

    @BeforeEach
    void setUp() {
        this.five = new ConstantExpression(5);
    }

    @Test
    void testToString() {
        assertEquals("5", this.five.toString());
    }

    @Test
    void testApply() {
        assertEquals(5, this.five.apply());
    }
}
