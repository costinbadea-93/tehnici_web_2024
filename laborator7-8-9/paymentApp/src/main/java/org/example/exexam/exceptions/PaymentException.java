package org.example.exexam.exceptions;

public class PaymentException extends RuntimeException {
    public PaymentException(String message){
        super(message);
    }
}
