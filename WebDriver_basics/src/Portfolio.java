import java.util.ArrayList;
import java.util.List;

public class Portfolio {

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
        for(int i = 0; i < this.myStocks.size(); i++) {
            System.out.println(this.myStocks.get(i).getSymbol() + "     | " +
                                this.myStocks.get(i).getValue() + "  | " +
                                this.myStocks.get(i).getDayAmtChange() + "   | " +
                                this.myStocks.get(i).getDayPercentChange() + "  | " +
                                this.myStocks.get(i).getTotalShares());
        }
    }

    public void printTotals() {
        System.out.println("\n");
        System.out.println("*******************");
        System.out.println("\n");

        System.out.println("Totals...");
        System.out.println("Total Value | Day Gain | Total Gain");
        for(int i = 0; i < this.myTotalValue.size(); i++) {
            System.out.println(this.myTotalValue.get(i).getPortfolioTotal() + " |  " +
                                this.myTotalValue.get(i).getPortfolioDayGain() + " |  " +
                                this.myTotalValue.get(i).getPortfolioGainTotal());
        }

    }
}
