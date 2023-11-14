package com.solvd.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.utils.ExtendedWebElement;

public class SignUpForm extends AbstractComponent {

    @FindBy(id = "firstname")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "lastname")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "email_address")
    private ExtendedWebElement emailAddressField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "password-confirmation")
    private ExtendedWebElement confirmPasswordField;

    @FindBy(xpath = "//button")
    private ExtendedWebElement submitButton;

    public SignUpForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
