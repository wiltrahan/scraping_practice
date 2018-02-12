import java.util.ArrayList;
import java.util.List;

public class Stock {

    public static void main(String[] args) {
        Stock stock = new Stock("GE", "$14.94", "+0.49", "+3.39%", 500);
        Stock stock2 = new Stock("TSLA", "$310.42", "-4.81", "-1.53%", 600);
        List<Stock> toPortfolio = new ArrayList<>();

        Portfolio port = new Portfolio();
        toPortfolio.add(stock);
        toPortfolio.add(stock2);

        port.portfolioList(toPortfolio);

        port.printPortfolio();

    }

    private String symbol;
    private String value;
    private String dayAmtChange;
    private String dayPercentChange;
    private int totalShares;

    private Stock(String symbol, String value, String dayAmtChange, String dayPercentChange, int totalShares) {
        this.symbol = symbol;
        this.value = value;
        this.dayAmtChange = dayAmtChange;
        this.dayPercentChange = dayPercentChange;
        this.totalShares = totalShares;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public String getDayAmtChange() {
        return dayAmtChange;
    }

    public String getDayPercentChange() {
        return dayPercentChange;
    }

    public int getTotalShares() {
        return totalShares;
    }
}
