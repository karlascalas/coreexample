package com.example.finance;

import java.util.concurrent.CompletableFuture;

public class TradeValidator {

    public static CompletableFuture<TradeValaidationResult> validateTrade(String tradeId){
        return  CompletableFuture.supplyAsync(() -> {
            System.out.println("Validating trade: "+tradeId);
            return new TradeValaidationResult(true);
        },TradeProcessing.executor);
    }

}
