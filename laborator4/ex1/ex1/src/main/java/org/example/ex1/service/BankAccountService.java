package org.example.ex1.service;

import jakarta.validation.Valid;
import org.example.ex1.exceptions.BankAccountNotFound;
import org.example.ex1.model.BankAccount;
import org.example.ex1.repository.BankAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private final Logger LOGGER = LoggerFactory.getLogger(BankAccountService.class);
    private final BankAccountRepository bankAccountRepository;

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;

        var b1 = BankAccount.builder()
                .accountNumber("000501c5")
                .accountOwner("Alex")
                .balance(20000)
                .currency("EUR")
                .build();

        var b2 = BankAccount.builder()
                .accountNumber("000502c5")
                .accountOwner("Ionut")
                .balance(50000)
                .currency("RON")
                .build();

        var b3 = BankAccount.builder()
                .accountNumber("000503c5")
                .accountOwner("Ciprian")
                .balance(20000)
                .currency("RON")
                .build();

        bankAccounts.addAll(List.of(b1, b2, b3));
    }


    public BankAccount saveNewBankAccount(BankAccount bankAccount) {
//
//        if(bankAccount.getAccountNumber() == null){
//          throw new BankAccountNotFound("Account Number cannot be null");
//        }

//        bankAccounts.add(bankAccount);

        LOGGER.info("Saving new bank account: {}", bankAccount);
//        return bankAccount;
        return bankAccountRepository.create(bankAccount);
    }

    public void removeBankAccount(String accountNumber) {
        bankAccounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
        LOGGER.info("Deleting bank account with account number : {}", accountNumber);
    }

    public BankAccount findBankAccountByAccountNumber(String accountNumber) {
        return bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getAccountNumber().equalsIgnoreCase(accountNumber))
                .findAny()
                .orElseThrow(() -> new RuntimeException("No bank account found with account number " + accountNumber));

    }

    public List<BankAccount> getBankAccounts() {
//        LOGGER.info("Getting bank accounts: {}", bankAccounts);
//        return bankAccounts;
        return bankAccountRepository.findAll();
    }

}
