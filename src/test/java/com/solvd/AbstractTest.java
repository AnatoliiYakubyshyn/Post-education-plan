package com.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

import com.solvd.gui.utils.R;


public abstract class AbstractTest {

    public final Logger LOGGER = LogManager.getLogger(AbstractTest.class);

    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public WebDriver getDriver() {
        return drivers.get();
    }

    @BeforeMethod
    public void setUp() {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setEnableDownloads(true);
            if (Boolean.parseBoolean((String) R.getConfigParameter("headless"))) {
                chromeOptions.addArguments("--headless");
            }
            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(
                    Integer.parseInt((String) R.getConfigParameter("page_load_timeout"))));
            drivers.set(driver);


        } catch (Exception e) {
            LOGGER.info(e);
        }

    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
