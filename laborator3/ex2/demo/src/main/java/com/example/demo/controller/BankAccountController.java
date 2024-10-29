package com.example.demo.controller;

import com.example.demo.model.BankAccount;
import com.example.demo.service.BankAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bcankAccountService) {
        this.bankAccountService = bcankAccountService;
    }

    @GetMapping("/")
    public String listBankAccounts(Model model) {
        model.addAttribute("bankAccount", new BankAccount());
        model.addAttribute("data", bankAccountService.getBankAccounts());
        return "index";
    }

    @GetMapping("/delete/{accountNumber}")
    public String deleteBankAccount(Model model, @PathVariable String accountNumber){
        bankAccountService.deleteBankAccountByAccountNumber(accountNumber);
        model.addAttribute("bankAccount", new BankAccount());
        model.addAttribute("data", bankAccountService.getBankAccounts());
        return "index";
    }

    @PostMapping("/bankAccount/add")
    public String addPerson(@ModelAttribute("bankAccount") BankAccount bankAccount, Model model){
        bankAccountService.createBankAccount(bankAccount);
        model.addAttribute("data", bankAccountService.getBankAccounts());
        return "index";
    }
}
