package com.solvd.homeworktests.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='continue_shopping_ctn']/a")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='cart_status_message']")
    private ExtendedWebElement cartMessage;

    @FindBy(xpath = "//div[@id='cart_estimated_total']")
    private ExtendedWebElement estimatedTotal;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new HomePage(driver);
    }

    public boolean isCartMessagePresent() {
        return cartMessage.isPresent();
    }

    public double getEstimatedTotal() {
        return Double.parseDouble(estimatedTotal.getText());
    }
}
