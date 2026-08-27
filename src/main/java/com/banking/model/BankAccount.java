package com.banking.model;

import java.util.ArrayList;
import java.util.List;

import com.banking.exception.BankingException;

public class BankAccount {

    protected String accountNumber;

    protected String accountHolder;

    protected double balance;

    protected List<Transaction> transactions =
            new ArrayList<>();

    public BankAccount() {
    }

    public BankAccount(
            String accountNumber,
            String accountHolder,
            double initialBalance) {

        this.accountNumber = accountNumber;

        this.accountHolder = accountHolder;

        this.balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount <= 0) {

            throw new BankingException(
                    "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        transactions.add(
                new Transaction(
                        "DEPOSIT",
                        amount,
                        balance
                )
        );
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {

            throw new BankingException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {

            throw new BankingException(
                    "Insufficient balance."
            );
        }

        balance -= amount;

        transactions.add(
                new Transaction(
                        "WITHDRAW",
                        amount,
                        balance
                )
        );
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}