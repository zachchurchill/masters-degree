package com.zachurchill.homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SubtractExpressionTests {

    private MathExpression five;
    private MathExpression ten;
    private SubtractExpression fiveMinusTen;

    @BeforeEach
    void setUp() {
        this.five = new ConstantExpression(5);
        this.ten = new ConstantExpression(10);
        this.fiveMinusTen = new SubtractExpression(this.five, this.ten);
    }

    @Test
    void testToString() {
        assertEquals("(5 - 10)", this.fiveMinusTen.toString());
    }

    @Test
    void testApply() {
        assertEquals(-5, this.fiveMinusTen.apply());
    }
}

