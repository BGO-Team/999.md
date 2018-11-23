package NineNineNine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private By searchInputLocator = By.id("js-search-input");
    private By searchButtonLocator = By.className("header__search__button");

    private final WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    private Header typeSearch(String search) {
        driver.findElement(searchInputLocator).sendKeys(search);
        return this;
    }

    private HomePage submitSearch() {
        driver.findElement(searchButtonLocator).submit();
        return new HomePage(driver);
    }

    public HomePage searchThis(String search) {
        typeSearch(search);
        return submitSearch();
    }

}
