package com.solvd.homeworktests.web.utils;

import com.solvd.homeworktests.web.domain.Item;
import com.solvd.homeworktests.web.domain.Items;
import com.solvd.homeworktests.web.pages.CartPage;
import com.solvd.homeworktests.web.pages.HomePage;
import com.solvd.homeworktests.web.pages.ItemPage;
import com.solvd.homeworktests.web.pages.SearchPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;

public class ItemService {

    public Item createItem(Items item) {
        return new Item(item.getIndex(), item.getTitle(), item.getPrice());
    }

    public HomePage addItemToCart(int index, WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.typeSearch(R.TESTDATA.get("item" + index + ".title"));
        SearchPage searchPage = homePage.clickSearchButton();

        ItemPage itemPage = searchPage.openItemPageByIndex(index);

        CartPage cartPage = itemPage.clickAddToCartButton();
        return cartPage.clickContinueShoppingButton();
    }
}
