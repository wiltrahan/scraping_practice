import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OpenAndScrape {

    private WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) {
        Personal personal = new Personal();
        String username = personal.getUsername();
        String password = personal.getPassword();

        System.setProperty("webdriver.gecko.driver", "/Users/twilorip/Desktop/webDrivers/firefox/geckodriver");

        OpenAndScrape openAndScrape = new OpenAndScrape();
        openAndScrape.openSite();
        openAndScrape.login(username, password);

        Portfolio port = new Portfolio();

        Total myTotals = openAndScrape.valuesScrape();

        List<Total> totalPortfolio = new ArrayList<>();

        totalPortfolio.add(myTotals);
        port.myTotals(totalPortfolio);
        port.printTotals();

//        Stock stock = new Stock("GE", "$14.94", "+0.49", "+3.39%", 500);
//        Stock stock2 = new Stock("TSLA", "$310.42", "-4.81", "-1.53%", 600);
//        List<Stock> toYahooPortfolio = new ArrayList<>()
        Stock stock = openAndScrape.stockScrape();

        List<Stock> stockPortfolio = new ArrayList<>();

        stockPortfolio.add(stock);
        port.portfolioList(stockPortfolio);
        port.printPortfolio();



//        toYahooPortfolio.add(stock);
//        toYahooPortfolio.add(stock2);
//
//        port.portfolioList(toYahooPortfolio);

        //port.printPortfolio();

//        OpenAndScrape total = new OpenAndScrape();
//        List<Total> toTotal = new ArrayList<>();
//
//        Total myTotals = total.valuesScrape();
//        toTotal.add(myTotals);
//        port.printTotals();

    }

    private void openSite() {
        driver.get("https://finance.yahoo.com/portfolios");
        try {
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/section/div[2]/a")).click();
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private void login(String username, String password) {
        try {
            driver.findElement(By.id("login-username")).sendKeys(username);
            driver.findElement(By.id("login-signin")).click();
            Thread.sleep(3000);
            pass(password);
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private void pass(String password) {
        try {
            driver.findElement(By.id("login-passwd")).sendKeys(password);
            driver.findElement(By.id("login-signin")).click();
            Thread.sleep(2000);
            toYahooPortfolio();
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private void toYahooPortfolio() {
        try {
            driver.navigate().to("https://finance.yahoo.com/portfolio/p_0/view/v1");
            Thread.sleep(3000);
            //tableScrape();
            stockScrape();
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

//    public void tableScrape() throws IOException {
//        List<String> titles = new ArrayList<>();
//        for(int i = 1; i <= 10; i++) {
//            titles.add(driver.findElement(By.xpath("//*[@id=\"main\"]/section/section[2]/div[2]/table/tbody/tr[" + i + "]")).getText() + "\n");
//        }
//        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
//        writer.write(titles.toString());
//        writer.close();
//        valuesScrape();
//    }

    private Stock stockScrape(){

        for(int i = 0; i < 10; i++) {
            //stocks.add(driver.findElement(By.xpath("//tr[@data-index='" + i + "']//td[@class='_1_2Qy']")).getText() + "\n");
        }
        return new Stock();
//        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("symbols.txt"), "utf-8"));
//        writer.write(stocks.toString());
//        writer.close();
        //valuesScrape();

    }

    private Total valuesScrape() {
        String portfolioTotal = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div[1]/div[2]/p[1]")).getText();
        String dayGain = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div[1]/div[2]/p[2]/span")).getText();
        String totalGain = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div[1]/div[2]/p[3]/span")).getText();

        return new Total(portfolioTotal, dayGain, totalGain);
    }
}

