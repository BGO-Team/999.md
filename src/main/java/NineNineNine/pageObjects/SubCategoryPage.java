package NineNineNine.pageObjects;

import NineNineNine.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SubCategoryPage {
    private WebDriver driver;

    @FindBy(xpath = "//li[@class=\"ads-list-photo-item\" and ./div[contains(@class,\"ads-list-photo-item-price\")] " +
            "and not(./span[@class=\"booster-label\"])]")
    private List<WebElement> products;

    public SubCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void toProduct(int number){
        if (number < 1 || number > products.size())
            throw new IllegalArgumentException("Does not exist such category");
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
