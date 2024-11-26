package org.example.ex1.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankAccount {
    private int id;
    @NotNull(message = "Account number cannot be null")
//    @Pattern("")
    private String accountNumber;
    private double balance;
    @NotNull(message = "Account owner cannot be null")
    private String accountOwner;
    private String currency;
}
