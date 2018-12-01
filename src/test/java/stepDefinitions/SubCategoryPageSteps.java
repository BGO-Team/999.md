package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.enums.Context;
import NineNineNine.pageObjects.CategoryPage;
import NineNineNine.pageObjects.SubCategoryPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SubCategoryPageSteps {
    private TestContext testContext;
    private SubCategoryPage subCategoryPage;

    public SubCategoryPageSteps(TestContext context){
        testContext = context;
        subCategoryPage = testContext.getPageObjectManager().getSubCategoryPage();
        testContext.getScenarioContext().setContext(Context.SUBCATEGORY, subCategoryPage.getSubCategoryName());
    }

    //TODO: SubCategoryPageSteps

    @And("^user click on \"([^\"]*)\" product$")
    public void userClickOnProduct(String product) {
        subCategoryPage.toProduct(product);
    }

}
