package NineNineNine.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    @FindBy(css = ".favorite-toggle")
    private WebElement favoriteButton;

    @FindBy(css = "header.adPage__header > h1")
    private WebElement productName;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName(){
        return productName.getText();
    }

    public ProductPage addFavorite(){
        favoriteButton.click();
        return this;
    }
}
