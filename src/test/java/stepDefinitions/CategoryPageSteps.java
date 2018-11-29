package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.pageObjects.CategoryPage;
import cucumber.api.java.en.And;

public class CategoryPageSteps {
    private TestContext testContext;
    private CategoryPage categoryPage;

    public CategoryPageSteps(TestContext context){
        testContext = context;
        categoryPage = testContext.getPageObjectManager().getCategoryPage();
    }

    //TODO: CategoryPageSteps

    @And("^user click on \"([^\"]*)\" sub-category$")
    public void userClickOnSubCategory(String subCategory) {
        categoryPage.toSubCategory(subCategory);
    }
}
