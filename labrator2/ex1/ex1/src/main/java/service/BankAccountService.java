package service;

import model.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountService {

    public boolean makeTransfer(BankAccount from, BankAccount to, double amount) {
        if(amount > from.getBalance()) {
            throw new RuntimeException("Invalid amount, please check bank acc amount again!");
        } else{
            System.out.println("Transfer from " + from.getAccountNumber() + " to " + to.getAccountNumber() + " amount: " + amount);
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            return true;
        }
    }

//    public boolean makeTransfer1(BankAccount from, BankAccount to, double amount) {
//        if(amount > from.getBalance()) {
//            throw new RuntimeException("Invalid amount, please check bank acc amount again!");
//        } else{
//            System.out.println("Transfer from " + from.getAccountNumber() + " to " + to.getAccountNumber() + " amount: " + amount);
//            from.setBalance(from.getBalance() - amount);
//            to.setBalance(to.getBalance() + amount);
//            return true;
//        }
//    }
//
//    public boolean makeTransfer2(BankAccount from, BankAccount to, double amount) {
//        if(amount > from.getBalance()) {
//            throw new RuntimeException("Invalid amount, please check bank acc amount again!");
//        } else{
//            System.out.println("Transfer from " + from.getAccountNumber() + " to " + to.getAccountNumber() + " amount: " + amount);
//            from.setBalance(from.getBalance() - amount);
//            to.setBalance(to.getBalance() + amount);
//            return true;
//        }
//    }
}
