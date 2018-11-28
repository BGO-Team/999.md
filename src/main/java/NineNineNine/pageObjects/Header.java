package NineNineNine.pageObjects;

import NineNineNine.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class Header {
    private final WebDriver driver;

    @FindBy(id = "js-search-input")
    private WebElement searchInput;

    @FindBy(className = "header__search__button")
    private WebElement searchButton;

    @FindBy(css = "a[href=\"/cabinet/favorites\"]")
    private WebElement favoritesButton;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private Header typeSearch(String search) {
        searchInput.sendKeys(search);
        return this;
    }

    private void submitSearch() {
        searchButton.submit();
    }

    public void searchThis(String search) {
        typeSearch(search);
    }

    public void toFavorites(){
        favoritesButton.click();
    }

}
