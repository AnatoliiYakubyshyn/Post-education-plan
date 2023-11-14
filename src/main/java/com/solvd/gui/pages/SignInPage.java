package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.pojo.User;
import com.solvd.gui.utils.ExtendedWebElement;

public class SignInPage extends AbstractMagentoPage {

    @FindBy(xpath = "//input[contains(@name,'login[username]')]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[contains(@name,'login[password]')]")
    private ExtendedWebElement passwordField;

    @FindBy(id = "send2")
    private ExtendedWebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String email) {
        emailField.type(email);
    }

    public void fillPasswordField(String password) {
        passwordField.secretType(password);
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
