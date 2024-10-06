package com.example.finance;

public class RiskAssessmentResult {

    private final String riskLevel;

    public RiskAssessmentResult(String riskLevel){
        this.riskLevel = riskLevel;
    }

    public String getRiskLevel(){
        return riskLevel;
    }

}
