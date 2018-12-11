package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import dataProviders.TestDataFileReader;
import enums.Context;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AddPostPage;
import pageObjects.MyPosts;
import pageObjects.Page;

public class AddPostPageSteps {

    private TestContext testContext;
    private AddPostPage addPostPage;

    public AddPostPageSteps(TestContext context) {
        testContext = context;
        addPostPage = (AddPostPage) Page.getPageObject("AddPostPage", testContext.getWebDriverManager().getDriver());
    }

    @And("^user choose the Category \"([^\"]*)\" \"([^\"]*)\"$")
    public void userChooseTheCategory(String Category, String urlContains1) {
        addPostPage.chooseCategory(Category, urlContains1);
        testContext.getScenarioContext().setContext(Context.CATEGORY, Category);
        testContext.getWait().waitFor().until(ExpectedConditions.urlContains(urlContains1));
//        Assert.assertEquals(Category,testContext.getWebDriverManager().getDriver().findElement
//                (By.cssSelector("#js-pjax-container select[name=subcategory] > option:checked")).getText());
    }

    @And("^user choose the SubCategory \"([^\"]*)\" \"([^\"]*)\"$")
    public void userChooseTheSubCategory(String SubCategory, String urlContains2) {
        addPostPage.chooseSubCategory(SubCategory, urlContains2);
        testContext.getScenarioContext().setContext(Context.SUBCATEGORY, SubCategory);
        testContext.getWait().waitFor().until(ExpectedConditions.urlContains(urlContains2));
//        Assert.assertEquals(SubCategory,testContext.getWebDriverManager().getDriver().findElement
//                (By.cssSelector("#js-pjax-container select[name=subcategory] > option:checked")).getText());
    }

    @And("^user choose the SellType \"([^\"]*)\"$")
    public void userChooseTheSellType(String SellType) {
        addPostPage.chooseSellType(SellType, "77");
        testContext.getScenarioContext().setContext(Context.SELLTYPE, SellType);
        testContext.getWait().waitFor().until(ExpectedConditions.urlContains("77"));
//        Assert.assertEquals(SellType,testContext.getWebDriverManager().getDriver().findElement
//                (By.cssSelector("#js-pjax-container select[name=offer_type] > option:checked")).getText());
    }

    @And("^user choose the Country \"([^\"]*)\"$")
    public void userChooseTheCountry(String Country) {
        addPostPage.chooseCountry(Country);
        testContext.getScenarioContext().setContext(Context.COUNTRY, Country);
//        Assert.assertEquals(Country,testContext.getWebDriverManager().getDriver().findElement
//                (By.cssSelector("#control_7 > option:checked")).getText());
    }

    @And("^user choose Negotiable Price$")
    public void userChooseNegotiablePrice() {
        addPostPage.clickNegotiablePriceCheckBox();
        Assert.assertEquals(true, addPostPage.fillPriceField());
    }

    @And("^user fill Title field$")
    public void userFillTitleField() {
        testContext.getScenarioContext().setContext(Context.TEXT, MyPosts.timeTitle());
        addPostPage.titlePostInput(TestDataFileReader.getTitleNewsInput() +
                testContext.getScenarioContext().getContext(Context.TEXT).toString());
        Assert.assertNotNull(testContext.getWebDriverManager().getDriver().findElements(By.id("control_12")));
    }

    @And("^user fill Information field$")
    public void userFillInformationField() {
        addPostPage.infoPostInput(TestDataFileReader.getInfoPostInput());
        Assert.assertEquals(TestDataFileReader.getInfoPostInput(), "New phone IPHONE 999 , last version");
    }

    @And("^user choose that he is agree with rules$")
    public void userChooseThatHeIsAgreeWithRules() {
        addPostPage.clickAgreeRulesCheckBox();
        Assert.assertTrue(testContext.getWebDriverManager().getDriver().findElement(By.id("agree")).isSelected());
    }

    @And("^user submit new post$")
    public void userSubmitNewPost() {
        addPostPage.clickSubmitPostButton();
        Assert.assertTrue(testContext.getWebDriverManager().getDriver().findElement(By.cssSelector("div.wallet-tab-header")).isDisplayed());
    }
}
