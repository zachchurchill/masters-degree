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

public class LineItem {
    // the product being purchased
    private Product product;
    // the quantity of that product
    private int quantity;

    /**
     * Constructs a line item from the parameters
     * @param product - the product being purchased
     * @param quantity - the quantity of that product
     */
    public LineItem(Product product, int quantity) {
        // insert your code here
    }

    /**
     * Returns the product from the line item.
     */
    public Product getProduct() {
        // replace this with your code
        return null;
    }

    /**
     * Returns the quantity from the line item
     */
    public int getQuantity() {
        // replace this with your code
        return Integer.MAX_VALUE;
    }

    /**
     * Returns the total price for the line item as the
     * product price multiplied by the quantity.
     */
    public double getPrice() {
        // replace this with your code
        return Double.MAX_VALUE;
    }

    /**
     * Returns a string containing the product information,
     * the quantity, and the total price. The total price should
     * be of the form $xx.xx (e.g. containing a dollar sign
     * and only 2 decimal places).
     */
    public String toString() {
        // replace this with your code
        return "";
    }
}
