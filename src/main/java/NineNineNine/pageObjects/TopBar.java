package NineNineNine.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopBar {
    private static TopBar instance;
    private final WebDriver driver;

    @FindBy(id = "user-login-btn")
    private WebElement loginButton;

    @FindBy(id = "user-language")
    private WebElement languageButton;

    @FindBy(css = "#user-language > ul > li:not(.is-active)")
    private WebElement otherLanguageButtonLocator;

    private TopBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static TopBar getInstance(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-panel");
        if (instance == null)
            instance = new TopBar(driver);
        return instance;
    }

    public LoginFrame toLoginFrame(){
        loginButton.click();
        return LoginFrame.getInstance(driver);
    }

    public void changeLanguage(){
        languageButton.click();
        otherLanguageButtonLocator.click();
    }
}