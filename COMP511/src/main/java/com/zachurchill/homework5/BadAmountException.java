package com.zachurchill.homework5;

public class BadAmountException extends BankAccountException {

    public BadAmountException() {
        System.out.println("Bad amount provided.");
    }

    public BadAmountException(String message) {
        super(message);
    }
}
