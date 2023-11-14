package com.solvd.gui.components;


import com.solvd.gui.pages.SignInPage;
import com.solvd.gui.pages.SignUpPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.utils.ExtendedWebElement;

public class HeaderMenu extends AbstractComponent {

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private ExtendedWebElement signInButton;

    @FindBy(linkText = "Create an Account" )
    private ExtendedWebElement createAccountButton;

    @FindBy(xpath = ".//a[contains(text(),'Sign Out')]")
    private ExtendedWebElement signOutButton;

    @FindBy(xpath = ".//button[contains(@class,'switch')]")
    private ExtendedWebElement buttonDropDownList;


    public HeaderMenu(SearchContext searchContext, WebDriver driver) {
        super(searchContext, driver);
    }


    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage(getDriver());
    }

    public SignUpPage clickSignUpPage() {
        createAccountButton.click();
        return new SignUpPage(getDriver());
    }

    public void signOut() {
        buttonDropDownList.click();
        signOutButton.click();
    }
}
