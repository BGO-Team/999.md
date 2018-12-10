package pageObjects;

import dataProviders.TestDataFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class HomePage extends Page{
    @FindBy(css = ".main-CatalogNavigation > ul > li > a")
    private List<WebElement> category;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage toPage(){
        driver.get(TestDataFileReader.getApplicationUrl());
        return this;
    }

    public void toCategory(int number){
        if (number < 1 || number > category.size())
            throw new IllegalArgumentException("Does not exist such category");
        category.get(number - 1).click();
    }

    public void toCategory(String categoryName){
        category = driver.findElements(By.cssSelector(".main-CatalogNavigation > ul > li > a"));
        if (categoryName.equals("Random")) {
            Random random = new Random();
            int randomCategory;
            do {
                randomCategory = random.nextInt(category.size()) + 1;
            } while (randomCategory == 14);

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