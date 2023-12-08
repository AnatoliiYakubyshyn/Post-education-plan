package com.solvd.gui.components;

import com.solvd.gui.pages.GoodPage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.gui.utils.ExtendedWebElement;

public class SearchItem extends AbstractComponent {

    @FindBy(xpath = ".//span[contains(@id,'price')]")
    ExtendedWebElement price;

    @FindBy(xpath = ".//button")
    ExtendedWebElement addToCartButton;

    public SearchItem(SearchContext searchContext, WebDriver driver) {
        super(searchContext, driver);
    }

    public String getPrice() {
        return price.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public GoodPage click() {
        getSearchContext().findElement(By.xpath(".")).click();
        return new GoodPage(getDriver());
    }
}
