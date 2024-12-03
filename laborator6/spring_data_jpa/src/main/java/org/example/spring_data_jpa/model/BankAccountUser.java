package org.example.spring_data_jpa.model;

import java.util.List;

public class BankAccountUser {

    private int id;
    private String firstName;
    private String lastName;

    private List<BankAccount> bankAccounts;
}
