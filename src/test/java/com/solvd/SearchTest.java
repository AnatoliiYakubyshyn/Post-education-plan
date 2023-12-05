package com.solvd;

import com.solvd.gui.components.SearchItem;
import com.solvd.gui.pages.GoodPage;
import org.testng.annotations.Test;

import com.solvd.gui.pages.CatalogSearchPage;
import com.solvd.gui.pages.HomePage;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchTest extends AbstractTest {

    private final String defaultSearch = "T-shirt";

    @Test(testName = "time-consuming#1")
    public void testCheckCorrespondingOfPrices() throws Exception {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CatalogSearchPage catalogSearchPage = homePage.getHeaderMenu().searchGood(defaultSearch);
        List<SearchItem> searchItems = catalogSearchPage.getGoodsOnPage();
        System.out.println(searchItems.size());
        SoftAssert softAssert = new SoftAssert();
        int size = searchItems.size();
        for (int i = 0; i < size; i++) {
            SearchItem item = catalogSearchPage.getSearchItemByIndex(i);
            String firstPrice = item.getPrice();
            GoodPage goodPage = item.click();
            softAssert.assertEquals(firstPrice, goodPage.getPrice(), "error in product " + getDriver().getCurrentUrl());
            getDriver().navigate().back();
        }
        softAssert.assertAll();
    }
}
