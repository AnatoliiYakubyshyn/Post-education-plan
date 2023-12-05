package com.solvd.gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import com.solvd.gui.components.SearchItem;

public class CatalogSearchPage extends AbstractMagentoPage {

    @FindBy(xpath = "//li[contains(@class,'product-item')]")
    private List<SearchItem> goods;

    private SearchItem searchItem;

    public CatalogSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoodPage clickByIndex(int index) {
        goods.get(index).click();
        return new GoodPage(getDriver());
    }

    public List<SearchItem> getGoodsOnPage() {
        return goods;
    }

    public SearchItem getSearchItemByIndex(int index) {
        return new SearchItem(getDriver().
                findElement(By.xpath("//li[contains(@class,'product-item')]["+String.valueOf(index+1)+"]")),
                        getDriver());
    }
}
