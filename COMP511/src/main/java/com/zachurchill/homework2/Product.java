/**
 * Multiple Classes & Methods
 * In this exercise, you will be implementing methods in three classes:
 * Product, LineItem, and ShoppingCart. Not sruprisingly, this system
 * models an online shopping cart. Each of these are described below:
 * - Product models a product in a store. It has a name and a price
 *   and several methods to access those pieces of data.
 * - LineItem models a line item on a receipt. It has a product and
 *   a quantity. The price for the line item is the price of the product
 *   multiplied by the quantity.
 * - ShoppingCart models a cart of line items. You can add products to
 *   the cart and get the total price for the purchase.
 *
 * Each of the methods within the classes are described in the API
 * documentation for the class.
 */
package com.zachurchill.homework2;

public class Product {
    // the name of the product
    private String name;
    // the price for one of the product
    private double price;

    /**
     * Constructs a product from the parameters
     * @param name - the product name
     * @param price - the price for a single product
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the product
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the price of the product
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns a string containing both the name and price of
     * the product. Price should be of the form $xx.xx (e.g.
     * containing a dollar sign and only 2 decimal places).
     */
    public String toString() {
        return String.format("%s for $%.2f", this.name, this.price);
    }
}
