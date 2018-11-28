package NineNineNine.pageObjects;

import NineNineNine.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage {
    private WebDriver driver;

    @FindBy(css = "#js-categories-container > div > div.category__subCategories > ul > li > ul > li")
    private List<WebElement> subCategories;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void toSubcategory(int number){
        if (number < 1 || number > subCategories.size())
            throw new IllegalArgumentException("Does not exist such category");
        subCategories.get(number - 1).click();
    }
}
