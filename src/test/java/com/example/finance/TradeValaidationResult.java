package com.example.finance;

public class TradeValaidationResult {

    private final boolean valid;

    public TradeValaidationResult(boolean valid){
        this.valid =  valid;
    }

    public boolean isValid(){
        return valid;
    }
}
