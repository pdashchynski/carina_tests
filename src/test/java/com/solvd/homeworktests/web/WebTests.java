package com.solvd.homeworktests.web;

import com.solvd.homeworktests.web.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTests implements IAbstractTest {

    @Test
    public void search() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        Assert.assertTrue(homePage.getTopSellers().isDisplayed());
    }

    private HomePage getHomePage() {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        return homePage;
    }
}
