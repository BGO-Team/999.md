package NineNineNine.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    private static Header instance;
    private final WebDriver driver;

    @FindBy(id = "js-search-input")
    private WebElement searchInput;

    @FindBy(className = "header__search__button")
    private WebElement searchButton;

    private Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static Header getInstance(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("topbar-popup");
        if (instance == null)
            instance = new Header(driver);
        return instance;
    }

    private Header typeSearch(String search) {
        searchInput.sendKeys(search);
        return this;
    }

    private HomePage submitSearch() {
        searchButton.submit();
        return HomePage.getInstance(driver);
    }

    public HomePage searchThis(String search) {
        typeSearch(search);
        return submitSearch();
    }

}
