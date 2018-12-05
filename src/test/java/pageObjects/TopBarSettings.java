package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopBarSettings {

    private static TopBarSettings instance;
    private final WebDriver driver;

    @FindBy(css = "#simpalsid-settings-tab > form > div:nth-child(4) > input")
    private WebElement firsrname;

    @FindBy(css = "#simpalsid-settings-tab > form > div:nth-child(5) > input")
    private WebElement lastrname;

    @FindBy(css = "#pjax-container > aside > ul > li:nth-child(2) > a")
    private WebElement emailSettings;

    @FindBy(css = "#simpalsid-settings-tab > form > div:nth-child(4) > input")
    private WebElement email;



    public TopBarSettings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static TopBarSettings getInstance(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-settings");
        if (instance == null)
            instance = new TopBarSettings(driver);
        return instance;
    }

    public String firstnameVerify(){

        return firsrname.getAttribute("value");

    }

    public String lastnameVerify(){

        return lastrname.getAttribute("value");

    }

    public String emailVerify(){

        return email.getAttribute("value");
    }

    public TopBarSettings emailSettings() {
        emailSettings.click();
        return TopBarSettings.getInstance(driver);
    }
}
