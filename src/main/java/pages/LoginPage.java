package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //    Below variable contains the web element locating username field in the login page
    private By userNameField = By.id("user-name");

    //    Below variable contains the web element locating password field in the login page
    private  By passwordField = By.id("password");

    //    Below variable contains the web element locating login button in the login page
    private  By loginButton = By.id("login-button");

    //    Below variable contains the web element locating error message displayed in the login page
    private  By lockedOutUserErrorMessage = By.tagName("h3");



    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Below method helps to store the error message displayed in the login page
    public String getLockedOutUserErrorMessage(){
        return driver.findElement(lockedOutUserErrorMessage).getText();
    }

    //Below method helps to fill the field required for the login and click on the login button in the login page
    public void loginToSystem(String userNameValue, String passwordValue){
        driver.findElement(userNameField).sendKeys(userNameValue);
        driver.findElement(passwordField).sendKeys(passwordValue);
        driver.findElement(loginButton).click();
    }
}
