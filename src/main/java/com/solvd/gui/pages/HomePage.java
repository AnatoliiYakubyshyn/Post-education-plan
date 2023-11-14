package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;

import com.solvd.gui.utils.PageOpeningStrategy;

public class HomePage extends AbstractMagentoPage {

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setUrl("https://magento.softwaretestingboard.com/");
    }

}
