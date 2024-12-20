package org.example.exexam.utils;

import java.util.Arrays;
import java.util.Objects;

public enum PaymentStatus {
    NEW,
    PROCESSED,
    CANCELLED;

    public static PaymentStatus getValueByString(String paymentStatus) {
        return Arrays.stream(PaymentStatus.values())
                .filter(p -> p.name().equals(paymentStatus))
                .findAny()
                .orElse(null);
    }
}
