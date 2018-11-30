package NineNineNine.pageObjects;

import NineNineNine.cucumber.ScenarioContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CategoryPage {
    private WebDriver driver;

    @FindBy(className = "category__subCategories-collection")
    private List<WebElement> subCategories;

    @FindBy(css = "header.categoryPage__header > h1")
    private WebElement categoryName;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCategoryName(){
        return categoryName.getText();
    }

    public void toSubCategory(int number){
        if (number < 1 || number > subCategories.size())
            throw new IllegalArgumentException("Does not exist such category");
        subCategories.get(number - 1).click();
    }

    public void toSubCategory(String subCategoryName){
        if (subCategoryName.equals("Random")) {
            Random random = new Random();
            int randomSubCategory = random.nextInt(subCategories.size()) + 1;
            toSubCategory(randomSubCategory);
        }
        else {
            boolean existSubCategory = true;
            for (WebElement element : subCategories)
                if (element.getText().equals(subCategoryName)) {
                    existSubCategory = false;
                    element.click();
                    break;
                }
            if (existSubCategory)
                throw new IllegalArgumentException("This sub-category does not exist");
        }
    }
}
