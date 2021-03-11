package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStack implements IBrowser {

    private static final String USERNAME = "";
    private static final String AUTOMATE_KEY = "";
    private static final String URL_BROWSERSTACK = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Override
    public WebDriver create() {
        WebDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "88.0");
        caps.setCapability("name", "UPB Test");

        try {
            driver = new RemoteWebDriver(new URL(URL_BROWSERSTACK), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
