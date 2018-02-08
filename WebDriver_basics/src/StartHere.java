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
//        startHere.login(username, password);

    }

    private void openSite() {
        driver.get("https://finance.yahoo.com/portfolios");

        try {
            driver.findElement(By.cssSelector("._299Wd")).click();
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
        driver.findElement(By.xpath("//a[@class='_299Wd']")).click();

    }

//    private void goToPortfolio() {
//        //locate the menu to hover over using its xpath
//
//        WebElement menu = driver.findElement(By.xpath("//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/div[1]/ul/li[2]/a/text()")).click();
//
//        //Initiate mouse action using Actions class
//        Actions builder = new Actions(driver);
//
//        // move the mouse to the earlier identified menu option
//        builder.moveToElement(menu).build().perform();
//
//        // wait for max of 5 seconds before proceeding. This allows sub menu appears properly before trying to click on it
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='subNav_music_menu']/tbody/tr[2]/td[1]/a[1]")));  // until this submenu is found
//    }
}
//*[@id="Nav-0-DesktopNav"]/div/div[3]/div/div[1]/ul/li[2]/a/text()
