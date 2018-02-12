import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StartHere {

    public WebDriver driver = new FirefoxDriver();

    public static void main(String[] args) {
        Personal personal = new Personal();
        String username = personal.getUsername();
        String password = personal.getPassword();

        System.setProperty("webdriver.gecko.driver", "/Users/twilorip/Desktop/webDrivers/firefox/geckodriver");
        StartHere startHere = new StartHere();
        startHere.openSite();
        startHere.login(username, password);

//        Stock stock = new Stock("GE", "$14.94", "+0.49", "+3.39%", 500);
//        Stock stock2 = new Stock("TSLA", "$310.42", "-4.81", "-1.53%", 600);
//        List<Stock> toPortfolio = new ArrayList<>();

        Portfolio port = new Portfolio();
//        toPortfolio.add(stock);
//        toPortfolio.add(stock2);
//
//        port.portfolioList(toPortfolio);

        //port.printPortfolio();

//        StartHere total = new StartHere();
//        List<Total> toTotal = new ArrayList<>();
//
//        Total myTotals = total.valuesScrape();
//        toTotal.add(myTotals);
//        port.printTotals();
        Total myTotals = startHere.valuesScrape();
        List<Total> toTotal = new ArrayList<>();
        toTotal.add(myTotals);
        port.myTotals(toTotal);
        port.printTotals();
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
            toPortfolio();
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private void toPortfolio() throws InterruptedException {
        try {
            driver.navigate().to("https://finance.yahoo.com/portfolio/p_0/view/v1");
            Thread.sleep(3000);
            //tableScrape();
            //symbolScrape();
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

    public void symbolScrape() throws IOException {
        List<String> symbols = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            symbols.add(driver.findElement(By.xpath("//tr[@data-index='" + i + "']//td[@class='_1_2Qy']")).getText() + "\n");
        }
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("symbols.txt"), "utf-8"));
        writer.write(symbols.toString());
        writer.close();
        //valuesScrape();

    }

    public Total valuesScrape() {
        String portfolioTotal = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div[1]/div[2]/p[1]")).getText();
        String dayGain = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div[1]/div[2]/p[2]/span")).getText();
        String totalGain = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div[1]/div[2]/p[3]/span")).getText();

        return new Total(portfolioTotal, dayGain, totalGain);
//
        //Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("values.txt"), "utf-8"));
        //writer.write(totalValue + "\n" + totalGain + "\n" + dayGain);
        //writer.close();
    }
}

