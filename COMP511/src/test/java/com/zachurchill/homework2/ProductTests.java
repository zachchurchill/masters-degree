package com.zachurchill.homework2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The test class Product.
 *
 * @author Zach Churchill
 * @version 2024-03-03
 */
class ProductTests {

    @Test
    void testConstructorCorrectlySetsData() {
        Product product = new Product("Rubber Duck", 1.25);
        assertEquals("Rubber Duck", product.getName());
        assertEquals(1.25, product.getPrice());
    }

    @Test
    void testExpectedStringRepresentation() {
        Product product = new Product("Rubber Duck", 1);
        assertTrue(product.toString().contains("Rubber Duck"));
        assertTrue(product.toString().contains("$1.00"));

        Product cheapDuck = new Product("Rubber Duck", 0.49);
        assertTrue(cheapDuck.toString().contains("$0.49"));
    }
}
