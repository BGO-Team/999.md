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
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-popup");
    }

    private LoginFrame typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    private LoginFrame typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    private Header.HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new Header.HomePage(driver);
    }

    public Header.HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}