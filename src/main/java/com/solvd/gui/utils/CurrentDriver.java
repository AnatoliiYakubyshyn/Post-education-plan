package com.solvd.gui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class CurrentDriver {

    private WebDriver driver;

    private CurrentDriver() {

    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private static CurrentDriver instance = null;

    public static CurrentDriver getInstance() {
        if (instance == null) {
            instance = new CurrentDriver();
        }
        return instance;
    }

}
