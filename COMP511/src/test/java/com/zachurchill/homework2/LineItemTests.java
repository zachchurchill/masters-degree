package com.zachurchill.homework2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LineItemTest.
 *
 * @author Zach Churchill
 * @version 2024-03-03
 */
class LineItemTests {

    private Product duck;
    private LineItem ducks;

    @BeforeEach
    void setUp() {
        this.duck = new Product("Rubber Duck", 1.25);
        this.ducks = new LineItem(duck, 10);
    }

    @Test
    void testConstructorCorrectlySetsData() {
        assertEquals(duck, ducks.getProduct());
        assertEquals(10, ducks.getQuantity());
    }

    @Test
    void testTotalPriceCorrectlyCalculated() {
        assertEquals(12.5, ducks.getPrice());
    }

    @Test
    void testExpectedStringRepresentation() {
        assertTrue(ducks.toString().contains("Rubber Duck"));
        assertTrue(ducks.toString().contains("10"));
        assertTrue(ducks.toString().contains("$12.50"));
    }
}
