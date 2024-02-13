package com.solvd.homeworktests.web.utils;

import com.solvd.homeworktests.web.domain.User;
import com.solvd.homeworktests.web.domain.Users;
import com.solvd.homeworktests.web.pages.HomePage;
import com.solvd.homeworktests.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    public User createUser(Users user) {
        return new User(user.getLogin(), user.getPass());
    }

    public HomePage login(User user, WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeLogin(user);
        loginPage.typePass(user);
        loginPage.clickRememberButton();
        return loginPage.clickSubmitButton();
    }
}
