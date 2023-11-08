package com.solvd;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.gui.pages.SignInPage;
import com.solvd.gui.services.UserService;
import com.solvd.gui.pages.HomePage;

public class SignInTest extends AbstractTest {

    @Test
    public void testExistingUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.signIn(UserService.getDefaultUser());
        Assert.assertTrue(homePage.isPageOpened());
    }

    @Test
    public void demoPurpose() {
        getDriver().get("https://www.youtube.com/");
        Assert.assertTrue(true);
    }
}
