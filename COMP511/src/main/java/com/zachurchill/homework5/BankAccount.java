package com.zachurchill.homework5;

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
     * cannot be negative. The customer's name cannot be null
     * nor can it be an empty string after being trimmed.
     */
    public BankAccount(String customerName, double initialBalance)
            throws AccountOwnerException, BadAmountException {
        if (customerName == null) {
            throw new AccountOwnerException("Customer name should not be null");
        } else if(customerName.trim() == "") {
            throw new AccountOwnerException("Customer name should not be empty");
        }
        this.customerName = customerName;

        if (initialBalance < 0) {
            throw new BadAmountException("Initial balance should be non-negative.");
        }
        this.balance = initialBalance;
    }

    /**
     * Returns a count of how many deposits, withdrawals,
     * and transfers were successful. Illegal transactions
     * should not be counted.
     */
    public int getTransactionCount() {
        return this.transactions;
    }

    /**
     * Returns the name of the customer that owns this
     * account
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * Returns the current balance of this account
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Deposits the amount into the account. Only non-zero,
     * positive deposit amounts are allowed. Successful
     * deposits increment the transaction count.
     */
    public void deposit(double amount) throws BadAmountException {
		if (amount > 0) {
            this.balance += amount;
            this.transactions++;
            System.out.println("deposit successful");
        } else {
            throw new BadAmountException("only non-zero, positive amounts allowed");
        }
    }

    /**
     * Withdraws the amount from the account. Only non-zero,
     * positive withdrawal amounts are allowed. Accounts
     * are not permitted to overdraft. Successful
     * withdrawals increment the transaction count.
     */
    public void withdraw(double amount) throws BadAmountException, InsufficientFundsException {
		if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
                this.transactions++;
                System.out.println("withdrawal successful");
            } else {
                throw new InsufficientFundsException("insufficient funds");
            }
        } else {
            throw new BadAmountException("only non-zero, positive amounts allowed");
        }
    }

    /**
     * Transfers the amount from this account to the destination
     * account. This is only valid if the same person owns both
     * accounts. Further, only non-zero, positive amounts are
     * allowed. Accounts are not permitted to overdraft.
     * Successful transfers increment the transaction
     * count in both accounts.
     */
    public void transfer(BankAccount destination, double amount)
            throws BadAmountException, InsufficientFundsException, AccountOwnerException {
		if (this.getCustomerName() == destination.getCustomerName()) {
            // these methods takes care of transaction counts
            this.withdraw(amount);
            destination.deposit(amount);
            System.out.println("transfer complete");
        } else {
            throw new AccountOwnerException("same person must own both accounts");
        }
    }

    /**
     * Produce a string containing the details of this account. At
     * a minimum, the string should contain the account holder name,
     * the balance, and the transaction count.
     */
    public String toString() {
        // your code here
        return String.format(
            "BankAccount for %s, balance of %f with %d transactions",
            this.getCustomerName(),
            this.getBalance(),
            this.getTransactionCount()
        );
    }
}
