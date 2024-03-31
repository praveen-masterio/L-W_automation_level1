package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import testbase.BaseClass;

public class ScenariosTest extends BaseClass {

    private WebDriver driver;

    @Test(priority = 2,invocationTimeOut = 200)
    public void addMonitorToCartAndVerifySubTotal() {

        HomePage homePage = new HomePage(driver);

        homePage.navigateToHomePage();

        homePage.searchForProduct("Monitor");

        ProductPage productPage = homePage.clickOnFirstProductResult();
        productPage.addProductToCart();

        CartPage cartPage = productPage.goToCartPage();

        double productPrice = productPage.getProductPrice();
        String cartSubTotal = cartPage.getSubTotal();

        Assert.assertEquals(productPrice, cartSubTotal, "Product price and cart sub total do not match");
    }

    @Test(priority = 1,successPercentage = 100)
    public void addLaptopToCartAndVerifySubTotal() {

        HomePage homePage = new HomePage(driver);

        homePage.navigateToHomePage();

        homePage.searchForProduct("Laptop");

        ProductPage productPage = homePage.clickOnFirstProductResult();
        productPage.addProductToCart();

        CartPage cartPage = productPage.goToCartPage();

        double productPrice = productPage.getProductPrice();
        String cartSubTotal = cartPage.getSubTotal();

        Assert.assertEquals(productPrice, cartSubTotal, "Product price and cart sub total do not match");
    }

    @Test(priority = 0 )
    public void addTwoItemsToCartAndVerifySubTotal() {

        HomePage homePage = new HomePage(driver);

        homePage.navigateToHomePage();

        homePage.searchForProduct("Headphones");

        ProductPage headphonesPage = homePage.clickOnFirstProductResult();
        headphonesPage.addProductToCart();

        homePage.searchForProduct("Keyboard");

        ProductPage keyboardPage = homePage.clickOnFirstProductResult();
        keyboardPage.addProductToCart();

        CartPage cartPage = keyboardPage.goToCartPage();

        double headphonesPrice = headphonesPage.getProductPrice();
        double keyboardPrice = keyboardPage.getProductPrice();
        String cartSubTotal = cartPage.getSubTotal();

        Assert.assertEquals(headphonesPrice + keyboardPrice, cartSubTotal, "Product prices and cart sub total do not match");
    }

}