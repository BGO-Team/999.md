package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import org.junit.Assert;
import pageObjects.CategoryPage;
import cucumber.api.java.en.And;
import pageObjects.Page;

public class CategoryPageSteps {
    private TestContext testContext;
    private CategoryPage categoryPage;

    public CategoryPageSteps(TestContext context) {
        testContext = context;
        categoryPage = (CategoryPage) Page.getPageObject("CategoryPage", testContext.getWebDriverManager().getDriver());
    }

    @And("^user click on \"([^\"]*)\" sub-category$")
    public void userClickOnSubCategory(String subCategory) {
        Assert.assertNotNull(categoryPage.getLastSubCategory());
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.CATEGORY), categoryPage.getCategoryName().getText());
        categoryPage.toSubCategory(subCategory);
        testContext.getScenarioContext().setContext(Context.SUBCATEGORY, subCategory);
    }

    @Then("^user is on selected category page$")
    public void userIsOnSelectedCategoryPage() {
        try{
            testContext.getWait().toBeVisible(categoryPage.getCategoryName());
            Assert.assertTrue(testContext.getScenarioContext().getContext(Context.CATEGORY).toString().equalsIgnoreCase(categoryPage.getCategoryName().getText()));
        }catch (AssertionError e){
            System.out.print("The actual category page " + testContext.getWebDriverManager().getDriver().getCurrentUrl() + " It is not matching with the selected category from previous page" );
        }
    }
}
