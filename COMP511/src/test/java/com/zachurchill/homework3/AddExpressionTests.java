package com.zachurchill.homework3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AddExpressionTests {

    private MathExpression five;
    private MathExpression ten;
    private AddExpression fivePlusTen;

    @BeforeEach
    void setUp() {
        this.five = new ConstantExpression(5);
        this.ten = new ConstantExpression(10);
        this.fivePlusTen = new AddExpression(this.five, this.ten);
    }

    @Test
    void testToString() {
        assertEquals("(5 + 10)", this.fivePlusTen.toString());
    }

    @Test
    void testApply() {
        assertEquals(15, this.fivePlusTen.apply());
    }
}
