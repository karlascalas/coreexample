package com.example.finance;

import java.util.concurrent.CompletableFuture;

public class RiskAssessor {

    public static CompletableFuture<RiskAssessmentResult> assessRisk(String tradeId){
        return  CompletableFuture.supplyAsync(() ->
            {
                System.out.println("Assessing risk for trade: "+tradeId);
                return  new RiskAssessmentResult("Low");
            }, TradeProcessing.executor);
    }
    }

