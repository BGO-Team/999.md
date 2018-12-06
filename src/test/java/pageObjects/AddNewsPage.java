package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class AddNewsPage {

    private static AddNewsPage instance;
    private final WebDriver driver;

    @FindBy(css = "#header > div.header_bar > div > div > nav > ul > li > a")
    private WebElement addNewsButton;

    @FindBy(css = "#category")
    private WebElement clickCategoryButton;

    @FindBy(css = "#category > option:nth-child(4)")
    private WebElement choseCategoryTellCategory;

    @FindBy(css = "#js-pjax-container > section.board__content__group.board__content__group__category.m-open.container_25 > div > dl:nth-child(2) > dd > form > select")
    private WebElement clickSubCategoryButton;

    @FindBy(css = "#js-pjax-container > section > div > dl:nth-child(2) > dd > form > select > option:nth-child(3)")
    private WebElement choseAccesSubCategory;

    @FindBy(css = "#js-pjax-container > section.board__content__group.board__content__group__category.m-open.container_25 > div > dl:nth-child(3) > dd > form > select")
    private WebElement clickTypeSellBuyButton;

    @FindBy(css = "#js-pjax-container > section.board__content__group.board__content__group__category.m-open.container_25 > div > dl:nth-child(3) > dd > form > select > option:nth-child(2)")
    private WebElement choseSellType;

    @FindBy(id = "control_7")
    private WebElement clickRegionButton;

    @FindBy(css = "#control_7 > option:nth-child(2)")
    private WebElement choseChisinauRegion;

    @FindBy(id = "form--negotiable-checkbox")
    private WebElement clickNegotiablePriceCheckBox;

    @FindBy(id = "control_12")
    private WebElement titleNewsInput;

    @FindBy(id = "control_13")
    private WebElement infoNewsInput;

    @FindBy(id = "agree")
    private WebElement clickAgreeRulesCheckBox;

    @FindBy(css = "#js-add-form > section.board__content__group.container_25 > div > div > button")
    private WebElement submitNewsButton;


    @FindBy(css = "#category > option:not(:nth-child(1))")
    private List<WebElement> categoryDropMenu;

    @FindBy(css = "#js-pjax-container > section.board__content__group.board__content__group__category.m-open.container_25 > div > dl:nth-child(2) > dd > form > select > option:not(:nth-child(1))")
    private List<WebElement> subCategoryDropMenu;

    @FindBy(css = "#js-pjax-container > section > div > dl:nth-child(3) > dd > form > select > option:not(:nth-child(1))")
    private List<WebElement> sellTypeDropMenu;

    @FindBy(css = "#control_7 > option:not(:nth-child(1))")
    private List<WebElement> countryDropMenu;


    public AddNewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public Header toNewsPage() {
        addNewsButton.click();
        return new Header(driver);
    }


    public HomePage clickTypeSellBuyButton() {
        clickTypeSellBuyButton.click();
        return new HomePage(driver);
    }

    public HomePage choseSellType() {
        choseSellType.click();
        return new HomePage(driver);
    }

    public HomePage clickRegionButton() {
        clickRegionButton.click();
        return new HomePage(driver);
    }

    public HomePage choseChisinauRegion() {
        choseChisinauRegion.click();
        return new HomePage(driver);
    }

    public HomePage clickNegotiablePriceCheckBox() {
        clickNegotiablePriceCheckBox.click();
        return new HomePage(driver);
    }

    public AddNewsPage titleNewsInput(String titleNews1) {
        titleNewsInput.sendKeys(titleNews1);
        return this;
    }

    public AddNewsPage infoNewsInput(String infoNews1) {
        infoNewsInput.sendKeys(infoNews1);
        return this;
    }

    public HomePage clickAgreeRulesCheckBox() {
        clickAgreeRulesCheckBox.click();
        return new HomePage(driver);
    }

    public HomePage submitNewsButton() {
        submitNewsButton.submit();
        return new HomePage(driver);

    }


    public void choseCategory(int number) {
        if (number < 1 || number > categoryDropMenu.size())
            throw new IllegalArgumentException("Does not exist such category");
        categoryDropMenu.get(number - 1).click();
    }

    public void choseCategory(String categoryName) {
        categoryDropMenu = driver.findElements(By.cssSelector("#category > option"));
        if (categoryName.equals("Random")) {
            Random random = new Random();
            int randomCategory;
            do {
                randomCategory = random.nextInt(categoryDropMenu.size()) + 1;
            } while (randomCategory == 14);

            choseCategory(randomCategory);
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

    public void choseSubCategory(int number) {
        if (number < 1 || number > subCategoryDropMenu.size())
            throw new IllegalArgumentException("Does not exist such sub-category");
        subCategoryDropMenu.get(number - 1).click();
    }

    public void choseSubCategory(String subCategoryName) {
        if (subCategoryName.equals("Random")) {
            Random random = new Random();
            int randomSubCategory = random.nextInt(subCategoryDropMenu.size()) + 1;
            choseSubCategory(randomSubCategory);
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

    public void choseSellType(int number) {
        if (number < 1 || number > sellTypeDropMenu.size())
            throw new IllegalArgumentException("Does not exist such sell type");
        sellTypeDropMenu.get(number - 1).click();
    }

    public void choseSellType(String sellTypeName) {
        if (sellTypeName.equals("Random")) {
            Random random = new Random();
            int randomSellType = random.nextInt(sellTypeDropMenu.size()) + 1;
            choseSellType(randomSellType);
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

    public void choseCountry(int number) {
        if (number < 1 || number > countryDropMenu.size())
            throw new IllegalArgumentException("Does not exist such country");
        countryDropMenu.get(number - 1).click();
    }

    public void choseCountry(String countryName) {
        if (countryName.equals("Random")) {
            Random random = new Random();
            int randomCountry = random.nextInt(countryDropMenu.size()) + 1;
            choseCountry(randomCountry);
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

}

