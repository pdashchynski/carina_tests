package com.solvd.homeworktests.web.pages;

import com.solvd.homeworktests.web.domain.ItemCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='search_resultsRows']/a[%d]")
    private ExtendedWebElement itemByIndex;

    @FindBy(xpath = "//*[@id='search_resultsRows']/a[%d]//span[@class='title']")
    private ExtendedWebElement itemNameByIndex;

    @FindBy(xpath = "//*[@id='search_resultsRows']/a[%d]//div[@class='discount_final_price']")
    private ExtendedWebElement itemPriceByIndex;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ItemCard getItemCardByIndex(int index) {
        ItemCard itemCard = new ItemCard();
        itemCard.setTitle(itemNameByIndex.format(index).getText());
        String price = itemPriceByIndex.format(index).getText().replace("$", "");
        itemCard.setPrice(Double.parseDouble(price));

        return itemCard;
    }

    public ItemPage openItemPageByIndex(int index) {
        itemByIndex.format(index).click();
        return new ItemPage(driver);
    }
}
