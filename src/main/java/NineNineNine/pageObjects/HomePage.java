package NineNineNine.pageObjects;

import NineNineNine.cucumber.ScenarioContext;
import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePage{
    private final WebDriver driver;

    @FindBy(css = ".main-CatalogNavigation > ul > li > a")
    public List<WebElement> category;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage getPage(){
        driver.get(ConfigFileReader.getApplicationUrl());
        return this;
    }

    public void toCategory(int number){
        if (number < 1 || number > category.size())
            throw new IllegalArgumentException("Does not exist such category");
        category.get(number - 1).click();
    }

    public void toCategory(String categoryName){
        if (categoryName.equals("Random")) {
            Random random = new Random();
            int randomCategory = random.nextInt(category.size()) + 1;
            toCategory(randomCategory);
        }
        else {
            boolean existCategory = true;
            for (WebElement element : category)
                if (element.getText().equals(categoryName)) {
                    existCategory = false;
                    element.click();
                    break;
                }
            if (existCategory)
                throw new IllegalArgumentException("This category does not exist");
        }

    }
}