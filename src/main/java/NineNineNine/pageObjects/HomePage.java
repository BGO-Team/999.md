package NineNineNine.pageObjects;

import NineNineNine.dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static HomePage instance;
    private final WebDriver driver;

    private HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static HomePage getInstance(WebDriver driver){
        if (instance == null)
            instance = new HomePage(driver);
        return instance;
    }

    public HomePage toHomePage(){
        driver.get(ConfigFileReader.getApplicationUrl());
        return this;
    }

    public TopBar toTopBar(){
        return TopBar.getInstance(driver);
    }

    public Header toHeader(){
        return Header.getInstance(driver);
    }
}