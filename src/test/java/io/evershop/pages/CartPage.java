package io.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class CartPage extends BasePage {

    /**
     * Web Elements
     */
    protected By inputSearch = By.xpath("//div[@class='search-input']/div/div/input");
    protected By linkItemSearch = By.xpath("//div[@class='listing-tem']/div/a");
    protected By qtyProduct = By.name("qty");
    protected By sizeM = By.xpath("//ul/li/a[text()='M']");
    protected By sizeL = By.xpath("//ul/li/a[text()='L']");
    protected By sizeS = By.xpath("//ul/li/a[text()='S']");
    protected By colorGreen = By.xpath("//ul/li/a[text()='Blue']");
    protected By colorPink = By.xpath("//ul/li/a[text()='Pink']");
    protected By colorWhite = By.xpath("//ul/li/a[text()='White']");
    protected By addToCartBtn = By.xpath("//button/span[text()='ADD TO CART']");
    protected By closeIconAdd = By.xpath("//div[@class='Toastify__toast-body']/div/a[contains(text(),'Continue Shopping')]");
    protected By goToShopping = By.xpath("//div[@class='Toastify__toast-body']/div/a[contains(text(),'VIEW CART')]");
    protected By goToCheckoutPage = By.xpath("//a/span[contains(text(),'CHECKOUT')]");
    public String name_Product_1 = "Nike air zoom pegasus 35";
    public String name_Product_2 = "Chuck taylor all star move";
    public String name_Product_3 = "Nike Drop-Type Premium";
    protected int qtyRandom;

    /**
     * Constructor
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Methods
     */

    public void searchItems(String product) {
        typeAndEnter(inputSearch, product);
    }

    public void selectItems() {
        click(linkItemSearch);
    }

    public void addQtyRandom() {
        Random rn = new Random();
        qtyRandom = rn.nextInt(10) + 1;
        find(qtyProduct).clear();
        type(qtyProduct, Integer.toString(qtyRandom));
    }

    public void customizeItems(int number) {
        if (number == 1) {
            click(sizeM);
            click(colorGreen);
        } else if (number == 2) {
            click(sizeL);
            click(colorPink);
        } else if (number == 3) {
            click(sizeS);
            click(colorWhite);
        }
    }

    public void addToCart() {
        click(addToCartBtn);
    }

    public void closePopupAdded() {
        click(closeIconAdd);
    }

    public void goToShoppingCart() {
        click(goToShopping);
    }

    public void gotoCheckoutPage() {
        click(goToCheckoutPage);
    }
}
