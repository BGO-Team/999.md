package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.enums.Context;
import NineNineNine.pageObjects.ProductPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ProductPageSteps {
    private TestContext testContext;
    private ProductPage productPage;

    public ProductPageSteps(TestContext context){
        testContext = context;
        productPage = testContext.getPageObjectManager().getProductPage();
        testContext.getScenarioContext().setContext(Context.PRODUCT, productPage.getProductName());
    }

    //TODO: SubCategoryPageSteps

    @Then("^user is on this product$")
    public void userIsOnThisProduct() {
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.PRODUCT), productPage.getProductName());
        System.out.println(testContext.getScenarioContext().getContext(Context.PRODUCT));
        System.out.println(testContext.getScenarioContext().getContext(Context.CATEGORY));
        System.out.println(testContext.getScenarioContext().getContext(Context.SUBCATEGORY));

        /**
         * DO BREAD CRUMBS ASSERT
         */
    }

}
