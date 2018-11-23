package NineNineNine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFrame {

    private By usernameLocator = By.name("login");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.className("popup-login-form-footer-submit");

    private final WebDriver driver;

    public LoginFrame(WebDriver driver) {
        this.driver = driver;
    }

    private LoginFrame typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    private LoginFrame typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    private HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }

    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}