package io.evershop.pages;

import io.evershop.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    /**
     * Web Elements
     */

    public By AccountLogin = By.xpath("//div[@class='self-center']/a");
    public By SearchIcon = By.className("search-icon");

    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }


    /**
     * Methods
     */
    public void goToSingOption() {
        click(AccountLogin);
    }

    public void goToSearchItems() {
        click(SearchIcon);
    }
}
