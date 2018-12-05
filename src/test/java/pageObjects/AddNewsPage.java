package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewsPage {

    private static AddNewsPage instance;
    private final WebDriver driver;

    @FindBy(css = "#header > div.header_bar > div > div > nav > ul > li > a")
    private WebElement addNewsButton;

    @FindBy(css = "#header > div.header_bar > div > div > nav > ul > li > a")
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


    public AddNewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static AddNewsPage getInstance(WebDriver driver) {
        if (instance == null)
            instance = new AddNewsPage(driver);
        return instance;
    }

    public Header toNewsPage() {
        addNewsButton.click();
        return new Header(driver);
    }

    public HomePage clickCategoryTypeNewsMenu() {
        clickCategoryButton.click();
        return new HomePage(driver);
    }

    public HomePage choseCategoryTell() {
        choseCategoryTellCategory.click();
        return new HomePage(driver);
    }


    public HomePage clickSubCategoryButton() {
        clickSubCategoryButton.click();
        return new HomePage(driver);
    }

    public HomePage choseAccesSubCategory() {
        choseAccesSubCategory.click();
        return new HomePage(driver);
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



}

