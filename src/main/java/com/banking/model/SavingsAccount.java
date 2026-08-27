package com.banking.model;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(
            String accountNumber,
            String accountHolder,
            double initialBalance,
            double interestRate) {

        super(
                accountNumber,
                accountHolder,
                initialBalance
        );

        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double calculateInterest() {

        return balance * interestRate / 100;
    }
}