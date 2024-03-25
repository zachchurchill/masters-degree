package com.zachurchill.homework5;

public class AccountOwnerException extends BankAccountException {

    public AccountOwnerException() {
        System.out.println("Invalid account owner");
    }

    public AccountOwnerException(String message) {
        super(message);
    }
}
