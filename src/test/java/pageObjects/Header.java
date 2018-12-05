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

    @FindBy(css = "#m__user_panel > ul > li:nth-child(1) > a")
    private WebElement myNews;


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

    public void submitSearch() {
        searchButton.submit();
    }

    public void searchThis(String search) {
        typeSearch(search);
        submitSearch();
    }

    public void toFavorites(){
        favoritesButton.click();
    }

    public void myNews() {
        myNews.click();
    }

}
