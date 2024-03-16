package io.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    /**
     * Web Elements
     */
    public By LinkAccount = By.xpath("//div[@class='self-center']/a");
    public By LinkLogout = By.linkText("Logout");

    /**
     * Constructor
     */
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void goToAccontMenu() {
        click(LinkAccount);
    }

}
