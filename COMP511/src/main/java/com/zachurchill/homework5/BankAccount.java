package com.zachurchill.homework5;

/**
 * A bank account class. Bank accounts have customer names,
 * balances, and transaction counts.
 */
public class BankAccount {

    /**
     * Constructs a bank account belonging to the customer
     * with the given initial balance. The initial balance
     * cannot be negative. The customer's name cannot be null
     * nor can it be an empty string after being trimmed.
     */
    public BankAccount(String customerName, double initialBalance) {
        // your code here
    }

    /**
     * Returns a count of how many deposits, withdrawals,
     * and transfers were successful. Illegal transactions
     * should not be counted.
     */
    public int getTransactionCount() {
        // your code here;
        return -1;
    }

    /**
     * Returns the name of the customer that owns this
     * account
     */
    public String getCustomerName() {
        // your code here
        return null;
    }

    /**
     * Returns the current balance of this account
     */
    public double getBalance() {
        // your code here
        return -1.0;
    }

    /**
     * Deposits the amount into the account. Only non-zero,
     * positive deposit amounts are allowed. Successful
     * deposits increment the transaction count.
     */
    public void deposit(double amount) {
        // your code here
    }

    /**
     * Withdraws the amount from the account. Only non-zero,
     * positive withdrawal amounts are allowed. Accounts
     * are not permitted to overdraft. Successful
     * withdrawals increment the transaction count.
     */
    public void withdraw(double amount) {
        // your code here
    }

    /**
     * Transfers the amount from this account to the destination
     * account. This is only valid if the same person owns both
     * accounts. Further, only non-zero, positive amounts are
     * allowed. Accounts are not permitted to overdraft.
     * Successful transfers increment the transaction
     * count in both accounts.
     */
    public void transfer(BankAccount destination, double amount) {
        // your code here
    }

    /**
     * Produce a string containing the details of this account. At
     * a minimum, the string should contain the account holder name,
     * the balance, and the transaction count.
     */
    public String toString() {
        // your code here
        return null;
    }
}
