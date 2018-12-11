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
    }

    @And("^user choose the SubCategory \"([^\"]*)\" \"([^\"]*)\"$")
    public void userChooseTheSubCategory(String SubCategory, String urlContains2) {
        addPostPage.chooseSubCategory(SubCategory, urlContains2);
        testContext.getScenarioContext().setContext(Context.SUBCATEGORY, SubCategory);
        testContext.getWait().waitFor().until(ExpectedConditions.urlContains(urlContains2));
    }

    @And("^user choose the SellType \"([^\"]*)\"$")
    public void userChooseTheSellType(String SellType) {
        addPostPage.chooseSellType(SellType, "77");
        testContext.getScenarioContext().setContext(Context.SELLTYPE, SellType);
        testContext.getWait().waitFor().until(ExpectedConditions.urlContains("77"));
    }

    @And("^user choose the Country \"([^\"]*)\"$")
    public void userChooseTheCountry(String Country) {
        addPostPage.chooseCountry(Country);
        testContext.getScenarioContext().setContext(Context.COUNTRY, Country);
    }

    @And("^user choose Negotiable Price$")
    public void userChooseNegotiablePrice() {
        addPostPage.clickNegotiablePriceCheckBox();
        Assert.assertTrue(addPostPage.fillPriceField());
    }

    @And("^user fill Title field$")
    public void userFillTitleField() {
        testContext.getScenarioContext().setContext(Context.TEXT, MyPosts.timeTitle());
        addPostPage.titlePostInput(TestDataFileReader.getTitleNewsInput() +
                testContext.getScenarioContext().getContext(Context.TEXT).toString());
        Assert.assertTrue(addPostPage.titleTextIsDisplayed());
    }

    @And("^user fill Information field$")
    public void userFillInformationField() {
        addPostPage.infoPostInput(TestDataFileReader.getInfoPostInput());
        Assert.assertTrue(addPostPage.infoTextIsDisplayed());
    }

    @And("^user choose that he is agree with rules$")
    public void userChooseThatHeIsAgreeWithRules() {
        addPostPage.clickAgreeRulesCheckBox();
        Assert.assertTrue(addPostPage.ruleCheckBoxIsSelectect());
    }

    @And("^user submit new post$")
    public void userSubmitNewPost() {
        Assert.assertNotNull(addPostPage.getSubmitPostButton());
        addPostPage.clickSubmitPostButton();
    }
}
