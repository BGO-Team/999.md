package NineNineNine.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFrame extends Page{
    @FindBy(name = "login")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(className = "popup-login-form-footer-submit")
    private WebElement submitLoginButton;

    @FindBy(className = "popup-close")
    private WebElement closeLoginButton;

    public LoginFrame(WebDriver driver) {
        super(driver);
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