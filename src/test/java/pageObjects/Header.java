package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    @FindBy(className = "header__search__button")
    private WebElement searchButton;

    @FindBy(css = "li > a[href=\"/cabinet/favorites\"]")
    private WebElement favoritesButton;

    @FindBy(css = "#header > div.header_numbersTop")
    private WebElement headerPicture;

    @FindBy(id = "js-search-input")
    private WebElement searchField;

    @FindBy(css = "#m__user_panel > ul > li:nth-child(1) > a")
    private WebElement myPosts;

    @FindBy(css = "#header > div.header_bar > div > div > nav > ul > li > a")
    private WebElement addPostButton;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeaderPicture() {
        return headerPicture;
    }

    public void toFavorites(){
        favoritesButton.click();
    }

    public void searchFor(String searchFor){
        searchField.sendKeys(searchFor);
    }

    public WebElement getSearchField() {
        return searchField;
    }
    public WebElement getSearchButton(){
        return searchButton;
    }
}
