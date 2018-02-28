package com.wiltrahan;

public class Total {

    private String portfolioTotal;
    private String portfolioDayGain;
    private String portfolioGainTotal;


    Total(String portfolioTotal, String portfolioDayGain, String portfolioGainTotal) {
        this.portfolioTotal = portfolioTotal;
        this.portfolioDayGain = portfolioDayGain;
        this.portfolioGainTotal = portfolioGainTotal;
    }

    Total(String portfolioTotal, String portfolioDayGain) {
        this.portfolioTotal = portfolioTotal;
        this.portfolioDayGain = portfolioDayGain;
    }

    public String getPortfolioTotal() {
        return portfolioTotal;
    }

    public String getPortfolioDayGain() {
        return portfolioDayGain;
    }

    public String getPortfolioGainTotal() {
        return portfolioGainTotal;
    }
}
