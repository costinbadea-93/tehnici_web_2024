package org.example.ex1.exceptions;

public class BankAccountNotFound extends RuntimeException{
    public BankAccountNotFound(String message) {
        super(message);
    }
}
