package io.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    /**
     * Web Elements
     */
    protected By InputEmail = By.name("email");
    protected By InputPassword = By.name("password");
    protected By ButtonLogin = By.xpath("//button/span[contains(text(),'SIGN IN')]");
    protected By LinkRegister = By.linkText("Create an account");
    public By LinkLogout = By.linkText("Logout");

    /**
     * Constructor
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Methods
     */
    public void goToRegisterNewAccount() {
        click(LinkRegister);
    }

    public void fillOutForm(String email, String password) {
        type(InputEmail, email);
        type(InputPassword, password);
    }

    public void clickLoginButton() {
        click(ButtonLogin);
    }

}
