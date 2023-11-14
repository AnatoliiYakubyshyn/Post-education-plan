package com.solvd.gui.components;

import com.solvd.gui.utils.ExtendedFieldDecorator;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class AbstractComponent {

    private final WebDriver driver;

    private final SearchContext searchContext;

    public AbstractComponent(WebDriver driver, SearchContext searchContext) {
        this.driver = driver;
        this.searchContext = searchContext;
        PageFactory.initElements(new ExtendedFieldDecorator(new DefaultElementLocatorFactory(searchContext),driver),this);
    }

    public SearchContext getSearchContext() {
        return searchContext;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
