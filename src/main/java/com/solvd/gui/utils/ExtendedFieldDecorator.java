package com.solvd.gui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class ExtendedFieldDecorator extends DefaultFieldDecorator {

    private WebDriver driver;

    public ExtendedFieldDecorator(ElementLocatorFactory factory, WebDriver driver) {
        super(factory);
        this.driver = driver;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (field.getType().equals(ExtendedWebElement.class)) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            return new ExtendedWebElement(proxyForLocator(loader, locator),locator,driver);
        }
        return super.decorate(loader, field);
    }
}
