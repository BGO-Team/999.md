package stepDefinitions;

import cucumber.TestContext;
import dataProviders.TestDataFileReader;
import enums.Context;
import pageObjects.ProductPage;
import cucumber.api.java.en.And;
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

    @Then("^user is on this product$")
    public void userIsOnThisProduct() {
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.PRODUCT), productPage.getProductName());
        String[] breadCrumbs = productPage.getBreadCrumbs().split(">");
        Assert.assertEquals(breadCrumbs[0], testContext.getScenarioContext().getContext(Context.CATEGORY));
        Assert.assertEquals(breadCrumbs[1], testContext.getScenarioContext().getContext(Context.SUBCATEGORY));
        Assert.assertEquals(breadCrumbs[2], testContext.getScenarioContext().getContext(Context.PRODUCT));
    }

    @And("user add product to Favorite List")
    public void userAddProductToFavoriteList() {
        productPage.addToFavorite();
    }

    @And("^user sent message to product's author$")
    public void userSentMessageToProductAuthor() throws InterruptedException {
        Thread.sleep(5000);
        productPage.inputMessage(TestDataFileReader.getInputMessage());

        productPage.sendMessageButton();

    }
}
