package NineNineNine.pageObjects;

import NineNineNine.dataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritesPage extends Page{
    @FindBy(css = "div.favorites-list__items__item__info > h3 > a")
    private List<WebElement> favoritesProducts;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public FavoritesPage toPage(){
        driver.get(ConfigFileReader.getApplicationUrl() + "cabinet/favorites");
        return this;
    }

    public Boolean containsProduct(String product){
        for (WebElement element : favoritesProducts)
            if (element.getText().contains(product))
                return true;
        return false;
    }


}
