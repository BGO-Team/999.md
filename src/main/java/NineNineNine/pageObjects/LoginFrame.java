package NineNineNine.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFrame {
    private static LoginFrame instance;
    private final WebDriver driver;

    @FindBy(name = "login")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(className = "popup-login-form-footer-submit")
    private WebElement submitLoginButton;

    @FindBy(className = "popup-close")
    private WebElement closeLoginButton;

    private LoginFrame(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static LoginFrame getInstance(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-popup");
        if (instance == null)
            instance = new LoginFrame(driver);
        return instance;
    }

    private LoginFrame typeUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    private LoginFrame typePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    private HomePage submitLogin() {
        submitLoginButton.submit();
        return HomePage.getInstance(driver);
    }

    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    public HomePage closeLoginFrame() {
        closeLoginButton.click();
        return HomePage.getInstance(driver);
    }
}