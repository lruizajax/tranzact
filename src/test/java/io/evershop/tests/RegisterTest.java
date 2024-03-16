package io.evershop.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Locale;

import static io.evershop.extentreports.ExtentTestManager.startTest;
@Epic("Regression Tests")
@Feature("Register Tests")
public class RegisterTest extends BaseTest {
    Faker faker = new Faker(new Locale("en-US"));
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(8, 10, true, true, true);

    @Test
    @Description("Test Description: Register with valid data.")
    public void doRegisterNewAccountRequiredFields(Method method) throws InterruptedException {
        startTest(method.getName(), "doRegisterNewAccountRequiredFields");
        homePage.goToSingOption();
        loginPage.goToRegisterNewAccount();
        registerPage.createNewAccount(faker.name().fullName(), email, password);
        registerPage.clickSingUpButton();
        Thread.sleep(1000);
        dashboardPage.goToAccontMenu();

        Assert.assertEquals(registerPage.getExpectedTitle(), registerPage.expected_Title_Header);
        System.out.println("The account has been created with Email:" + email + " and Password:" + password);
    }
}
