public class Stock {

//    public static void main(String[] args) {
//        Stock stock = new Stock("GE", "$14.94", "+0.49", "+3.39%", 500);
//        Stock stock2 = new Stock("TSLA", "$310.42", "-4.81", "-1.53%", 600);
//        List<Stock> toPortfolio = new ArrayList<>();
//
//        Portfolio port = new Portfolio();
//        toPortfolio.add(stock);
//        toPortfolio.add(stock2);
//
//        port.portfolioList(toPortfolio);
//
//        port.printPortfolio();
//
//        OpenAndScrape total = new OpenAndScrape();
//        List<Total> toTotal = new ArrayList<>();
//
//        Total myTotals = total.valuesScrape();
//        toTotal.add(myTotals);
//        port.printTotals();
//
//    }

    private String symbol;
    private String value;
    private String dayAmtChg;
    private String dayPctChg;
    private String totalShrs;

    public Stock(String symbol, String value, String dayAmtChange, String dayPercentChange, String totalShares) {
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
