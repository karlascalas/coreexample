package com.bank.reuglatory.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.regulatory.model.Transaction;
import com.bank.regulatory.service.TransactionProcessor;
public class TransactionProcessorTest {

    private TransactionProcessor transactionProcessor;

    @BeforeEach
    public void setup() {
        transactionProcessor = new TransactionProcessor();
    }

    @Test
    public void testFilterPostRegulationTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(2000, LocalDate.of(2022, 12, 25), true),
                new Transaction(3000, LocalDate.of(2023, 1, 2), true),
                new Transaction(4000, LocalDate.of(2023, 1, 3), true)
        );

        List<Transaction> result = transactionProcessor.filterPostRegulationTransactions(transactions);

        assertEquals(2, result.size()); // Should only return transactions from 2023
        assertTrue(result.stream().allMatch(tx -> tx.getDate().isAfter(LocalDate.of(2023, 1, 1))));
    }

    @Test
    public void testProcessCompliantTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(3000, LocalDate.of(2023, 1, 2), true),
                new Transaction(4000, LocalDate.of(2023, 1, 3), true),
                new Transaction(1500, LocalDate.of(2023, 1, 4), false), // AML failing
                new Transaction(1000, LocalDate.of(2023, 1, 5), true)
        );

        List<Transaction> result = transactionProcessor.processCompliantTransactions(transactions);

        assertEquals(2, result.size()); // Only two compliant transactions should be processed
        assertTrue(result.stream().allMatch(Transaction::isAmlCompliant));
    }

    @Test
    public void testCalculateFinalBalance() {
        List<Transaction> validTransactions = Arrays.asList(
                new Transaction(3000, LocalDate.of(2023, 1, 2), true),
                new Transaction(4000, LocalDate.of(2023, 1, 3), true)
        );

        double finalBalance = transactionProcessor.calculateFinalBalance(validTransactions);

        assertEquals(10000.0, finalBalance); // Final balance should be calculated correctly
    }

    @Test
    public void testCalculateFinalBalanceDropsBelowRegulatoryMinimum() {
        List<Transaction> validTransactions = Arrays.asList(
                new Transaction(6000, LocalDate.of(2023, 1, 2), true),
                new Transaction(6000, LocalDate.of(2023, 1, 3), true)  // After first 6000, balance will be below 5000
        );

        double finalBalance = transactionProcessor.calculateFinalBalance(validTransactions);

        assertEquals(10000.0, finalBalance); // Iteration should stop when balance falls below regulatory minimum
    }

}
