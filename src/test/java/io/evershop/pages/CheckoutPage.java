package io.evershop.pages;

import io.evershop.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckoutPage extends BasePage {

    Actions actions;
    /**
     * Web Elements
     */
    protected By inputEmail = By.name("email");
    protected By continueToShip = By.xpath("//button/span[contains(text(),'Continue to shipping')]");
    protected By inputFullName = By.name("address[full_name]");
    protected By inputPhone = By.name("address[telephone]");
    protected By inputAddress = By.name("address[address_1]");
    protected By inputCity = By.name("address[city]");
    protected By inputCountry = By.id("address[country]");
    protected By inputProvince = By.id("address[province]");
    protected By inputPostal = By.name("address[postcode]");
    protected By shippingMethods = By.xpath("//div[@class='shipping-methods']");
    protected By shippingMethod = By.xpath("//div[@class='shipping-methods']/div/div/div/div/label/span[@class='pl-1']");
    protected By continueToPay = By.xpath("//button/span[contains(text(),'Continue to payment')]");
    protected By paymentOption = By.xpath("//*[local-name()='svg' and starts-with(@class, 'feather')]");
    protected By iframeCC = By.xpath("//div[@id='card-element']/div/iframe");
    protected By inputCardNumber = By.name("cardnumber");
    protected By methodCode = By.id("method_code");
    protected By inputExpDate = By.name("exp-date");
    protected By inputCVc = By.name("cvc");
    protected By placeOrder = By.xpath("//button/span[contains(text(),'Place Order')]");
    protected By orderNumber = By.xpath("//div[@class='self-center']/span");
    protected By btnContinue = By.xpath("//div[@class='checkout-success-customer-info']/a/span[text()='CONTINUE SHOPPING']");

    /**
     * Constructor
     */
    public CheckoutPage(WebDriver driver, Actions actions) {
        super(driver);
        this.actions = actions;
    }

    /**
     * Methods
     */

    public void fillContactInfo() {
        type(inputEmail, "drojas@gmail.com");
        click(continueToShip);
    }

    public void fillshippingAddres(String name, String phone, String address, String city, String country, String province, String postal) {
        type(inputFullName, name);
        type(inputPhone, phone);
        type(inputAddress, address);
        type(inputCity, city);
        selectByValue(inputCountry, country);
        selectByValue(inputProvince, province);
        type(inputPostal, postal);
    }

    public void chooseShippingMethods() {
        if (isDisplayed(shippingMethods)) {
            click(shippingMethod);
        }
    }

    public void gotoPaymentOptions() {
        click(continueToPay);
    }

    public void choosePaymentMethod() {
        //actions.moveToElement((driver.findElement(By.xpath("//*[local-name()='svg' and starts-with(@class, 'feather')]")))).click().build().perform();
        actions.moveToElement(find(paymentOption)).click().build().perform();
    }

    public void fillOutPaymentInformation() {
        changeIframe(iframeCC);
        type(inputCardNumber, "4242424242424242");
        type(inputExpDate, "04/24");
        type(inputCVc, "242");
    }

    public void completeOrder() {
        goOutOfIframe();
        click(placeOrder);
    }

    public String getOrderNumber() {
        return find(orderNumber).getText();
    }

    public void takeScreenCompleted() throws Exception {
        Utils.takeScreenOrder(driver, getOrderNumber());
    }

    public void goHomePage() {
        click(btnContinue);
    }
}
