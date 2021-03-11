package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Chrome implements IBrowser {
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver/chromedriver.exe");
        ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
