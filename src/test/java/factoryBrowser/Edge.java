package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Edge implements IBrowser {
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/edgeDriver/msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
