package com.solvd.gui.pages;

import com.solvd.gui.components.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import com.solvd.gui.utils.ExtendedWebElement;

public class CatalogSearchPage extends AbstractMagentoPage {

    @FindBy(xpath = "//li[contains(@class,'product-item')]")
    private List<SearchItem> goods;
    public CatalogSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoodPage clickByIndex(int index) {
        goods.get(index).click();
        return new GoodPage(getDriver());
    }
}
