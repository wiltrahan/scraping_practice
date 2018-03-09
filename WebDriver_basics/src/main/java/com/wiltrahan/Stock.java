package com.wiltrahan;

public class Stock {

    private String symbol;
    private String value;
    private String dayAmtChg;
    private String dayPctChg;
    private String totalShrs;

    Stock(String symbol, String value, String dayAmtChange, String dayPercentChange, String totalShares) {
        this.symbol = symbol;
        this.value = value;
        this.dayAmtChg = dayAmtChange;
        this.dayPctChg = dayPercentChange;
        this.totalShrs = totalShares;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public String getDayAmtChg() {
        return dayAmtChg;
    }

    public String getDayPctChg() {
        return dayPctChg;
    }

    public String getTotalShrs() {
        return totalShrs;
    }
}
