package org.example.exexam.utils;

import org.example.exexam.dto.PaymentDto;
import org.example.exexam.model.Payment;

public class PaymentUtil {

    public static Payment fromDtoToPayment(PaymentDto paymentDto) {
        return Payment.builder()
                .paymentStatus(paymentDto.getPaymentStatus())
                .paymentType(paymentDto.getPaymentType())
                .customer(paymentDto.getCustomer())
                .amount(paymentDto.getAmount())
                .build();
    }
}
