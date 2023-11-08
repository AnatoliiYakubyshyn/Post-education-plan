package com.solvd.gui.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExtendedWebElement  {

    private final static Logger LOGGER = LogManager.getLogger(ExtendedWebElement.class);

    private WebElement webElement;

    private final WebDriver driver;

    private final WebDriverWait wait;

    public ExtendedWebElement(WebElement webElement) {
        this.driver = CurrentDriver.getInstance().getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(
                Integer.parseInt((String) R.getConfigParameter("element_timeout"))));
        this.webElement = webElement;
    }


    public void click() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            LOGGER.info("element is clicked");
        } catch (Exception e) {
            LOGGER.error("element is not clickable");
        }
    }


    public void type(String text) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.sendKeys(text);
            LOGGER.info("text is typed");
        } catch (Exception e) {
            LOGGER.error("element is not displayed");
        }
    }

    public boolean isDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            LOGGER.info("element is displayed");
            return true;
        } catch (Exception e) {
            LOGGER.info("element is not displayed");
        }
        return false;
    }


}
