package com.bank.regulatory.main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.bank.regulatory.model.Transaction;
import com.bank.regulatory.service.TransactionProcessor;

public class InvestmentBankingRegulatoryApplication {

    public void callingMethod(){
        TransactionProcessor processor = new TransactionProcessor();

        // Sample list of transactions
        List<Transaction> transactions = Arrays.asList(
                new Transaction(2000, LocalDate.of(2022, 12, 25), true),
                new Transaction(3000, LocalDate.of(2023, 1, 2), true),
                new Transaction(4000, LocalDate.of(2023, 1, 3), true),
                new Transaction(1500, LocalDate.of(2023, 1, 4), false), // Fails AML compliance
                new Transaction(1000, LocalDate.of(2023, 1, 5), true)
        );

        // Step 1: Skip transactions before the regulatory effective date
        List<Transaction> postRegulationTransactions = processor.filterPostRegulationTransactions(transactions);

        System.out.println("Transactions after the regulatory effective date:");
        postRegulationTransactions.forEach(System.out::println);

        // Step 2: Process transactions until a non-compliant transaction is found (AML failing)
        List<Transaction> validTransactions = processor.processCompliantTransactions(postRegulationTransactions);

        System.out.println("\nCompliant transactions up to AML failure:");
        validTransactions.forEach(System.out::println);

        // Step 3: Calculate final balance after processing valid transactions
        double finalBalance = processor.calculateFinalBalance(validTransactions);

        System.out.println(finalBalance + "\nFinal balance after processing valid transactions: ");
    }

}
