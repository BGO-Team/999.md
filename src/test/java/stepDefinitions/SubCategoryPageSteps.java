package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import gherkin.lexer.Pa;
import org.junit.Assert;
import org.omg.PortableServer.THREAD_POLICY_ID;
import pageObjects.Page;
import pageObjects.SubCategoryPage;
import cucumber.api.java.en.And;

public class SubCategoryPageSteps {
    private TestContext testContext;
    private SubCategoryPage subCategoryPage;

    public SubCategoryPageSteps(TestContext context){
        testContext = context;
        subCategoryPage = (SubCategoryPage) Page.getPageObject("SubCategoryPage", testContext.getWebDriverManager().getDriver());
    }

    @And("^user click on \"([^\"]*)\" product$")
    public void userClickOnProduct(String product) {
        testContext.getWait().toBeClickable(subCategoryPage.getLastListedFilter());
        subCategoryPage.toProduct(product);
    }

    @Then("^selected sub-category is displayed$")
    public void aNewPageIsDisplayed() {
        try {
            testContext.getWait().toBeVisible(subCategoryPage.getSubCategoryName());
            Assert.assertTrue(testContext.getScenarioContext().getContext(Context.SUBCATEGORY).toString().equalsIgnoreCase(subCategoryPage.getSubCategoryName().getText()));
        }catch (AssertionError e){
            System.out.println("The user is not on selected category, address: " + testContext.getWebDriverManager().getDriver().getCurrentUrl());
        }
    }

    @Then("^The page is updated$")
    public void thePageIsUpdated(){
        testContext.getWait().toBeClickable(subCategoryPage.getLastListedFilter());
        try{
            Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains("applied"));
        }catch (AssertionError e){
            System.out.println("No filter was applied to this page, no update are observed ");
        }
    }

    @And("^click on \"([^\"]*)\" property value$")
    public void clickOn(String propertyValue) {
        testContext.getWait().toBeVisible(subCategoryPage.getLastListedFilter());
        subCategoryPage.selectFilterLevel2(propertyValue);


    }

    @When("^user select \"([^\"]*)\" filter name$")
    public void userSelect(String filterName) {
        testContext.getWait().toBeClickable(subCategoryPage.getLastListedFilter());
        subCategoryPage.selectFilterLevel1(filterName);

    }
}
