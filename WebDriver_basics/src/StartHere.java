import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.get("https://www.yahoo.com/");

        try {
            driver.findElement(By.id("uh-signin")).click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void login(String username, String password) {
        try {
            driver.findElement(By.id("login-username")).sendKeys(username);
            driver.findElement(By.id("login-signin")).click();
            pass(password);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void pass(String password) {
        try {
            driver.findElement(By.id("login-passwd")).sendKeys(password);
            driver.findElement(By.id("login-signin")).click();
        } catch (Exception e) {
            System.out.println(e);
        }
        openFinance();
    }

    private void openFinance() {
        driver.navigate().to("https://finance.yahoo.com/");
    }
}
