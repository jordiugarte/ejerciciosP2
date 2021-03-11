package ej2;

import org.junit.Assert;
import todoist.*;
import singletonSession.Session;

public class TestTodoist {

    MainPage mainPage = new MainPage();

    String user = "jordi12345@gmail.com";
    String name = "jordi";
    String pwd = "123456789abc";

    @org.junit.Test
    public void verify_login_todoist() throws InterruptedException {
        Session.getSession().getDriver().get("https://todoist.com/");
        mainPage.signupButton.click();
        mainPage.emailTextBox.set(user);
        mainPage.signupWithEmailButton.click();
        mainPage.nameTextBox.set(name);
        mainPage.pwdTextBox.set(pwd);
        mainPage.finalSignupWithEmailButton.click();

        Thread.sleep(2000);
        Assert.assertEquals("ERROR !!Cuenta no creada", user, name);
    }
}
