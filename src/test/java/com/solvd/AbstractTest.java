package com.solvd;

import com.solvd.gui.utils.CurrentDriver;
import com.solvd.gui.utils.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.time.Duration;

public abstract class AbstractTest {

    public final Logger LOGGER = LogManager.getLogger(AbstractTest.class);

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setEnableDownloads(true);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
            CurrentDriver.getInstance().setDriver(driver);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(
                    Integer.parseInt((String)R.getConfigParameter("page_load_timeout"))));

        } catch (Exception e) {
            LOGGER.info(e);
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
