package org.example.ex1.model;


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
    private String accountNumber;
    private double balance;
    private String accountOwner;
    private String currency;
}
