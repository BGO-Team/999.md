package NineNineNine.pageObjects;

import NineNineNine.dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public TopBar topBar(){
        return new TopBar(driver);
    }
    public Header header(){
        return new Header(driver);
    }
}
