package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyNews {

    private final WebDriver driver;


    @FindBy(linkText = "Sell iphone 999")
    private WebElement newsAddedIphone999;


    public MyNews(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean newsAdded() {
        newsAddedIphone999.isDisplayed();
        return true;
    }

    public void findMyNews() {

        newsAddedIphone999.click();
    }


}
