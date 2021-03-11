package singletonSession;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {

    private static Session session = null;
    private WebDriver driver;

    private Session() {
        this.driver = FactoryBrowser.make("chrome").create();
    }

    public static Session getSession() {
        if (session == null)
            session = new Session();
        return session;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeSession() {
        driver.quit();
        session = null;
    }
}
