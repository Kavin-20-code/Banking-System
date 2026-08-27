package com.banking.model;

import java.time.LocalDateTime;

public class Transaction {

    private String type;
    private double amount;
    private double balance;
    private LocalDateTime date;

    public Transaction() {
    }

    public Transaction(
            String type,
            double amount,
            double balance) {

        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.date = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getDate() {
        return date;
    }
}