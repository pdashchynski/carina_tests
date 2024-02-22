package com.solvd.homeworktests.android.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(id = "eu.livesport.FlashScore_com_plus:id/action_bar_item_3")
    private ExtendedWebElement searchIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='eu.livesport.FlashScore_com_plus:id/action_bar_item_1']")
    private ExtendedWebElement sportsDropdownMenu;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='eu.livesport.FlashScore_com_plus:id/title']")
    private ExtendedWebElement sportName;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='eu.livesport.FlashScore_com_plus:id/menu_content'])[%d]")
    private ExtendedWebElement sportsDropdownMenuOptionByIndex;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView[@resource-id='eu.livesport.FlashScore_com_plus:id/bottom_nav_view']/android.view.View/android.view.View[6]")
    private ExtendedWebElement standings;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickStandings() {
        standings.click();
    }

    public SearchPage clickSearchIcon() {
        searchIcon.click();

        return new SearchPage(getDriver());
    }

    public MainPage clickSportsDropdownMenu() {
        sportsDropdownMenu.click();

        return this;
    }

    public MainPage selectSportsDropdownMenuOptionByIndex(int index) {
        sportsDropdownMenuOptionByIndex.format(index).click();

        return this;
    }
}
