package io.evershop.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Integration Tests")
@Feature("SingIn Tests")
public class SingInTest extends BaseTest {

    @Test(priority = 1, testName = "Valid Login Test", description = "this test allows verify successful login")
    @Description("Test Description: Login with valid credentials")
    public void doLoginWithValidCredentials(Method method) throws InterruptedException {
        homePage.goToSingOption();
        loginPage.fillOutForm("drojas@gmail.com", "password");
        loginPage.clickLoginButton();
        Thread.sleep(1000);
        homePage.goToSingOption();
        //assertions
        Assert.assertTrue(loginPage.isDisplayed(loginPage.LinkLogout));
    }


    @Test(priority = 2, dataProvider = "dp-invalid-users", testName = "Invalid Login Test", description = "this test allows verify login with invalid credentials")
    public void doLoginWithInValidCredentials(Method method, String email, String password) throws InterruptedException {
        homePage.goToSingOption();
        loginPage.fillOutForm(email, password);
        loginPage.clickLoginButton();
        //assertions
        Thread.sleep(1000);
        homePage.goToSingOption();
        //assertions
        Assert.assertTrue(loginPage.isDisplayed(loginPage.LinkLogout));
    }

    @DataProvider(name = "dp-invalid-users")
    public Object[][] dataInvalid() {
        return new Object[][]{
                {"admin@gmail.com", "superPass"},
                {"admin2@gmail.com", "superPass2"}
        };
    }
}
