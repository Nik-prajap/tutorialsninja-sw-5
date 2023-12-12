package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.MyAccountsPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountTest extends BaseTest {

    MyAccountsPage myAccounts;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        myAccounts = new MyAccountsPage();
    }


    /**
     * 1.1 Click on My Account Link.
     * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
     * 1.3 Verify the text “Register Account”.
     */
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”

        String option = "Register";
        myAccounts.selectMyAccountOptions(option);

        //1.3 Verify the text “Register Account”
        String expectedText1 = "Register Account";
        String actualText1 = myAccounts.getRegisterAccountText();
        Assert.assertEquals(actualText1, expectedText1);
    }


    /**
     * 2.1 Click on My Account Link.
     * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
     * 2.3 Verify the text “Returning Customer”.
     */
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // 2.1 Click on My Account Link.
        // 2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        String option = "Login";
        myAccounts.selectMyAccountOptions(option);

        // 2.3 Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = myAccounts.getReturningCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }


    /**
     * 3.1 Click on My Account Link.
     * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
     * 3.3 Enter First Name
     * 3.4 Enter Last Name
     * 3.5 Enter Email
     * 3.6 Enter Telephone
     * 3.7 Enter Password
     * 3.8 Enter Password Confirm
     * 3.9 Select Subscribe Yes radio button
     * 3.10 Click on Privacy Policy check box
     * 3.11 Click on Continue button
     * 3.12 Verify the message “Your Account Has Been Created!”
     * 3.13 Click on Continue button
     * 3.14 Click on My Account Link.
     * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
     * 3.16 Verify the text “Account Logout”
     * 3.17 Click on Continue button
     */
    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        String option = "Register";

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccounts.selectMyAccountOptions(option);

        //3.3 Enter First Name
        myAccounts.enterFirstName("Prime");
        //3.4 Enter Last Name
        myAccounts.enterLastName("Testing");
        //3.5 Enter Email
        myAccounts.enterEmail("Prime1Testing@gmail.com");
        //3.6 Enter Telephone
        myAccounts.enterPhoneNumber("07999999999");
        //3.8 Enter Password Confirm
        myAccounts.enterPassword("T123Prime");
        //3.7 Enter Password
        myAccounts.enterConfirmPassword("T123Prime");
        //3.9 Select Subscribe Yes radio button
        myAccounts.selectSubscribeButton("Yes");

        //3.10 Click on Privacy Policy check box
        myAccounts.clickOnAgree();

        //3.11 Click on Continue button
        myAccounts.clickOnContinue();

        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedText2 = "Your Account Has Been Created!";
        String actualText2 = myAccounts.getAccountCreatedText();
        Assert.assertEquals(actualText2, expectedText2);

        //3.13 Click on Continue button
        myAccounts.clickOnContinue2();

        //3.14 Click on My Account Link.3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        option = "Logout";
        myAccounts.selectMyAccountOptions(option);

        //3.16 Verify the text “Account Logout”
        String expectedText3 = "Account Logout";
        String actualText3 = myAccounts.getAccountLogoutText();
        Assert.assertEquals(actualText3, expectedText3);

    }

    /**
     * 4.1 Click on My Account Link.
     * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
     * 4.3 Enter Email address
     * 4.4 Enter Last Name
     * 4.5 Enter Password
     * 4.6 Click on Login button
     * 4.7 Verify text “My Account”
     * 4.8 Click on My Account Link.
     * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
     * 4.10 Verify the text “Account Logout”
     * 4.11 Click on Continue button
     */
    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogOutSuccessfully() {

        String option = "Login";
        myAccounts.selectMyAccountOptions(option);

        //4.3 Enter Email address
        myAccounts.enterEmailId("Prime1Testing@gmail.com");

        // 4.5 Enter password
        myAccounts.enterPassword("T123Prime");

        //4.6 Click on Login button
        myAccounts.clickOnLogin();

        //4.7 Verify text “My Account”
        String expectedText = "My Account";
        String actualText = myAccounts.getMyAccountText();
        Assert.assertEquals(actualText, expectedText);

        //4.8 Click on My Account Link. 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout
        option = "Logout";
        myAccounts.selectMyAccountOptions(option);

        // 4.10 Verify the text “Account Logout
        String expectedText1 = "Account Logout";
        String actualText1 = myAccounts.getAccountLogoutText();
        Assert.assertEquals(actualText1, expectedText1);

        //4.11 Click on Continue button
        myAccounts.clickOnContinue();
    }
}
