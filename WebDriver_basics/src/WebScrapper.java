//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.io.File;
//import java.io.IOException;
//
//public class WebScrapper {
//
//    public WebDriver driver = new FirefoxDriver();
//
//    /**
//     * Open the test website.
//     */
//    public void openTestSite() {
//        driver.navigate().to("https://www.yahoo.com/");
//    }
//
//    /*
//     *
//     * @param username
//     * @param Password
//     *
//     *            Logins into the website, by entering provided username and
//     *            password
//     */
////    public void login(String username, String Password) {
////
////        WebElement userName_editbox = driver.findElement(By.id("usr"));
////        WebElement password_editbox = driver.findElement(By.id("pwd"));
////        WebElement submit_button = driver.findElement(By.xpath("//input[@value='Login']"));
////
////        userName_editbox.sendKeys(username);
////        password_editbox.sendKeys(Password);
////        submit_button.click();
////
////    }
//
//    public void login(String username) {
//        WebElement signInButton = driver.findElement(By.xpath("//a[@id='uh-signin']"));
//        signInButton.click();
//
//    }
//
//
//
//    /**
//     * grabs the status text and saves that into status.txt file
//     *
//     * @throws IOException
//     */
//    public void tableScrape() throws IOException {
////        List titles = new ArrayList<String>();
//////        String text = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/article[1]/div/h2/a")).tableScrape();
////        //String text;
////        for(int i = 1; i <= 8; i++) {
////            titles.add(driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/article[" + i + "]")).tableScrape() + "\n");
////        }
////        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
////        writer.write(titles.toString());
////        writer.close();
//
//    }
//
//    /**
//     * Saves the screenshot
//     *
//     * @throws IOException
//     */
//    public void saveScreenshot() throws IOException {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("screenshot.png"));
//    }
//
//    public void closeBrowser() {
//        driver.close();
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setProperty("webdriver.gecko.driver", "/Users/twilorip/Desktop/webDrivers/firefox/geckodriver");
//
//        WebScrapper webSrcapper = new WebScrapper();
//        webSrcapper.openTestSite();
//        //webSrcapper.login("admin", "12345");
//
//        webSrcapper.tableScrape();
//        webSrcapper.saveScreenshot();
//        //webSrcapper.closeBrowser();
//    }
//}

//*[@id="content"]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/article[1]/div/h2/a

//*[@id="content"]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/article[8]/div/h2/a

//*[@id="content"]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/article[i]/div/h2/a

//*[@id="case_table"]/table/tbody/tr[2]/td[1]

//*[@id="content"]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/article[1]/div/h2/a
//*[@id="content"]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/article[1]/div/h2/a
//*[@id="content"]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/article[i]/div/h2/a