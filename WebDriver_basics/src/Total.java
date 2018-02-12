
public class Total {

    private String portfolioTotal;
    private String portfolioDayGain;
    private String portfolioGainTotal;


    public Total(String portfolioTotal, String portfolioDayGain, String portfolioGainTotal) {
        this.portfolioTotal = portfolioTotal;
        this.portfolioDayGain = portfolioDayGain;
        this.portfolioGainTotal = portfolioGainTotal;
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
