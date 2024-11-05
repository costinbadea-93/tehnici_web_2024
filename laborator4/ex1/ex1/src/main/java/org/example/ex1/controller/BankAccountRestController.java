package org.example.ex1.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.ex1.model.BankAccount;
import org.example.ex1.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bankAccount")
public class BankAccountRestController {

    private final BankAccountService bankAccountService;

    @GetMapping("/list")
    public List<BankAccount> bankAccountList() {
        return bankAccountService.getBankAccounts();
    }

    @GetMapping("/byAccountNumber")
    public ResponseEntity<?> bankAccountList(@RequestParam String accountNumber) {
        try{
            return ResponseEntity.ok().body(bankAccountService.findBankAccountByAccountNumber(accountNumber));
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The given account number does not exist!!!");
        }
    }

    /**
     * Request param
     * http://localhost:8080/bankAccount/list?accountNumber=abc&accountType=abc
     *
     * Path Variable
     * http://localhost:8080/bankAccount/list/abc
     *
     */
//    @DeleteMapping("/remove")
//    public void deleteBankAccount(@RequestParam String accountNumber) {
//         bankAccountService.removeBankAccount(accountNumber);
//    }

    @DeleteMapping("/remove/{accountNumber}")
    public void deleteBankAccount(@PathVariable String accountNumber) {
        bankAccountService.removeBankAccount(accountNumber);
    }

    @PostMapping("/new")
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bankAccountService.saveNewBankAccount(bankAccount));
    }
}
