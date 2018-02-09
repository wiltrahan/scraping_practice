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

    }

    private void openSite() {
        driver.get("https://finance.yahoo.com/portfolios");
        try {
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/section/div[2]/a")).click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void login(String username, String password) {
        try {
            driver.findElement(By.id("login-username")).sendKeys(username);
            driver.findElement(By.id("login-signin")).click();
            Thread.sleep(3000);
            pass(password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void pass(String password) {
        try {
            driver.findElement(By.id("login-passwd")).sendKeys(password);
            driver.findElement(By.id("login-signin")).click();
            Thread.sleep(2000);
            toPortfolio();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void toPortfolio() throws InterruptedException {
        try {
            driver.navigate().to("https://finance.yahoo.com/portfolio/p_0/view/v1");
            Thread.sleep(3000);
            getText();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void getText() throws IOException {
        List titles = new ArrayList<String>();
        for(int i = 1; i <= 10; i++) {
            //titles.add(driver.findElement(By.xpath("//*[@id=\"main\"]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[1]/span/a")).getText() + "\n");
            titles.add(driver.findElement(By.xpath("//*[@id=\"main\"]/section/section[2]/div[2]/table/tbody/tr[" + i + "]")).getText() + "\n");
        }
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
        writer.write(titles.toString());
        writer.close();
    }

}
//*[@id="main"]/section/section[2]/div[2]/table/tbody/tr[i]
