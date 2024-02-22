package com.solvd.homeworktests.android.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends AbstractPage {

    @FindBy(id = "eu.livesport.FlashScore_com_plus:id/btn_skip")
    private ExtendedWebElement skipButton;

    @FindBy(id = "eu.livesport.FlashScore_com_plus:id/btn_reject_cookies")
    private ExtendedWebElement rejectCookiesButton;

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    public FirstPage clickSkipButton() {
        skipButton.click();

        return this;
    }

    public MainPage clickRejectCookiesButton() {
        rejectCookiesButton.click();

        return new MainPage(getDriver());
    }
}
