package com.solvd.gui.utils;

import com.solvd.gui.components.HeaderMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;


public class ExtendedFieldDecorator extends DefaultFieldDecorator {

    private final Logger LOGGER = LogManager.getLogger(ExtendedFieldDecorator.class);

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
            return new ExtendedWebElement(proxyForLocator(loader, locator), locator, driver);
        }
        if (HeaderMenu.class.isAssignableFrom(field.getType())) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            try {
                return field.getType().getConstructor(new Class[]{SearchContext.class, WebDriver.class}).
                        newInstance(proxyForLocator(loader, locator), driver);
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
        return super.decorate(loader, field);
    }
}
