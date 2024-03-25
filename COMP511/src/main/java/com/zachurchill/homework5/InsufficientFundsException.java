package com.zachurchill.homework5;

public class InsufficientFundsException extends BankAccountException {

    public InsufficientFundsException() {
        System.out.println("Insufficient funds");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
