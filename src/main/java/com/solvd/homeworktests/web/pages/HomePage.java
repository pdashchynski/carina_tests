package com.solvd.homeworktests.web.pages;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//input[@id='store_nav_search_term']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//a[@id='store_search_link']//img")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@id='tab_topsellers_content_trigger']")
    private ExtendedWebElement topSellers;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public void open() {
        super.openURL(Configuration.getRequired("web_url"));
    }

    public HomePage searchInput(String text) {
        searchField.type(text);
        return this;
    }

    public HomePage searchButtonClick() {
        searchButton.click();
        return this;
    }

    public HomePage topSellersClick() {
        topSellers.click();
        return this;
    }

    public ExtendedWebElement getTopSellers() {
        return topSellers;
    }
}
