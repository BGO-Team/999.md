package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class CategoryPage extends Page{

    @FindBy(css = ".category__subCategories-collection > a")
    private List<WebElement> subCategories;

    @FindBy(className = ".ads-list-work-detail__item__title")
    private List<WebElement> subCategoriesWork;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void toSubCategory(int number){
        if (number < 1 || number > subCategories.size())
            throw new IllegalArgumentException("Does not exist such sub-category");
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
