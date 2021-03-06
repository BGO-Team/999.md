package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.EncryptionUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class LoginFrame extends Page{

    @FindBy(css = "header h2")
    private WebElement frameTitle;

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
        toPage();
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSubmitLoginButton() {
        return submitLoginButton;
    }

    public WebElement getCloseLoginButton() {
        return closeLoginButton;
    }

    public void toPage(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-popup");
    }

    private void typeUsername(String username){
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
        typePassword(EncryptionUtil.decrypt(password));
        submitLogin();
    }
    public WebElement getFrameTitle(){
        return frameTitle;
    }

    public String getUserLogin(String user) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method getUserLogin = Class.forName("dataProviders.TestDataFileReader").getDeclaredMethod("getUserLogin", String.class);
        return (String) getUserLogin.invoke(Class.forName("dataProviders.TestDataFileReader"), user);
    }

    public String getUserPassword(String user) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method getUserLogin = Class.forName("dataProviders.TestDataFileReader").getDeclaredMethod("getUserPassword", String.class);
        return (String) getUserLogin.invoke(Class.forName("dataProviders.TestDataFileReader"), user);
    }

    public void closeLoginFrame() {
        closeLoginButton.click();
    }
}