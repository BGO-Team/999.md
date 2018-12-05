package pageObjects;

import managers.WaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopBar {
    private final WebDriver driver;
    private WaitManager wait;
    private String topBarName = "topbar-panel";

    @FindBy(id = "user-login-btn")
    private WebElement loginButton;

    @FindBy(id = "user-language")
    private WebElement languageButton;

    @FindBy(css = "#user-language > ul > li:not(.is-active)")
    private WebElement otherLanguageButton;

    @FindBy(css = "li > .user-item-btn#user-username-btn")
    private WebElement userNameButton;


    @FindBy(css = "#simpalsid-user > ul > li:nth-child(4) > button > span")
    private WebElement userSettingsButton;

    public TopBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        toTopBar();
        wait = new WaitManager(driver);
    }

    public String getTopBarName() {
        return topBarName;
    }

    public TopBar toTopBar(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(topBarName);
        return this;
    }

    public void toLoginFrame(){
        loginButton.click();
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
        userSettingsButton.click();
    }
}