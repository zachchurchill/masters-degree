/**
 * In this exercise you are writing some methods for a BankAccount class.
 * A bank account has a customer name, a balance, and a count of transactions.
 * The customer can issue transactions to deposit and withdraw funds from an account.
 * A customer can also issue a transaction to transfer funds from one account to another as long as they own both accounts. 
 *
 * Each method has been described in the starter file. Implement the class by adding instance fields and implementing the specified methods.
 */
package com.zachurchill.homework1;

/**
 * A bank account class. Bank accounts have customer names,
 * balances, and transaction counts.
 */
public class BankAccount {

    private String customerName;
    private double balance = 0.0;
    private int transactions = 0;

    /**
    * Constructs a bank account belonging to the customer
    * with the given initial balance. The initial balance
    * cannot be negative.
    */
    public BankAccount(String customerName, double initialBalance) {
        this.customerName = customerName;
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("initial balance must be non-negative");
        }
    }

    /**
     * Returns a count of how many deposits, withdrawals, and
     * transfers were successful. Illegal transactions should
     * not be counted.
     */
    public int getTransactionCount() {
        return this.transactions;
    }

    /**
     * Returns the name of the customer that owns the account.
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * Returns the current balance of this account.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Deposits the amount into the account. Only non-zero,
     * positive deposit amounts are allowed. Successful
     * deposits increment the transaction count.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.transactions++;
            System.out.println("deposit successful");
        } else {
            System.out.println("only non-zero, positive amounts allowed");
        }
    }

    /**
     * Withdraws the amount from the account. Only non-zero,
     * positive withdrawal amounts are allowed. Accounts are
     * not permitted to overdraft. Successful withdrawals
     * increment the transaction count.
     */
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
                this.transactions++;
                System.out.println("withdrawal successful");
            } else {
                System.out.println("insufficient funds");
            }
        } else {
            System.out.println("only non-zero, positive amounts allowed");
        }
    }

    /**
     * Transfers the amount from this account to the destination
     * account. This is only valid if the same person owns both
     * accounts. Further, only non-zero, positive amounts are
     * allowed. Accounts are not permitted to overdraft.
     * Successful transfers increment the transaction count
     * of both accounts.
     */
    public void transfer(BankAccount destination, double amount) {
        if (this.getCustomerName() == destination.getCustomerName()) {
            if (amount <= this.balance) {
                // these methods takes care of transaction counts
                this.withdraw(amount);
                destination.deposit(amount);
                System.out.println("transfer complete");
            } else {
                System.out.println("insufficient funds");
            }
        } else {
            System.out.println("same person must own both accounts");
        }
    }

    /**
     * Produce a string containing the details of this account.
     * Assertions a minimum, the string should contain the account
     * holder name, the balance, and the transaction count.
     */
    public String toString() {
        return String.format(
            "BankAccount for %s, balance of %f with %d transactions",
            this.getCustomerName(),
            this.getBalance(),
            this.getTransactionCount()
        );
    }

    public static void main(String[] args) {
        BankAccount primary = new BankAccount("Carnegie", 5000.0);
        BankAccount backup = new BankAccount("Carnegie", 10.0);
        System.out.println(primary.toString());
        System.out.println(backup.toString());
        backup.withdraw(1000);
        primary.transfer(backup, 1500);
        backup.withdraw(1000);

        System.out.println(primary.toString());
        System.out.println(backup.toString());
    }
}
