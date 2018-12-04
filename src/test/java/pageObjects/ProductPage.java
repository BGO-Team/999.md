package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Page{
    @FindBy(css = ".favorite-toggle")
    private WebElement favoriteButton;

    @FindBy(css = "header.adPage__header > h1")
    private WebElement productName;

    @FindBy(css = "#m__breadcrumbs > li:nth-child(2)")
    private WebElement categoryCrumb;

    @FindBy(css = "#m__breadcrumbs > li:nth-child(3)")
    private WebElement subCategoryCrumb;

    @FindBy(css = "#m__breadcrumbs > li.last")
    private WebElement productCrumb;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return productName.getText();
    }

    public ProductPage addToFavorite(){
        favoriteButton.click();
        return this;
    }

    public String getBreadCrumbs(){
        return categoryCrumb.getText() + ">" + subCategoryCrumb.getText() + ">" + productCrumb.getText();
    }
}
