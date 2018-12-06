package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Page {
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

    @FindBy(css = "#container > div > section > div > div > dl.adPage__content__phone.grid_18 > dt")
    private WebElement contactsField;

    @FindBy(css = "div[itemprop=\"description\"]")
    private WebElement descriptionArea;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToFavorite() {
        favoriteButton.click();
        return this;
    }

    public String getBreadCrumbs() {
        return categoryCrumb.getText() + ">" + subCategoryCrumb.getText() + ">" + productCrumb.getText();
    }

    public WebElement getFavoriteButton() {
        return favoriteButton;
    }

    public WebElement getDescriptionArea() {
        return descriptionArea;
    }

    public WebElement getContactsField() {
        return contactsField;
    }

    public boolean descriptionContains(String text){
        String[] values = text.split("");
        for (String value:values)
            if(descriptionArea.getText().toLowerCase().contains(value.toLowerCase()))
                return true;
        return false;
    }

    public boolean nameContains(String text){
        String[] values = text.split("");
        for (String value:values)
            if(productName.getText().toLowerCase().contains(value.toLowerCase()))
                return true;
        return false;
    }

    public String getProductName() {
        return productName.getText();
    }
}
