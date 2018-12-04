package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    @FindBy(id = "js-search-input")
    private WebElement searchInput;

    @FindBy(className = "header__search__button")
    private WebElement searchButton;

    @FindBy(css = "li > a[href=\"/cabinet/favorites\"]")
    private WebElement favoritesButton;

    @FindBy(css = "#header > div.header_numbersTop")
    private WebElement headerPicture;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private Header typeSearch(String search) {
        searchInput.sendKeys(search);
        return this;
    }

    public WebElement getHeaderPicture() {
        return headerPicture;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    private void submitSearch() {
        searchButton.submit();
    }

    public void searchThis(String search) {
        typeSearch(search);
        submitSearch();
    }

    public void toFavorites(){
        favoritesButton.click();
    }

}