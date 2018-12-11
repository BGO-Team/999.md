package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class AddPostPage extends Page {

    @FindBy(id = "form--negotiable-checkbox")
    private WebElement clickNegotiablePriceCheckBox;

    @FindBy(id = "control_12")
    private WebElement titlePostInput;

    @FindBy(id = "control_13")
    private WebElement infoPostInput;

    @FindBy(id = "agree")
    private WebElement clickAgreeRulesCheckBox;

    @FindBy(css = "#js-add-form > section.board__content__group.container_25 > div > div > button")
    private WebElement submitPostButton;

    @FindBy(css = "#category > option:not(:first-child)")
    private List<WebElement> categoryDropMenu;

    @FindBy(css = "#js-pjax-container select[name=subcategory] > option:not(:first-child)")
    private List<WebElement> subCategoryDropMenu;

    @FindBy(css = "#js-pjax-container select[name=offer_type] > option:not(:first-child)")
    private List<WebElement> sellTypeDropMenu;

    @FindBy(css = "#control_7 > option:not(:first-child)")
    private List<WebElement> countryDropMenu;

    @FindBy(css = "#control_2")
    private WebElement inputPrice;

    public AddPostPage(WebDriver driver) {
        super(driver);
    }

    public void clickNegotiablePriceCheckBox() {
        clickNegotiablePriceCheckBox.click();
    }

    public AddPostPage titlePostInput(String titleNews1) {
        titlePostInput.sendKeys(titleNews1);
        return this;
    }

    public AddPostPage infoPostInput(String infoNews1) {
        infoPostInput.sendKeys(infoNews1);
        return this;
    }

    public void clickAgreeRulesCheckBox() {
        clickAgreeRulesCheckBox.click();
    }

    public void chooseCategory(int number) {
        if (number < 1 || number > categoryDropMenu.size())
            throw new IllegalArgumentException("Does not exist such category");
        categoryDropMenu.get(number - 1).click();
    }

    public void chooseCategory(String categoryName, String urlContains) {
        categoryDropMenu = driver.findElements(By.cssSelector("#category > option"));
        if (categoryName.equals("Random")) {
            Random random = new Random();
            int randomCategory;
            do {
                randomCategory = random.nextInt(categoryDropMenu.size()) + 1;
            } while (randomCategory == 14);

            chooseCategory(randomCategory);
        } else {
            boolean existCategory = true;
            for (WebElement element : categoryDropMenu)
                if (element.getText().equals(categoryName)) {
                    existCategory = false;
                    element.click();
                    break;
                }
            if (existCategory)
                throw new IllegalArgumentException("This category does not exist");
        }

    }

    public void chooseSubCategory(int number) {
        if (number < 1 || number > subCategoryDropMenu.size())
            throw new IllegalArgumentException("Does not exist such sub-category");
        subCategoryDropMenu.get(number - 1).click();
    }

    public void chooseSubCategory(String subCategoryName, String urlContains) {
        if (subCategoryName.equals("Random")) {
            Random random = new Random();
            int randomSubCategory = random.nextInt(subCategoryDropMenu.size()) + 1;
            chooseSubCategory(randomSubCategory);
        } else {
            boolean existSubCategory = true;
            for (WebElement element : subCategoryDropMenu)
                if (element.getText().equals(subCategoryName)) {
                    existSubCategory = false;
                    element.click();
                    break;
                }
            if (existSubCategory)
                throw new IllegalArgumentException("This sub-category does not exist");
        }
    }

    public void chooseSellType(int number) {
        if (number < 1 || number > sellTypeDropMenu.size())
            throw new IllegalArgumentException("Does not exist such sell type");
        sellTypeDropMenu.get(number - 1).click();
    }

    public void chooseSellType(String sellTypeName, String urlContains) {
        if (sellTypeName.equals("Random")) {
            Random random = new Random();
            int randomSellType = random.nextInt(sellTypeDropMenu.size()) + 1;
            chooseSellType(randomSellType);
        } else {
            boolean existSellType = true;
            for (WebElement element : sellTypeDropMenu)
                if (element.getText().equals(sellTypeName)) {
                    existSellType = false;
                    element.click();
                    break;
                }
            if (existSellType)
                throw new IllegalArgumentException("This sell type does not exist");
        }
    }

    public void chooseCountry(int number) {
        if (number < 1 || number > countryDropMenu.size())
            throw new IllegalArgumentException("Does not exist such country");
        countryDropMenu.get(number - 1).click();
    }

    public void chooseCountry(String countryName) {
        if (countryName.equals("Random")) {
            Random random = new Random();
            int randomCountry = random.nextInt(countryDropMenu.size()) + 1;
            chooseCountry(randomCountry);
        } else {
            boolean existCountry = true;
            for (WebElement element : countryDropMenu)
                if (element.getText().equals(countryName)) {
                    existCountry = false;
                    element.click();
                    break;
                }
            if (existCountry)
                throw new IllegalArgumentException("This country does not exist");
        }
    }

    public void clickSubmitPostButton() {
        submitPostButton.submit();
    }

    public boolean fillPriceField() {
        return inputPrice.isDisplayed();
    }
}


