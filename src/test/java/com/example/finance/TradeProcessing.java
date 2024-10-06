package com.example.finance;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TradeProcessing {
    
    public static final ExecutorService executor = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {
       try {
            CompletableFuture<Void> tradeProcessingFuture =  processTradeOrder("Trade123");
            tradeProcessingFuture.join();
       } catch (Exception e) {
        System.err.println("Error processing trfade: "+e.getMessage());
       }finally{
        executor.shutdown();
       }
    }

    public static CompletableFuture<Void> processTradeOrder(String tradeId){
        return  TradeValidator.validateTrade(tradeId).thenCompose(validationResult -> {
            if(validationResult.isValid()){
                return  RiskAssessor.assessRisk(tradeId);
            }else{
                return CompletableFuture.failedFuture(new RuntimeException("Trade validation failed"));
            }}).thenAccept(riskAssessmentResult -> {
            System.out.println("Risk assessment completed with level: "+riskAssessmentResult.getRiskLevel());
            TradeExecutor.executerTrade(tradeId);
        }).exceptionally(
            es -> {
                System.err.println("Error during trade processing: "+es.getMessage());
                return null;
            });
        
    }
    
}

