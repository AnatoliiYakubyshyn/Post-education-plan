package com.solvd;

import com.solvd.gui.pages.CartPage;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.gui.pages.CatalogSearchPage;
import com.solvd.gui.pages.GoodPage;
import com.solvd.gui.pages.HomePage;

public class ShoppingCartTest extends AbstractTest {

    private final String defaultSearch = "T-shirt";

    @Test(testName = "regression#2")
    public void testShoppingCartFunctionality() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CatalogSearchPage catalogSearchPage = homePage.getHeaderMenu().searchGood(defaultSearch);
        GoodPage goodPage = catalogSearchPage.clickByIndex(0);
        goodPage.chooseSize(0);
        String size = goodPage.getSizeByIndex(0);
        goodPage.chooseColor(0);
        String colorOnGoodPage = goodPage.getCurrentColor();
        goodPage.submit();
        CartPage cartPage = homePage.getHeaderMenu().goToCartPage();
        LOGGER.info(colorOnGoodPage);
        LOGGER.info(cartPage.getColor());
        Assert.assertTrue(cartPage.getColor().equals(colorOnGoodPage),"Colors are not equal");
        Assert.assertTrue(cartPage.getSize().equals(size),"Size are not equal");
    }
}
