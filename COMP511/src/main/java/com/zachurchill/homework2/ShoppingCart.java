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

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    // a collection of all the things being purchased
    // and their quantities in a line item.
    private List<LineItem> items;

    /**
     * Initializes an empty shopping cart.
     */
    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * Adds a line item to the list of line items.
     */
    public void addProduct(Product product, int quantity) {
        LineItem item = new LineItem(product, quantity);
        this.items.add(item);
    }

    /**
     * Calculates the total of all the line items (products
     * and quantities) in the shopping cart.
     */
    public double getCartTotal() {
        double total = 0;
        for (LineItem item : this.items) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     * Produces a "receipt" of containing all the line item
     * data and the total of everything in the shopping cart.
     */
    public String toString() {
        List<String> entries = new ArrayList<>();
        for (LineItem item : this.items) {
            entries.add(item.toString());
        }
        entries.add(String.format("Total: $%.2f", this.getCartTotal()));
        return String.join("\n", entries);
    }
}
