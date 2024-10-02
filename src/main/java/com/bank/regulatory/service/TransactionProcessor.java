package com.bank.regulatory.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bank.regulatory.model.Transaction;

public class TransactionProcessor {
 private static final double INITIAL_BALANCE = 10000.0;
    private static final double REGULATORY_MIN_BALANCE = 5000.0;
    private static final LocalDate REGULATORY_EFFECTIVE_DATE = LocalDate.of(2023, 1, 1);

    public List<Transaction> filterPostRegulationTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .dropWhile(tx -> tx.getDate().isBefore(REGULATORY_EFFECTIVE_DATE))
                .collect(Collectors.toList());
    }

    public List<Transaction> processCompliantTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .takeWhile(Transaction::isAmlCompliant)
                .collect(Collectors.toList());
    }

    public double calculateFinalBalance(List<Transaction> validTransactions) {
        return Stream.iterate(INITIAL_BALANCE,
                        balance -> balance >= REGULATORY_MIN_BALANCE,
                        balance -> balance - validTransactions.stream()
                                .mapToDouble(Transaction::getAmount)
                                .reduce(0, (acc, amount) -> acc + amount))
                .reduce((first, second) -> second)
                .orElse(INITIAL_BALANCE);
    }
}
