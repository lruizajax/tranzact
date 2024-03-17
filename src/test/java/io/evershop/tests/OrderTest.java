package io.evershop.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Integration Tests")
@Feature("Order Tests")
public class OrderTest extends BaseTest {


    @Test
    @Description("Test Description: Create Order with three items")
    public void makeOrderLoggedWithThreeItems(Method method) throws Exception {
        homePage.goToSingOption();
        loginPage.fillOutForm("drojas@gmail.com", "password");
        homePage.goToSearchItems();
        cartPage.searchItems(cartPage.name_Product_1);
        cartPage.selectItems();
        cartPage.addQtyRandom();
        cartPage.customizeItems(1);
        cartPage.addToCart();
        cartPage.closePopupAdded();
        homePage.goToSearchItems();
        cartPage.searchItems(cartPage.name_Product_2);
        cartPage.selectItems();
        cartPage.addQtyRandom();
        cartPage.customizeItems(2);
        cartPage.addToCart();
        cartPage.closePopupAdded();
        homePage.goToSearchItems();
        cartPage.searchItems(cartPage.name_Product_3);
        cartPage.selectItems();
        cartPage.addQtyRandom();
        cartPage.customizeItems(3);
        cartPage.addToCart();
        cartPage.goToShoppingCart();
        cartPage.gotoCheckoutPage();
        checkoutPage.fillContactInfo();
        checkoutPage.fillshippingAddres(faker.name().fullName(), faker.phoneNumber().cellPhone(), faker.address().streetAddress(), faker.address().city(), "US", "US-FL", faker.address().zipCodeByState("FL"));
        checkoutPage.chooseShippingMethods();
        checkoutPage.gotoPaymentOptions();
        checkoutPage.choosePaymentMethod();
        checkoutPage.fillOutPaymentInformation();
        checkoutPage.completeOrder();
        checkoutPage.takeScreenCompleted();
        checkoutPage.goHomePage();
    }
}
