package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import pageObjects.SubCategoryPage;
import cucumber.api.java.en.And;

public class SubCategoryPageSteps {
    private TestContext testContext;
    private SubCategoryPage subCategoryPage;

    public SubCategoryPageSteps(TestContext context){
        testContext = context;
        subCategoryPage = testContext.getPageObjectManager().getSubCategoryPage();
    }

    @And("^user click on \"([^\"]*)\" product$")
    public void userClickOnProduct(String product) {
        subCategoryPage.toProduct(product);
        testContext.getScenarioContext().setContext(Context.PRODUCT, product);

    }

}
