package com.solvd;

import com.solvd.gui.components.SignUpForm;
import com.solvd.utility.ReadDataFromCSV;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.solvd.gui.pages.AccountPage;
import com.solvd.gui.objects.ExtendedUser;
import com.solvd.gui.pages.HomePage;
import com.solvd.gui.pages.SignUpPage;
import com.solvd.gui.services.ExtendedUserService;

public class SignUpTest extends AbstractTest {

    @Test(dataProvider = "userProvider", testName = "data-driven#1")
    public void testSignUpWithStrongPassword(ExtendedUser user) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignUpPage signUpPage = homePage.getHeaderMenu().clickSignUpPage();
        Assert.assertTrue(signUpPage.isPageOpened());
        AccountPage accountPage = signUpPage.getSignUpForm().createAccount(user);
        Assert.assertTrue(accountPage.isPageOpened() || signUpPage.isErrorMessageDisplayed(),
                "Test failed with user "+user.toString());
    }


    private String weakPassword = "Password Strength: Weak";

    @Test(dataProvider = "weakPassProvider", testName = "data-driven#2")
    public void testWeakPassword(String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened());
        SignUpPage signUpPage = homePage.getHeaderMenu().clickSignUpPage();
        SignUpForm signUpForm = signUpPage.getSignUpForm();
        signUpForm.fillPasswordField(password);
        Assert.assertEquals(signUpForm.getPasswordStrength().trim(),weakPassword,
                signUpForm.getPasswordStrength().trim());
    }

    @DataProvider(name = "weakPassProvider",parallel = true)
    public Object[][] weakPassProvider() {
        return ReadDataFromCSV.readCsv("src/test/resources/data/weak_passwords.csv");
    }


    @DataProvider(name = "userProvider",parallel = true)
    public Object[][] userProvider() {
        Object[][] res = new Object[50][1];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = ExtendedUserService.generateRandomValidUser();
        }
        return res;
    }
}
