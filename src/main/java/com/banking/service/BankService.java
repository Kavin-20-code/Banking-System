package com.banking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.banking.exception.BankingException;
import com.banking.model.BankAccount;
import com.banking.model.SavingsAccount;
import com.banking.model.Transaction;

@Service
public class BankService {

    private final Map<String, BankAccount> accounts =
            new HashMap<>();

    // Create account
    public BankAccount createAccount(
            String accountNumber,
            String accountHolder,
            double initialBalance) {

        if (accounts.containsKey(accountNumber)) {

            throw new BankingException(
                    "Account already exists."
            );
        }

        if (initialBalance < 0) {

            throw new BankingException(
                    "Initial balance cannot be negative."
            );
        }

        BankAccount account =
                new SavingsAccount(
                        accountNumber,
                        accountHolder,
                        initialBalance,
                        4.0
                );

        accounts.put(accountNumber, account);

        return account;
    }

    // Find account
    public BankAccount getAccount(
            String accountNumber) {

        BankAccount account =
                accounts.get(accountNumber);

        if (account == null) {

            throw new BankingException(
                    "Account not found."
            );
        }

        return account;
    }

    // Deposit
    public BankAccount deposit(
            String accountNumber,
            double amount) {

        BankAccount account =
                getAccount(accountNumber);

        account.deposit(amount);

        return account;
    }

    // Withdraw
    public BankAccount withdraw(
            String accountNumber,
            double amount) {

        BankAccount account =
                getAccount(accountNumber);

        account.withdraw(amount);

        return account;
    }

    // Get balance
    public double getBalance(
            String accountNumber) {

        return getAccount(accountNumber)
                .getBalance();
    }

    // Transaction history
    public List<Transaction> getTransactions(
            String accountNumber) {

        return getAccount(accountNumber)
                .getTransactions();
    }

    // Get all accounts
    public List<BankAccount> getAllAccounts() {

        return accounts.values()
                .stream()
                .toList();
    }
}