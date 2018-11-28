package NineNineNine.pageObjects;

import NineNineNine.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopBar {
    private final WebDriver driver;

    @FindBy(id = "user-login-btn")
    private WebElement loginButton;

    @FindBy(id = "user-language")
    private WebElement languageButton;

    @FindBy(css = "#user-language > ul > li:not(.is-active)")
    private WebElement otherLanguageButtonLocator;

    @FindBy(id = "user-username-btn")
    private WebElement userNameButton;

    public TopBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-panel");
    }

    public TopBar toTopBar(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-panel");
        return this;
    }

    public void toLoginFrame(){
        loginButton.click();
    }

    public void changeLanguage(){
        languageButton.click();
        otherLanguageButtonLocator.click();
    }

    public String getUserName() {
        return userNameButton.getText();
    }
}