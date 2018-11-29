package NineNineNine.pageObjects;

import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage{
    private final WebDriver driver;

    @FindBy(css = "section > nav > ul > li > a")
    public List<WebElement> category;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(ConfigFileReader.getApplicationUrl());
    }

    public void toCategory(int number){
        if (number < 1 || number > category.size())
            throw new IllegalArgumentException("Does not exist such category");
        category.get(number - 1).click();
    }
}