package com.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.solvd.gui.pages.CatalogSearchPage;
import com.solvd.gui.pages.HomePage;
import com.solvd.gui.components.SearchItem;
import com.solvd.gui.pages.GoodPage;

import java.util.List;

public class SearchTest extends AbstractTest {

    private final String defaultSearch = "T-shirt";
    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @Test(testName = "time-consuming#1")
    public void testCheckCorrespondingOfPrices() throws Exception {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CatalogSearchPage catalogSearchPage = homePage.getHeaderMenu().searchGood(defaultSearch);
        SoftAssert softAssert = new SoftAssert();
        int page = 1;
        do {
            LOGGER.info("Page "+page+" is opened");
            List<SearchItem> searchItems = catalogSearchPage.getGoodsOnPage();
            int size = searchItems.size();
            for (int i = 0; i < size; i++) {
                SearchItem item = catalogSearchPage.getSearchItemByIndex(i);
                String firstPrice = item.getPrice();
                GoodPage goodPage = item.click();
                LOGGER.info("Item with number on the page "+(i+1)+" is clicked");
                LOGGER.info(getDriver().getCurrentUrl());
                softAssert.assertEquals(firstPrice, goodPage.getPrice(), "error in product " + getDriver().getCurrentUrl());
                getDriver().navigate().back();
            }
            page++;

        } while (catalogSearchPage.navigateToNextPage());
        softAssert.assertAll();
    }
}
