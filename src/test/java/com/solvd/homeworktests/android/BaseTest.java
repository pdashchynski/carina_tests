package com.solvd.homeworktests.android;

import com.solvd.homeworktests.android.pages.FirstPage;
import com.solvd.homeworktests.android.pages.MainPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.asserts.SoftAssert;

public class BaseTest implements IAbstractTest, IMobileUtils {

    public MainPage getMainPage() {
        SoftAssert sa = new SoftAssert();

        FirstPage firstPage = new FirstPage(getDriver());

        firstPage.clickSkipButton();
        firstPage.clickRejectCookiesButton();
        firstPage.clickSkipButton();

        sa.assertAll();

        return new MainPage(getDriver());
    }
}
