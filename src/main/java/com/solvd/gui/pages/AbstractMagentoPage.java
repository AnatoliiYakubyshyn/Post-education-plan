package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.components.HeaderMenu;
public class AbstractMagentoPage extends AbstractPage{

    @FindBy(xpath = "//header[contains(@class,'page')]")
    private HeaderMenu headerMenu;

    public AbstractMagentoPage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

}
