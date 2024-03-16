package io.evershop.tests;

import com.github.javafaker.Faker;
import io.evershop.logs.Log;
import io.evershop.pages.*;
import io.evershop.utils.Variables;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Locale;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected HomePage homePage;
    protected DashboardPage dashboardPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    public Faker faker;
    public JavascriptExecutor js;
    public Actions actions;

    @BeforeTest
    public void loadSettings() {
        Log.info("Loading Base Url for all testing");
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(Variables.BASE_URL);
        faker = new Faker(new Locale("en-US"));
        actions = new Actions(driver);
        Log.info("Initializing Page Object Model");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver,actions);
        js = (JavascriptExecutor) driver;

    }

    @AfterMethod
    public void teardown() {
        Log.info("Closing the driver instance");
        if(driver!=null){
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
