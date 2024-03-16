package io.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    /**
     * Web Elements
     */
    protected By InputFullName = By.name("full_name");
    protected By InputEmail = By.name("email");
    protected By InputPassword = By.name("password");
    protected By ButtonSingUp = By.xpath("//button/span[contains(text(),'SIGN UP')]");
    public By AccountTitle = By.xpath("//h1[@class='text-center']");
    public String expected_Title_Header = "My Account";

    /**
     * Constructor
     */
    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Methods
     */

    public void createNewAccount(String fullName, String email, String pass) {
        type(InputFullName, fullName);
        type(InputEmail, email);
        type(InputPassword, pass);
    }

    public void clickSingUpButton() {
        click(ButtonSingUp);
    }

    public String getExpectedTitle() {
        return text(AccountTitle);
    }
}
