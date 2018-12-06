package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductListPage extends Page {

    @FindBy(css = "#js-ads-container > ul > li > div > a > img")
    private List<WebElement> allElements;


    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    private void toProduct(int number) {
        if (number < 1 || number > allElements.size())
            throw new IllegalArgumentException("Does not exist such product");
        allElements.get(number - 1).click();
    }

    public void toProduct(String product) {
        if (product.equals("Random")) {
            Random random = new Random();
            int randomProduct = random.nextInt(allElements.size()) + 1;
            toProduct(randomProduct);
        } else {
            boolean existProduct = true;
            for (WebElement element : allElements)
                if (element.getText().equals(product)) {
                    existProduct = false;
                    element.click();
                    break;
                }
            if (existProduct)
                throw new IllegalArgumentException("This product does not exist");
        }
    }


    public WebElement getLastElement() {
        return allElements.get(allElements.size() - 1);
    }
}
