package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

public class Control {
    protected By locator;
    protected WebElement control;

    public Control(By locator) {
        this.locator = locator;
    }

    protected void findControl() {
        this.control = Session.getSession().getDriver().findElement(locator);
    }


    public void click() {
        this.findControl();
        this.control.click();
    }

    public void set(String value) {
        this.findControl();
        this.control.clear();
        this.control.sendKeys(value);
    }

    public void dobleClick() {
        this.findControl();
        this.control.click();
        this.control.click();
    }

    public boolean controlIsDisplayed() {
        try {
            this.findControl();
            return this.control.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText() {
        this.findControl();
        return this.control.getText();
    }

    public String getAttributeValue(String attribute) {
        this.findControl();
        return this.control.getAttribute(attribute);
    }

    public void clear() {
        this.findControl();
        this.control.clear();
    }
}
