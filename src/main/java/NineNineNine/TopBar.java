package NineNineNine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopBar {

    private By loginButtonLocator = By.id("user-login-btn");
    private By languageButtonLocator = By.id("user-language");
    private By otherLanguageButtonLocator = By.id("user-language-btn");

    private final WebDriver driver;

    public TopBar(WebDriver driver) {
        this.driver = driver;
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-panel");
    }

    public LoginFrame toLoginFrame(){
        driver.findElement(loginButtonLocator).click();
        return new LoginFrame(driver);
    }

    public TopBar changeLanguage(){
        driver.findElement(languageButtonLocator).click();
        driver.findElement(otherLanguageButtonLocator).click();
        return this;
    }
}