package com.solvd;

import org.testng.annotations.Test;

public class DemoTest extends AbstractTest {

    @Test
    public void test() {
        getDriver().get("https://www.google.com/");
        LOGGER.info("HELLO");
    }
}
