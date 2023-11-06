package com.solvd.gui.pages;

import com.solvd.gui.pojo.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = "//input[contains(@name,'login[username]')]")
    private WebElement emailField;

    @FindBy(xpath = "//input[contains(@name,'login[password]')]")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void signInButtonClick() {
        signInButton.click();
    }

    public void signIn(User user) {
        fillEmailField(user.getEmail());
        fillPasswordField(user.getPassword());
        signInButtonClick();
    }
}
