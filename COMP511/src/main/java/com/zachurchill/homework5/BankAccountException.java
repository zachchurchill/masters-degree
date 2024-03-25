package com.zachurchill.homework5;

public class BankAccountException extends RuntimeException {

    public BankAccountException() {
        System.out.println("General bank account exception.");
    }

    public BankAccountException(String message) {
        super(message);
    }
}
