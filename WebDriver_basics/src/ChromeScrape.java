import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeScrape {

    public WebDriver driver = new ChromeDriver();


    public void openTestSite() {
        driver.navigate().to("http://djtechtools.com/");
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/twilorip/Desktop/webDrivers/chrome/geckodriver");

        WebScrapper webScrapper = new WebScrapper();
        webScrapper.openTestSite();
    }
}
