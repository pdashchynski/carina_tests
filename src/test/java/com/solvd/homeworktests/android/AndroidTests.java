package com.solvd.homeworktests.android;

import com.solvd.homeworktests.android.domain.SearchResultItem;
import com.solvd.homeworktests.android.pages.MainPage;
import com.solvd.homeworktests.android.pages.SearchPage;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidTests extends BaseTest {

    @Test
    public void gg() {
        MainPage mainPage = getMainPage();

        mainPage.clickStandings();
    }

    @Test
    public void verifyTeamSearchResult() {
        SoftAssert sa = new SoftAssert();

        MainPage mainPage = getMainPage();
        SearchPage searchPage = mainPage.clickSearchIcon();

        searchPage.typeSearch(R.TESTDATA.get("fav.team"));
        searchPage.clickTeamsButton();

        SearchResultItem searchResultItem = new SearchResultItem(searchPage.getSearchResultNameByIndex(1),
                                                                 searchPage.getSearchResultSportByIndex(1));
        sa.assertEquals(R.TESTDATA.get("fav.team"), searchResultItem.getName());
        sa.assertEquals(R.TESTDATA.get("fav.team.sport"), searchResultItem.getSport());

        sa.assertAll();
    }

    @Test
    public void verifyPlayerSearchResult() {
        SoftAssert sa = new SoftAssert();

        MainPage mainPage = getMainPage();
        SearchPage searchPage = mainPage.clickSearchIcon();

        searchPage.typeSearch(R.TESTDATA.get("fav.player"));

        SearchResultItem searchResultItem = new SearchResultItem(searchPage.getSearchResultNameByIndex(1),
                                                                 searchPage.getSearchResultSportByIndex(1));
        sa.assertEquals(R.TESTDATA.get("fav.player"), searchResultItem.getName());
        sa.assertTrue(searchResultItem.getSport().contains(R.TESTDATA.get("fav.player.sport")));
        sa.assertTrue(searchResultItem.getSport().contains(R.TESTDATA.get("fav.player.team")));

        sa.assertAll();
    }

    @Test
    public void verifyCompetitionsSearchResult() {
        SoftAssert sa = new SoftAssert();

        MainPage mainPage = getMainPage();
        SearchPage searchPage = mainPage.clickSearchIcon();

        searchPage.typeSearch(R.TESTDATA.get("competition"));
        searchPage.clickCompetitionButton();

        SearchResultItem searchResultItem = new SearchResultItem(searchPage.getSearchResultNameByIndex(1),
                                                                 searchPage.getSearchResultSportByIndex(1));
        sa.assertEquals(R.TESTDATA.get("competition"), searchResultItem.getName());
        sa.assertEquals(R.TESTDATA.get("competition.sport"), searchResultItem.getSport());

        sa.assertAll();
    }
}
