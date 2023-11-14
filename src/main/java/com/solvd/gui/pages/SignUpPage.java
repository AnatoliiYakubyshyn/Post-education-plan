package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.components.SignUpForm;
import com.solvd.gui.utils.ExtendedWebElement;
import com.solvd.gui.utils.PageOpeningStrategy;

public class SignUpPage extends AbstractMagentoPage {

    @FindBy(xpath = "//div[contains(@class,'columns')]")
    private SignUpForm signUpForm;

    @FindBy(xpath = "//div[contains(text(),'There is already an account')]")
    private ExtendedWebElement containerErrorMessage;

    @FindBy(partialLinkText = "Create an Account")
    private ExtendedWebElement marker;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_MARKER);
        setMarker(marker);
    }

    public SignUpForm getSignUpForm() {
        return signUpForm;
    }

    public boolean isErrorMessageDisplayed() {
        return containerErrorMessage.isDisplayed();
    }
}
