package com.solvd.homeworktests.android.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FavouritesPage extends AbstractPage {

    @FindBy(id = "eu.livesport.FlashScore_com_plus:id/btn_skip")
    private ExtendedWebElement skipButton;

    @FindBy(id = "eu.livesport.FlashScore_com_plus:id/action_bar_item_7")
    private ExtendedWebElement myTeamsButton;

    public FavouritesPage(WebDriver driver) {
        super(driver);
    }

    public FavouritesPage clickSkipButton() {
        skipButton.click();

        return this;
    }
}
