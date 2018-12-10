package pageObjects;

import org.openqa.selenium.support.ui.Wait;
import utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopBar {
    private final WebDriver driver;
    private WaitUtil wait;
    private String topBarName = "topbar-panel";

    @FindBy(id = "user-login-btn")
    private WebElement loginButton;

    @FindBy(id = "user-language")
    private WebElement languageButton;

    @FindBy(css = "#user-language > ul > li:not(.is-active)")
    private WebElement otherLanguageButton;

    @FindBy(css = "li > .user-item-btn#user-username-btn")
    private WebElement userNameButton;

    @FindBy(css ="li > button[data-settings=\"toggle\"]")
    private  WebElement settingsButton;

    public TopBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtil(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public TopBar toTopBar(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(topBarName);
        return this;
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public String getTopBarName() {
        return topBarName;
    }

    public LoginFrame toLoginFrame(){
        loginButton.click();
        return new LoginFrame(driver);
    }

    public void changeLanguage(){
        wait.toBeClickable(languageButton);
        languageButton.click();
        wait.toBeClickable(otherLanguageButton);
        otherLanguageButton.click();
    }

    public String getUserName() {
        wait.toBeClickable(userNameButton);
        return userNameButton.getText();
    }

    public void toSettings(){
        settingsButton.click();
    }

    public WebElement getSettingsButton(){
        return settingsButton;
    }

}