package com.wiltrahan;

import java.util.ArrayList;
import java.util.List;

public class PrintPortfolio {

    private ArrayList<Stock> myStocks;
    private ArrayList<Total> myTotalValue;

    public void portfolioList(List<Stock>stock) {
        myStocks = new ArrayList<>(stock);
    }
    public void myTotals(List<Total>total) {
        myTotalValue = new ArrayList<>(total);
    }

    public void printPortfolio() {
        System.out.println("Dreaming...");
        System.out.println("SYMBOL | CURRENT | $DAYCHG | %DAYCHG | SHARES");
        for (Stock myStock : this.myStocks) {
            System.out.println(myStock.getSymbol() + "     | " +
                    myStock.getValue() + "  | " +
                    myStock.getDayAmtChg() + "   | " +
                    myStock.getDayPctChg() + "  | " +
                    myStock.getTotalShrs());
        }
    }

    public void printTotals() {
        System.out.println("\n");
        System.out.println("*******************");
        System.out.println("\n");

        System.out.println("Totals...");
        System.out.println("com.wiltrahan.Total Value | Day Gain | com.wiltrahan.Total Gain");
        for (Total aMyTotalValue : this.myTotalValue) {
            System.out.println(aMyTotalValue.getPortfolioTotal() + " |  " +
                    aMyTotalValue.getPortfolioDayGain() + " |  " +
                    aMyTotalValue.getPortfolioGainTotal());
        }

    }
}
