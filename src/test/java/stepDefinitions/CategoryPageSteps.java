package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import pageObjects.CategoryPage;
import cucumber.api.java.en.And;

public class CategoryPageSteps {
    private TestContext testContext;
    private CategoryPage categoryPage;

    public CategoryPageSteps(TestContext context){
        testContext = context;
        categoryPage = testContext.getPageObjectManager().getCategoryPage();
    }

    @And("^user click on \"([^\"]*)\" sub-category$")
    public void userClickOnSubCategory(String subCategory) {
        categoryPage.toSubCategory(subCategory);
        testContext.getScenarioContext().setContext(Context.SUBCATEGORY, subCategory);

    }
}
