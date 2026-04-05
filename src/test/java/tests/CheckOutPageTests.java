package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckOutPageTests extends BaseTest {
    //Below test case helps in testing the complete checkout process
    @Test(priority = 1)
    public void completeCheckoutTest(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("standard_user", "secret_sauce");

        InventoryPage ip = new InventoryPage(driver);
        ip.addItemsToCart();
        ip.goToCart();

        CartPage cp = new CartPage(driver);
        cp.clickCheckout();

        CheckOutPage checkOutPageObj = new CheckOutPage(driver);
        checkOutPageObj.fillCheckoutInfo();
        checkOutPageObj.finishCheckout();

        Assert.assertEquals(
                checkOutPageObj.getSuccessMessage(),
                "Thank you for your order!"
        );
    }

    //Below test case helps in testing whether the error message is displayed or not when the boxes in
    // user details filling form in checkout page is left empty
    @Test(priority = 2)
    public void checkoutWithEmptyFieldsTest(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("standard_user", "secret_sauce");

        InventoryPage ip = new InventoryPage(driver);
        ip.addItemsToCart();
        ip.goToCart();

        CartPage cp = new CartPage(driver);
        cp.clickCheckout();

        CheckOutPage checkOutPageObj = new CheckOutPage(driver);
        driver.findElement(By.id("continue")).click();

        Assert.assertTrue(
                checkOutPageObj.getErrorMessage().contains("Error"),
                "Error message not shown for empty checkout"
        );
    }
}
