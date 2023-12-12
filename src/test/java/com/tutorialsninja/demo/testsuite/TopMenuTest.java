package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.TopMenuPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    TopMenuPage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new TopMenuPage();
    }


    /**
     * 1.1 Mouse hover on “Desktops” Tab and click
     * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
     * 1.3 Verify the text ‘Desktops’
     */
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverOnDesktops();

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //1.3 Verify the text ‘Desktops’
        String actualDesktopsText = homePage.verifyDesktopsText();
        Assert.assertEquals(actualDesktopsText,"Desktops","text not match");

    }


    /**
     * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
     * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
     * 2.3 Verify the text ‘Laptops & Notebooks’
     */
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnLaptopNotebooks();

        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // 2.3 Verify the text ‘Laptops & Notebooks’
        String actualLaptopNotebooksText = homePage.verifyLaptopNotebooksText();
        Assert.assertEquals(actualLaptopNotebooksText,"Laptops & Notebooks","Text not match");

    }




    /**
     * 3.1 Mouse hover on “Components” Tab and click
     * 3.2 call selectMenu method and pass the menu = “Show All Components”
     * 3.3 Verify the text ‘Components’
     */
    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverOnComponents();

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show AllComponents");

        // 3.3 Verify the text ‘Components’
        String actualComponentsText = homePage.verifyComponentsText();
        Assert.assertEquals(actualComponentsText,"Components","Text not match");

    }

}
