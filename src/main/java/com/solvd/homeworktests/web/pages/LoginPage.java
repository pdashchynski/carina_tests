package com.solvd.homeworktests.web.pages;

import com.solvd.homeworktests.web.domain.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='text']")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    private ExtendedWebElement passField;

    @FindBy(xpath = "//div[@class='newlogindialog_Check_6EoZE']")
    private ExtendedWebElement rememberButton;

    @FindBy(xpath = "//button[@class='newlogindialog_SubmitButton_2QgFE']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='newlogindialog_FormError_1Mcy9']")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeLogin(User user) {
        loginField.type(user.getLogin());
        return this;
    }

    public LoginPage typePass(User user) {
        passField.type(user.getPass());
        return this;
    }

    public LoginPage clickRememberButton() {
        rememberButton.click();
        return this;
    }

    public HomePage clickSubmitButton() {
        submitButton.click();
        return new HomePage(driver);
    }

    public boolean isLoginFieldPresent() {
        return loginField.isPresent();
    }

    public boolean isPassFieldPresent() {
        return passField.isPresent();
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isPresent();
    }
}
