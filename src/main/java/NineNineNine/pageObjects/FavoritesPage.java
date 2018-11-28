package NineNineNine.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoritesPage {
    private WebDriver driver;

    @FindBy(css = "div.favorites-list__items__item__info > h3 > a")
    private List<WebElement> favoritesProducts;

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean containsProduct(String product){
        for (WebElement element : favoritesProducts)
            if (element.getText().contains(product))
                return true;
        return false;
    }


}
