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

}
