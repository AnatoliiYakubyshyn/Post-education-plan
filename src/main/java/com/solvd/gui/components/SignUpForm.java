package com.solvd.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.utils.ExtendedWebElement;
import com.solvd.gui.objects.ExtendedUser;
import com.solvd.gui.pages.AccountPage;

public class SignUpForm extends AbstractComponent {

    @FindBy(id = "firstname")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "lastname")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "email_address")
    private ExtendedWebElement emailField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "password-confirmation")
    private ExtendedWebElement confirmPasswordField;

    @FindBy(xpath = ".//button")
    private ExtendedWebElement submitButton;

    public SignUpForm(SearchContext searchContext, WebDriver driver) {
        super(searchContext, driver);
    }

    public void fillLastNameField(String lastName) {
        lastNameField.type(lastName);
    }

    public void fillFirstNameField(String firstName) {
        firstNameField.type(firstName);
    }

    public void fillEmailField(String fillName) {
        emailField.type(fillName);
    }

    public void fillPasswordField(String password) {
        passwordField.type(password);
    }

    public void fillConfirmPasswordField(String password) {
        confirmPasswordField.type(password);
    }

    public void submit() {
        submitButton.click();
    }

    private void baseCreateAccount(ExtendedUser user) {
        fillFirstNameField(user.getFirstName());
        fillLastNameField(user.getLastName());
        fillEmailField(user.getEmail());
        fillPasswordField(user.getPassword());
    }

    public AccountPage createAccount(ExtendedUser user) {
        baseCreateAccount(user);
        fillConfirmPasswordField(user.getPassword());
        submit();
        return new AccountPage(getDriver());
    }

    public AccountPage createAccount(ExtendedUser user, String confirmString) {
        baseCreateAccount(user);
        fillConfirmPasswordField(confirmString);
        submit();
        return new AccountPage(getDriver());
    }

}
