package com.bank.regulatory.model;

import java.time.LocalDate;

public class Transaction {

    private double amount;
    private LocalDate date;
    private boolean amlCompliant;

    public Transaction(double amount,LocalDate date,boolean amlCompliant) {
        this.amlCompliant = amlCompliant;
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isAmlCompliant() {
        return amlCompliant;
    }

    public void setAmlCompliant(boolean amlCompliant) {
        this.amlCompliant = amlCompliant;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction{");
        sb.append("amount=").append(amount);
        sb.append(", date=").append(date);
        sb.append(", amlCompliant=").append(amlCompliant);
        sb.append('}');
        return sb.toString();
    }


    



}
