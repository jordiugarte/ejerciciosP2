package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FireFox implements IBrowser {
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.geckodriver.driver", "src/test/resources/firefoxDriver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
