package com.solvd.gui.pages;

import com.solvd.gui.utils.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import com.solvd.gui.utils.PageOpeningStrategy;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private ExtendedWebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setUrl("https://magento.softwaretestingboard.com/");
    }

    public SignInPage clickSignInButton() {
        signInButton.click();
        return new SignInPage(getDriver());
    }

}
