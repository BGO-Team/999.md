package NineNineNine.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SubCategoryPage extends Page{
    @FindBy(xpath = "//li[@class=\"ads-list-photo-item\" and ./div[contains(@class,\"ads-list-photo-item-price\")] " +
            "and not(./span[@class=\"booster-label\"])]")
    private List<WebElement> products;

    @FindBy(className = "ads-list-work-detail__item__title ")
    private List<WebElement> alternativeProducts;

    @FindBy(css = "header.page-header > h1")
    private WebElement subCategoryName;

    public SubCategoryPage(WebDriver driver) {
        super(driver);
        if (products.size() < 1)
            products = alternativeProducts;
    }

    public String getSubCategoryName(){
        return subCategoryName.getText();
    }

    public void toProduct(int number){
        if (number < 1 || number > products.size())
            throw new IllegalArgumentException("Does not exist such product");
        products.get(number - 1).click();
    }

    public void toProduct(String product){
        if (product.equals("Random")) {
            Random random = new Random();
            int randomProduct = random.nextInt(products.size()) + 1;
            toProduct(randomProduct);
        }
        else {
            boolean existProduct = true;
            for (WebElement element : products)
                if (element.getText().equals(product)) {
                    existProduct = false;
                    element.click();
                    break;
                }
            if (existProduct)
                throw new IllegalArgumentException("This product does not exist");
        }
    }
}
