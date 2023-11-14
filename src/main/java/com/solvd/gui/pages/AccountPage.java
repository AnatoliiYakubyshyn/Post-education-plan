package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import com.solvd.gui.utils.ExtendedWebElement;
import com.solvd.gui.utils.PageOpeningStrategy;

public class AccountPage extends AbstractMagentoPage {

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    private ExtendedWebElement marker;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_MARKER);
        setMarker(marker);
    }

}
