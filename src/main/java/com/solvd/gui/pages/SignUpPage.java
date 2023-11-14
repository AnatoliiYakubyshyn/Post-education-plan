package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.components.SignUpForm;

public class SignUpPage extends AbstractMagentoPage {

    @FindBy(xpath = "//div[contains(@class,'columns')]")
    private SignUpForm signUpForm;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpForm getSignUpForm() {
        return signUpForm;
    }
}
