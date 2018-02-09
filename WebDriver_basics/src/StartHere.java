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

    private void toPortfolio() {
        driver.navigate().to("https://finance.yahoo.com/portfolio/p_0/view/v1");
    }

}

