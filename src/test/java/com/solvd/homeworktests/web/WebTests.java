package com.solvd.homeworktests.web;

import com.solvd.homeworktests.web.domain.Item;
import com.solvd.homeworktests.web.domain.ItemCard;
import com.solvd.homeworktests.web.domain.Items;
import com.solvd.homeworktests.web.domain.Users;
import com.solvd.homeworktests.web.pages.*;
import com.solvd.homeworktests.web.utils.ItemService;
import com.solvd.homeworktests.web.utils.LoginService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTests implements IAbstractTest {

    private final LoginService loginService = new LoginService();
    private final ItemService itemService = new ItemService();

    @Test
    public void verifyValidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        LoginPage loginPage = homePage.clickLoginButton();

        sa.assertTrue(loginPage.isLoginFieldPresent());
        sa.assertTrue(loginPage.isPassFieldPresent());

        loginService.login(loginService.createUser(Users.VALID), getDriver());
        sa.assertTrue(homePage.isPageOpened());

        sa.assertAll();
    }

    @Test
    public void verifyInvalidLoginTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        LoginPage loginPage = homePage.clickLoginButton();

        sa.assertTrue(loginPage.isLoginFieldPresent());
        sa.assertTrue(loginPage.isPassFieldPresent());

        loginService.login(loginService.createUser(Users.INVALID), getDriver());
        sa.assertFalse(homePage.isPageOpened());
        sa.assertTrue(loginPage.isErrorMessagePresent());

        sa.assertAll();
    }

    @Test
    public void verifyLogout() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        LoginPage loginPage = homePage.clickLoginButton();

        sa.assertTrue(loginPage.isLoginFieldPresent());
        sa.assertTrue(loginPage.isPassFieldPresent());

        loginService.login(loginService.createUser(Users.VALID), getDriver());
        sa.assertTrue(homePage.isPageOpened());

        homePage.clickProfileDropdownMenu();
        homePage.getClickProfileDropdownMenuSignOutButton();
        sa.assertTrue(homePage.isLoginButtonPresent());

        sa.assertAll();
    }

    @Test
    public void verifySearchResults() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        String input = homePage.typeSearch(R.TESTDATA.get("search.input"));
        SearchPage searchPage = homePage.clickSearchButton();

        ItemCard itemCard = searchPage.getItemCardByIndex(1);
        sa.assertEquals(input, itemCard.getTitle());

        sa.assertAll();
    }

    @Test
    public void verifyAddingToCart() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();
        double total = 0;

        //sa.assertTrue(homePage.isCartEmpty());

        Item item1 = itemService.createItem(Items.FIRST);
        itemService.addItemToCart(item1.getIndex(), getDriver());
        total += item1.getPrice();

        Item item2 = itemService.createItem(Items.SECOND);
        itemService.addItemToCart(item2.getIndex(), getDriver());
        total += item2.getPrice();

        CartPage cartPage = homePage.clickCartButton();

        sa.assertTrue(homePage.getCartAmount() == 2);
        sa.assertTrue(total == cartPage.getEstimatedTotal());

        sa.assertAll();
    }

    @Test
    public void verifyRemovingFromCart() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        itemService.addItemToCart(1, getDriver());
        itemService.addItemToCart(2, getDriver());

        sa.assertTrue(homePage.getCartAmount() == 2);

        sa.assertAll();
    }

    private HomePage getHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        return homePage;
    }
}
