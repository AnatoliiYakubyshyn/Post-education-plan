package com.solvd.gui.utils;

import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class ExtendedFieldDecorator extends DefaultFieldDecorator {


    public ExtendedFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (field.getType().equals(ExtendedWebElement.class)) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            return new ExtendedWebElement(proxyForLocator(loader, locator),locator);
        }
        return super.decorate(loader, field);
    }
}
