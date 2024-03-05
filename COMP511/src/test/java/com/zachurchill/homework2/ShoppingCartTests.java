package com.zachurchill.homework2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * The test class ShoppingCart.
 *
 * @author Zach Churchill
 * @version 2024-03-03
 */
class ShoppingCartTests {

    private ShoppingCart cart;
    private Product duck;
    private Product phone;

    @BeforeEach
    void setUp() {
        this.cart = new ShoppingCart();
        this.duck = new Product("Rubber Duck", 1.25);
        this.phone = new Product("iPhone", 1000);
    }

    @Test
    void testShoppingCartStartsOutEmpty() {
        assertEquals(0, this.cart.getCartTotal());
    }

    @Test
    void testAddProductCorrectIncrementsCartTotal() {
        this.cart.addProduct(this.duck, 10);
        assertEquals(12.5, this.cart.getCartTotal());

        this.cart.addProduct(this.phone, 1);
        assertEquals(1012.5, this.cart.getCartTotal());
    }

    @Test
    void testExpectedStringRepresentation() {
        assertEquals("Total: $0.00", this.cart.toString());

        this.cart.addProduct(this.duck, 10);
        assertTrue(this.cart.toString().contains(this.duck.getName()));
        assertTrue(this.cart.toString().contains("10"));
        assertTrue(this.cart.toString().contains("$12.50"));
        assertTrue(this.cart.toString().contains("Total: $12.50"));

        this.cart.addProduct(this.phone, 1);
        assertTrue(this.cart.toString().contains(this.duck.getName()));
        assertTrue(this.cart.toString().contains("10"));
        assertTrue(this.cart.toString().contains("$12.50"));
        assertTrue(this.cart.toString().contains(this.phone.getName()));
        assertTrue(this.cart.toString().contains("1"));
        assertTrue(this.cart.toString().contains("$1000.00"));
        assertTrue(this.cart.toString().contains("Total: $1012.50"));
    }
}
