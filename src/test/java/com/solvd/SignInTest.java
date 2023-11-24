package com.solvd;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.gui.pages.SignInPage;
import com.solvd.gui.services.UserService;
import com.solvd.gui.pages.HomePage;

public class SignInTest extends AbstractTest {

    @Test(testName = "regression#1")
    public void testExistingUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPage signInPage = homePage.getHeaderMenu().clickSignInButton();
        signInPage.signIn(UserService.getDefaultUser());
        Assert.assertTrue(homePage.isPageOpened());
    }
}
