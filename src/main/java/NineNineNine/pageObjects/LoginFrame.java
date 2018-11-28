package NineNineNine.pageObjects;

import NineNineNine.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFrame {
    private final WebDriver driver;

    @FindBy(name = "login")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(className = "popup-login-form-footer-submit")
    private WebElement submitLoginButton;

    @FindBy(className = "popup-close")
    private WebElement closeLoginButton;

    public LoginFrame(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-popup");

    }

    private void typeUsername(String username) {
        usernameInput.sendKeys(username);
    }

    private void typePassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void submitLogin() {
        submitLoginButton.submit();
    }

    public void loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        submitLogin();
    }

    public void closeLoginFrame() {
        closeLoginButton.click();
    }
}