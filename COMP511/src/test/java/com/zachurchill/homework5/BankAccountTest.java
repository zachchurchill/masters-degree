package com.zachurchill.homework5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class BankAccountTest {

    BankAccount acct1;
    BankAccount acct2;
    BankAccount acct3;

    private static final double DELTA = 1E-6;

    @BeforeEach
    public void setUp() {
        acct1 = new BankAccount("Carnegie", 5000.0);
        acct2 = new BankAccount("Carnegie", 2000.0);
        acct3 = new BankAccount("Rockefeller", 10000.0);
    }

    @Test
    void testConstruction() {
        assertEquals("Carnegie", acct1.getCustomerName());
        assertEquals(0, acct1.getTransactionCount());
        assertEquals(5000.0, acct1.getBalance(), DELTA);
    }

    @Test
    void testDepositThrowsBadAmountException() {
        boolean negativeCaught = false;
        try {
            acct1.deposit(-100);
        } catch(BadAmountException e) {
            negativeCaught = true;
        }
        assertTrue(negativeCaught, "Negative numbers should throw error");

        boolean zeroCaught = false;
        try {
            acct1.deposit(0);
        } catch(BadAmountException e) {
            zeroCaught = true;
        }
        assertTrue(zeroCaught, "Zero should throw error");
    }

    @Test
    void testWithdrawThrowsBadAmountException() {
        boolean negativeCaught = false;
        try {
            acct1.withdraw(-100);
        } catch(BadAmountException e) {
            negativeCaught = true;
        }
        assertTrue(negativeCaught, "Negative numbers should throw error");

        boolean zeroCaught = false;
        try {
            acct1.withdraw(0);
        } catch(BadAmountException e) {
            zeroCaught = true;
        }
        assertTrue(zeroCaught, "Zero should throw error");
    }

    @Test
    void testTransferThrowsBadAmountException() {
        boolean negativeCaught = false;
        try {
            acct1.transfer(acct2, -100);
        } catch(BadAmountException e) {
            negativeCaught = true;
        }
        assertTrue(negativeCaught, "Negative numbers should throw error");

        boolean zeroCaught = false;
        try {
            acct1.transfer(acct2, 0);
        } catch(BadAmountException e) {
            zeroCaught = true;
        }
        assertTrue(zeroCaught, "Zero should throw error");
    }

    @Test
    void testWithdrawThrowsInsufficientFundsException() {
        boolean overdraftCaught = false;
        try {
            acct1.withdraw(acct1.getBalance() + 100);
        } catch(InsufficientFundsException e) {
            overdraftCaught = true;
        }
        assertTrue(overdraftCaught, "overdrafts should throw error");
    }

    @Test
    void testTransferThrowsInsufficientFundsException() {
        boolean overdraftCaught = false;
        try {
            acct1.transfer(acct2, acct1.getBalance() + 100);
        } catch(InsufficientFundsException e) {
            overdraftCaught = true;
        }
        assertTrue(overdraftCaught, "overdrafts should throw error");
    }

    @Test
    void testTransferThrowsAccountOwnerException() {
        boolean wrongOwnerCaught = false;
        try {
            acct1.transfer(acct3, acct1.getBalance());
        } catch(AccountOwnerException e) {
            wrongOwnerCaught = true;
        }
        assertTrue(wrongOwnerCaught, "Transfers between 2 owners should throw error");
    }

    @Test
    void testInvalidCustomerNameThrowsAccountOwnerException() {
        boolean nullNameCaught = false;
        try {
            BankAccount nullName = new BankAccount(null, 100);
        } catch(AccountOwnerException e) {
            nullNameCaught = true;
        }
        assertTrue(nullNameCaught, "Null name on initialization should throw error");

        boolean emptyStringCaught = false;
        try {
            BankAccount emptyName = new BankAccount("         ", 100);
        } catch(AccountOwnerException e) {
            emptyStringCaught = true;
        }
        assertTrue(emptyStringCaught, "Empty string name on initialization should throw error");
    }

    @Test
    void testNegativeInitialBalanceThrowsBadAmountException() {
        boolean negativeCaught = false;
        try {
            BankAccount negativeBalance = new BankAccount("frank", -10);
        } catch(BadAmountException e) {
            negativeCaught = true;
        }
        assertTrue(negativeCaught, "Negative initial balance should throw error");
    }
}
