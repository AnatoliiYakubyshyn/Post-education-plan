package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.utils.PageOpeningStrategy;
import com.solvd.gui.components.HeaderMenu;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//header[contains(@class,'page')]")
    private HeaderMenu headerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setUrl("https://magento.softwaretestingboard.com/");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
