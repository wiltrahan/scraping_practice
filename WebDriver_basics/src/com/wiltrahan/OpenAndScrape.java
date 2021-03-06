package com.wiltrahan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class OpenAndScrape {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new FirefoxDriver();

        //gets username/password
        Personal personal = new Personal();
        String username = personal.getUsername();
        String password = personal.getPassword();

        System.setProperty("webdriver.gecko.driver", "/Users/twilorip/Desktop/webDrivers/firefox/geckodriver");

        OpenAndScrape openAndScrape = new OpenAndScrape();
        openAndScrape.login(username, password);

        //com.wiltrahan.PrintPortfolio port = new com.wiltrahan.PrintPortfolio();
        //Thread.sleep(4000);

//        com.wiltrahan.Total myTotals = openAndScrape.valuesScrape();
//
//        List<com.wiltrahan.Total> totalPortfolio = new ArrayList<>();

        List<Stock> stockPortfolio = new ArrayList<>();

        Thread.sleep(4000);
        for (int i = 1; i <= 10; i++) {
            Stock stock = openAndScrape.stockScrape(i);
            stockPortfolio.add(stock);
        }

        Total myTotals = openAndScrape.valuesScrape();

        List<Total> totalPortfolio = new ArrayList<>();
        totalPortfolio.add(myTotals);

        //port.myTotals(totalPortfolio);

        //port.printTotals();

        //port.portfolioList(stockPortfolio);

        //port.printPortfolio();

        InsertDbUtil insertDbUtil = new InsertDbUtil();
        insertDbUtil.createDB();
        insertDbUtil.open();

        insertDbUtil.portfolioList(stockPortfolio);

        insertDbUtil.totalsList(totalPortfolio);

        insertDbUtil.dbInsertStocks();

        insertDbUtil.close();
    }

//    private void openSite() {
//        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://finance.yahoo.com/portfolios");
//
//        try {
//            //Thread.sleep(3000);
//            driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/section/div[2]/a")).click();
//
//        } catch (Exception e) {
//            System.out.println("Something went wrong " + e.getMessage());
//        }
//    }

    private void login(String username, String password) {
        driver.get("https://login.yahoo.com/config/login?.done=https%3A%2F%2Ffinance.yahoo.com%2Fportfolios&.intl=us&.lang=en-US&.src=finance");
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
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private Stock stockScrape(int i){
        String symbol = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[1]/span/a")).getText();
        String value = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[2]/span")).getText();
        String dayAmtChg = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[3]/span")).getText();
        String dayPctChg = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[4]/span")).getText();
        String totalShrs = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[8]")).getText();

        return new Stock(symbol, value, dayAmtChg, dayPctChg, totalShrs);
    }

    private Total valuesScrape() {
        String portfolioTotal = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div/div[1]/div/div[2]/p[1]")).getText();
        String dayGain = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div/div[1]/div/div[2]/p[2]/span")).getText();
        String totalGain = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div/div[1]/div/div[2]/p[3]/span")).getText();

        return new Total(portfolioTotal, dayGain, totalGain);
    }
}

