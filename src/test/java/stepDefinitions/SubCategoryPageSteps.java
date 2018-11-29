package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.pageObjects.CategoryPage;
import NineNineNine.pageObjects.SubCategoryPage;
import cucumber.api.java.en.And;

public class SubCategoryPageSteps {
    private TestContext testContext;
    private SubCategoryPage subCategoryPage;

    public SubCategoryPageSteps(TestContext context){
        testContext = context;
        subCategoryPage = testContext.getPageObjectManager().getSubCategoryPage();
    }

    //TODO: CategoryPageSteps

    @And("^user click on \"([^\"]*)\" product$")
    public void userClickOnProduct(String product) {
        subCategoryPage.toProduct(product);
    }

}
