package NineNineNine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopBar {

    private By loginButtonLocator = By.id("user-login-btn");

    private final WebDriver driver;

    public TopBar(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFrame toLoginFrame(){
        driver.findElement(loginButtonLocator).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-popup");
        return new LoginFrame(driver);
    }
}