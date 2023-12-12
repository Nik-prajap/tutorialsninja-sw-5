package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    TopMenuPage homePage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    DesktopsPage desktopsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage=new TopMenuPage();
        laptopsAndNotebooksPage=new LaptopsAndNotebooksPage();
        desktopsPage = new DesktopsPage();
    }

    /**
     * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
     * 1.2 Click on “Show All Laptops & Notebooks”
     * 1.3 Select Sort By "Price (High > Low)"
     * 1.4 Verify the Product price will arrange in High to Low order.
     */
    @Test(groups = "sanity")
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopNotebooks();

        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // Get all the products price and stored into array list
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);


        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortBy("Price (High > Low)");

        // After filter Price (High > Low) Get all the products price and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);


        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(originalProductsPrice, afterSortByPrice);
    }


    /**
     * 2.1 Mouse hover on Laptops & Notebooks Tab and click
     * 2.2 Click on “Show All Laptops & Notebooks”
     * 2.3 Select Sort By "Price (High > Low)"
     * 2.4 Select Product “MacBook”
     * 2.5 Verify the text “MacBook”
     * 2.6 Click on ‘Add To Cart’ button
     * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
     * 2.8 Click on link “shopping cart” display into success message
     * 2.9 Verify the text "Shopping Cart"
     * 2.10 Verify the Product name "MacBook"
     * 2.11 Change Quantity "2"
     * 2.12 Click on “Update” Tab
     * 2.13 Verify the message “Success: You have modified your shopping cart!”
     * 2.14 Verify the Total £737.45
     * 2.15 Click on “Checkout” button
     * 2.16 Verify the text “Checkout”
     * 2.17 Verify the Text “New Customer”
     * 2.18 Click on “Guest Checkout” radio button
     * 2.19 Click on “Continue” tab
     * 2.20 Fill the mandatory fields
     * 2.21 Click on “Continue” Button
     * 2.22 Add Comments About your order into text area
     * 2.23 Check the Terms & Conditions check box
     * 2.24 Click on “Continue” button
     * 2.25 Verify the message “Warning: Payment method required!”
     */
    @Test(groups = "regression")
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        // Select currency as £ Pound Sterling
        desktopsPage.clickOnCurrency();
        desktopsPage.selectPoundSterling();

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopNotebooks();

        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortBy("Price (High > Low)");

        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectProductMacBook();

        //2.5 Verify the text “MacBook”
        String actualMacBookText = laptopsAndNotebooksPage.verifyMacBookText();
        Assert.assertEquals(actualMacBookText,"MacBook", "Product not match");

        //2.6 Click on ‘Add To Cart’ button
        laptopsAndNotebooksPage.clickOnAddToCart();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualAddToCartText = laptopsAndNotebooksPage.addCartMessage();
        Assert.assertEquals(actualAddToCartText,"Success: You have added MacBook to your shopping cart!\n" +
                "×", "Message is not match");

        //2.8 Click on link “shopping cart” display into success message
        laptopsAndNotebooksPage.clickOnShoppingCart();

        //2.9 Verify the text "Shopping Cart"
        String actualShoppingCartText = laptopsAndNotebooksPage.verifyTheShoppingCartText();
        Assert.assertEquals(actualShoppingCartText,"Shopping Cart  (0.00kg)","Text is not match");

        //2.10 Verify the Product name "MacBook"
        String actualMacBookText1 = laptopsAndNotebooksPage.verifyMacBookText1();
        Assert.assertEquals(actualMacBookText1,"MacBook","Text not match");

        //2.11 Change Quantity "2"
        laptopsAndNotebooksPage.changeTheQty();

        //2.12 Click on “Update” Tab
        laptopsAndNotebooksPage.updateTheQty();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualModifyCartText = laptopsAndNotebooksPage.verifyTheModifyCartText();
        Assert.assertEquals(actualModifyCartText,"Success: You have modified your shopping cart!\n" +
                "×","Text is not match");

        //2.14 Verify the Total £737.45
        String actualTotalAmount = laptopsAndNotebooksPage.verifyTheTotalAmount();
        Assert.assertEquals(actualTotalAmount,"£737.45","Total amount is not match");

        //2.15 Click on “Checkout” button
        laptopsAndNotebooksPage.clickOnCheckOutButton();

        //2.16 Verify the text “Checkout”
        String actualCheckoutText = laptopsAndNotebooksPage.verifyCheckOutText();
        Assert.assertEquals(actualCheckoutText,"Checkout","Text is not match");

        //2.17 Verify the Text “New Customer”
        String actualNewCustomerText = laptopsAndNotebooksPage.verifyNewCustomerText();
        Thread.sleep(2000);
        Assert.assertEquals(actualNewCustomerText,"New Customer","Text is not match");

        //2.18 Click on “Guest Checkout” radio button
        laptopsAndNotebooksPage.clickOnGuestCheckOut();

        //2.19 Click on “Continue” tab
        laptopsAndNotebooksPage.clickOnContinueButton();

        //2.20 Fill the mandatory fields
        laptopsAndNotebooksPage.enterFirstName("Prime");
        laptopsAndNotebooksPage.enterLastName("Testing");
        laptopsAndNotebooksPage.enterEmail("Prime013579Testing@gmail.com");
        laptopsAndNotebooksPage.enterPhoneNumber("07999999999");
        laptopsAndNotebooksPage.enterAddress1("1, Buckingham Palace");
        laptopsAndNotebooksPage.enterCity("Westminster");
        laptopsAndNotebooksPage.enterPostCode("SW1A 1AA");
        laptopsAndNotebooksPage.selectCountry("United Kingdom");
        laptopsAndNotebooksPage.selectRegion("Greater London");

        //2.21 Click on “Continue” Button
        laptopsAndNotebooksPage.clickOnLastContinueCheckOutButton();

        //2.22 Add Comments About your order into text area
        laptopsAndNotebooksPage.enterComments("Thank You");

        //2.23 Check the Terms & Conditions check box
        laptopsAndNotebooksPage.clickOnAgree();

        //2.24 Click on “Continue” button
        laptopsAndNotebooksPage.clickOnGuestContinue();
        //2.25 Verify the message “Warning: Payment method required!”
        String actualWarningMessage = laptopsAndNotebooksPage.verifyPaymentWarningText();
        Assert.assertEquals(actualWarningMessage,"Warning: No Payment options are available. Please contact us for assistance!","Warning text is not match");

    }
}
