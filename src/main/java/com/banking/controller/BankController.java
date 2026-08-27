package com.banking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banking.exception.BankingException;
import com.banking.model.BankAccount;
import com.banking.model.Transaction;
import com.banking.service.BankService;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private final BankService bankService;

    public BankController(
            BankService bankService) {

        this.bankService = bankService;
    }

    // Create account
    @PostMapping("/account")
    public ResponseEntity<?> createAccount(

            @RequestParam String accountNumber,

            @RequestParam String accountHolder,

            @RequestParam double initialBalance) {

        try {

            return ResponseEntity.ok(
                    bankService.createAccount(
                            accountNumber,
                            accountHolder,
                            initialBalance
                    )
            );

        } catch (BankingException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    // Get account
    @GetMapping("/account")
    public ResponseEntity<?> getAccount(

            @RequestParam String accountNumber) {

        try {

            return ResponseEntity.ok(
                    bankService.getAccount(
                            accountNumber
                    )
            );

        } catch (BankingException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    // Deposit
    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(

            @RequestParam String accountNumber,

            @RequestParam double amount) {

        try {

            return ResponseEntity.ok(
                    bankService.deposit(
                            accountNumber,
                            amount
                    )
            );

        } catch (BankingException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    // Withdraw
    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(

            @RequestParam String accountNumber,

            @RequestParam double amount) {

        try {

            return ResponseEntity.ok(
                    bankService.withdraw(
                            accountNumber,
                            amount
                    )
            );

        } catch (BankingException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    // Balance
    @GetMapping("/balance")
    public ResponseEntity<?> getBalance(

            @RequestParam String accountNumber) {

        try {

            return ResponseEntity.ok(
                    bankService.getBalance(
                            accountNumber
                    )
            );

        } catch (BankingException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    // Transaction history
    @GetMapping("/transactions")
    public ResponseEntity<?> getTransactions(

            @RequestParam String accountNumber) {

        try {

            return ResponseEntity.ok(
                    bankService.getTransactions(
                            accountNumber
                    )
            );

        } catch (BankingException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    // All accounts
    @GetMapping("/accounts")
    public List<BankAccount> getAllAccounts() {

        return bankService.getAllAccounts();
    }
}