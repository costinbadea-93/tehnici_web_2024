package service;

import model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountService {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccountService() {
        BankAccount bankAccount1 = BankAccount.builder()
                .accountNumber("00501C5")
                .accountOwner("Alex")
                .balance(50000)
                .build();

        BankAccount bankAccount2 = BankAccount.builder()
                .accountNumber("00502C5")
                .accountOwner("Ionut")
                .balance(4000)
                .build();

        BankAccount bankAccount3 = BankAccount.builder()
                .accountNumber("00503C5")
                .accountOwner("Madalin")
                .balance(3000)
                .build();

        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);
        bankAccounts.add(bankAccount3);
    }


    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        return bankAccount;
    }

    public void deleteBankAccountByAccountNumber(String accountNumber) {
        bankAccounts = bankAccounts.stream()
                .filter(bankAccount -> !bankAccount.getAccountNumber().equalsIgnoreCase(accountNumber))
                .collect(Collectors.toList());
    }
}
