package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.solvd.gui.utils.PageOpeningStrategy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private final WebDriver driver;

    private String url;

    private WebElement marker;

    private PageOpeningStrategy pageOpeningStrategy;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void setPageOpeningStrategy(PageOpeningStrategy pageOpeningStrategy) {
        this.pageOpeningStrategy = pageOpeningStrategy;
    }

    protected void setMarker(WebElement marker) {
        this.marker = marker;
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    public boolean isPageOpened() {
        if (pageOpeningStrategy == PageOpeningStrategy.BY_MARKER) {
            return marker.isDisplayed();
        }
        if (pageOpeningStrategy == PageOpeningStrategy.BY_URL) {
            return driver.getCurrentUrl().equals(url);
        }
        return marker.isDisplayed() && driver.getCurrentUrl().equals(url);
    }

    public void open() {
        getDriver().get(url);
    }
}
