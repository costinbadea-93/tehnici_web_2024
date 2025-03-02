package org.example.exexam.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exexam.utils.PaymentStatus;
import org.example.exexam.utils.PaymentType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentDto {
    @NotNull(message = "Payment type cannot be null.")
    private PaymentType paymentType;
    @NotNull(message = "Customer cannot be null.")
    private String customer;
    @Min(value = 1, message = "The amount should be greater than 1")
    private double amount;
    @NotNull(message = "Payment status cannot be null.")
    private PaymentStatus paymentStatus;
}