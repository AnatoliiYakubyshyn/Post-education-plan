package com.solvd.gui.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExtendedWebElement {

    private final static Logger LOGGER = LogManager.getLogger(ExtendedWebElement.class);

    private WebElement webElement;

    private final WebDriver driver;

    private final WebDriverWait wait;

    private ElementLocator locator;

    public ExtendedWebElement(WebElement webElement, ElementLocator locator,WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(
                Integer.parseInt((String) R.getConfigParameter("element_timeout"))));
        this.webElement = webElement;
    }


    public void click() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            LOGGER.info(locator + " element is clicked");
        } catch (Exception e) {
            LOGGER.error(locator + " element is not clickable");
        }
    }


    public void type(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.sendKeys(text);
            LOGGER.info(locator + " text is typed:"+text);
        } catch (Exception e) {
            LOGGER.error(locator + " element is not displayed");
        }
    }

    public void secretType(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.sendKeys(text);
            LOGGER.info(locator + " text is typed:"+"********");
        } catch (Exception e) {
            LOGGER.error(locator + " element is not displayed");
        }
    }

    public boolean isDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            LOGGER.info(locator + "element is displayed");
            return true;
        } catch (Exception e) {
            LOGGER.info(locator + "element is not displayed");
        }
        return false;
    }

    public WebElement getElement() {
        return webElement;
    }

}
