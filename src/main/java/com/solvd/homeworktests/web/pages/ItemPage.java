package com.solvd.homeworktests.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='btn_addtocart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@id='appHubAppName']")
    private ExtendedWebElement itemTitle;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickAddToCartButton() {
        addToCartButton.click();
        return new CartPage(driver);
    }
}
