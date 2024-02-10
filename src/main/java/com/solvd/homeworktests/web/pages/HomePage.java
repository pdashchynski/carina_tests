package com.solvd.homeworktests.web.pages;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='global_header']//div[@id='global_action_menu']//a[@class='global_action_link']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@id='store_nav_search_term']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//a[@id='store_search_link']//img")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@id='tab_topsellers_content_trigger']")
    private ExtendedWebElement topSellers;

    @FindBy(xpath = "//span[@id='account_pulldown']")
    private ExtendedWebElement profileDropdownMenu;

    @FindBy(xpath = "//a[@href='javascript:Logout();']")
    private ExtendedWebElement profileDropdownMenuSignOutButton;

    @FindBy(xpath = "//a[@id='cart_link']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//a[@id='cart_link']/span")
    private ExtendedWebElement cartButtonValue;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public void open() {
        super.openURL(Configuration.getRequired("web_url"));
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public String typeSearch(String text) {
        searchField.type(text);
        return text;
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(driver);
    }

    public HomePage clickProfileDropdownMenu() {
        profileDropdownMenu.click();
        return this;
    }

    public HomePage getClickProfileDropdownMenuSignOutButton() {
        profileDropdownMenuSignOutButton.click();
        return this;
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }

    public int getCartAmount() {
        return Integer.parseInt(cartButtonValue.getText().replace("$", ""));
    }

    public ExtendedWebElement getTopSellers() {
        return topSellers;
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isPresent();
    }

    public boolean isCartEmpty() {
        return (getCartAmount() == 0);
    }
}
