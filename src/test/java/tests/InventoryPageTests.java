package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryPageTests extends BaseTest {
    //Below test case is for testing of product name appearing in descending order
    @Test(priority = 1)
    public void verifyFilterByNameDescending(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("standard_user", "secret_sauce");

        InventoryPage inventoryPageObj = new InventoryPage(driver);
        inventoryPageObj.sortByNameDesc();

        Assert.assertTrue(
                inventoryPageObj.isProductNameSortedDesc(),
                "Products are NOT sorted by Name (Z to A)"
        );
    }

    //Below test case is for testing of product price appearing in low to high order
    @Test(priority = 2)
    public void verifyFilterByPriceLowToHigh(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("standard_user", "secret_sauce");

        InventoryPage inventoryPageObj = new InventoryPage(driver);
        inventoryPageObj.sortByPriceLowToHigh();

        Assert.assertTrue(
                inventoryPageObj.isProductPriceSortedLowToHigh(),
                "Products are NOT sorted by Price (Low to High)"
        );
    }

    //Below test case is for testing of items being added to cart and navigating to the cart page
    @Test(priority = 3)
    public void verifyAddItemsAndNavigateToCart(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("standard_user", "secret_sauce");

        InventoryPage inventoryPageObj = new InventoryPage(driver);

        inventoryPageObj.addItemsToCart();
        inventoryPageObj.goToCart();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart"),
                "User was NOT navigated to cart page"
        );
    }

//    Below test case is for testing whether the counter of the cart icon is working properly or not when any
    //product is added to the cart
    @Test(priority = 4)
    public void verifyCartBadgeCount(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("standard_user", "secret_sauce");

        InventoryPage inventoryPageObj = new InventoryPage(driver);
        inventoryPageObj.addItemsToCart();

        Assert.assertEquals(
                inventoryPageObj.getCartCount(),
                "2",
                "Cart badge count is incorrect"
        );
    }


// Below test case is created for validating whether the item from the cart is removed or not after clicking the
    //"Remove" button
    @Test(priority = 5)
    public void verifyRemoveItemFromCart(){
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.loginToSystem("standard_user", "secret_sauce");

        InventoryPage inventoryPageObj = new InventoryPage(driver);
        inventoryPageObj.addItemsToCart();
        inventoryPageObj.removeItem();

        Assert.assertEquals(
                inventoryPageObj.getCartCount(),
                "1",
                "Item was not removed properly"
        );
    }
}
