package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    private WebDriver driver;

    //    Below variable contains the web element locating first name field in the checkout page
    private By firstName = By.id("first-name");

    //    Below variable contains the web element locating last name field in the checkout page
    private By lastName = By.id("last-name");

    //    Below variable contains the web element locating zip code in the checkout page
    private By zipCode = By.id("postal-code");

    //    Below variable contains the web element locating continue button in the checkout page
    private By continueBtn = By.id("continue");

    //    Below variable contains the web element locating finish button in the checkout page
    private By finishBtn = By.id("finish");

    //    Below variable contains the web element locating success message displayed after successful checkout in
    //    the checkout page
    private By successMsg = By.className("complete-header");

    //    Below variable contains the web element locating error message displayed after fields are left empty
    //    in the personal details filling form in checkout page
    private By errorMsg = By.tagName("h3");


    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    //Below method is created for filling the checkout information in checkout page
    public void fillCheckoutInfo(){
        driver.findElement(firstName).sendKeys("Utsav");
        driver.findElement(lastName).sendKeys("Kharel");
        driver.findElement(zipCode).sendKeys("44600");
        driver.findElement(continueBtn).click();
    }

    //Below method is created for clicking on the finish button in checkout page
    public void finishCheckout(){
        driver.findElement(finishBtn).click();
    }

    //Below method is created for storing the success message displayed in checkout page
    public String getSuccessMessage(){
        return driver.findElement(successMsg).getText();
    }

    //Below method is created for storing the error message displayed in checkout page while filling the personal
    //details filling form
    public String getErrorMessage(){
        return driver.findElement(errorMsg).getText();
    }
}
