import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private ArrayList<Stock> myStocks;

    public void portfolioList(List<Stock>stock) {
        myStocks = new ArrayList<>(stock);
        //myStocks.add(stock);
    }

    public void printPortfolio() {
        System.out.println("Dreaming...");
        for(int i = 0; i < this.myStocks.size(); i++) {
            System.out.println(this.myStocks.get(i).getSymbol());
        }
    }
}
