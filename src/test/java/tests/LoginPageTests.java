package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends BaseTest {
    //Below test case is for testing of user trying to login using "locked_out_user" credentials
    @Test(priority = 1)
    public void invalidUserLoginTest(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("locked_out_user", "secret_sauce");

        String actualErrorMessage = loginPageObj.getLockedOutUserErrorMessage();

        Assert.assertEquals(
                actualErrorMessage,
                "Epic sadface: Sorry, this user has been locked out."
        );
    }

    //Below test case is for testing of user trying to login using genuine credentials
    @Test(priority = 2)
    public void validUserLoginTest(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("standard_user", "secret_sauce");

        String pageLoginUrl = driver.getCurrentUrl();

        Assert.assertEquals(pageLoginUrl, "https://www.saucedemo.com/inventory.html");
    }

    //Below test case is for testing of user trying to login without entering credentials
    @Test(priority = 3)
    public void emptyLoginTest(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("", "");

        String errorMessage = loginPageObj.getLockedOutUserErrorMessage();

        Assert.assertTrue(
                errorMessage.contains("Username is required"),
                "Error message not shown for empty login"
        );
    }

    //Below test case is for testing of user trying to visit the inventory page directly using URL without logging
    //in using valid credentials
    @Test(priority = 4)
    public void verifyDirectAccessWithoutLogin(){
        driver.get("https://www.saucedemo.com/inventory.html");

        Assert.assertTrue(
                driver.findElement(By.id("login-button")).isDisplayed(),
                "User was able to access inventory without login"
        );
    }

}
