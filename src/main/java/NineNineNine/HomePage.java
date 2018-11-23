package NineNineNine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private By categoryLocator = By.cssSelector("section > nav > ul > li > a");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        if (!"Доска объявлений - 999.md".equals(driver.getTitle()))
            throw new IllegalStateException("This is not Home Page");
    }

    public TopBar toTopBar(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-panel");
        return new TopBar(driver);
    }

    public Header toHeader(){
        return new Header(driver);
    }
}