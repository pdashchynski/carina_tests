package com.solvd.homeworktests.android.pages;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

    @FindBy(id = "eu.livesport.FlashScore_com_plus:id/search_input")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//android.widget.TextView[@text='ALL']")
    private ExtendedWebElement allButton;

    @FindBy(xpath = "//android.widget.TextView[@text='TEAMS']")
    private ExtendedWebElement teamsButton;

    @FindBy(xpath = "//android.widget.TextView[@text='COMPETITIONS']")
    private ExtendedWebElement competitionsButton;

    @FindBy(xpath = "//android.widget.ListView[@resource-id='eu.livesport.FlashScore_com_plus:id/content']/android.view.ViewGroup[%d]")
    private ExtendedWebElement resultByIndex;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='eu.livesport.FlashScore_com_plus:id/participant_name'])[%d]")
    private ExtendedWebElement resultNameByIndex;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='eu.livesport.FlashScore_com_plus:id/country_name'])[%d]")
    private ExtendedWebElement resultSportByIndex;

    @FindBy(xpath = "(//android.widget.FrameLayout[@resource-id='eu.livesport.FlashScore_com_plus:id/my_teams_icon'])[%d]")
    private ExtendedWebElement addToFavButtonByIndex;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage typeSearch(String text) {
        searchField.type(text);

        return this;
    }

    public SearchPage clickAllButton() {
        allButton.click();

        return this;
    }

    public SearchPage clickTeamsButton() {
        teamsButton.click();

        return this;
    }

    public SearchPage clickCompetitionButton() {
        competitionsButton.click();

        return this;
    }

    public String getSearchResultNameByIndex(int index) {
        return resultNameByIndex.format(index).getText();
    }

    public String getSearchResultSportByIndex(int index) {
        return resultSportByIndex.format(index).getText();
    }

    public SearchPage clickAddToFavButtonByIndex(int index) {
        addToFavButtonByIndex.format(index).click();

        return this;
    }
}
