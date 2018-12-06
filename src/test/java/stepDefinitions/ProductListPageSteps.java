package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import org.junit.Assert;
import pageObjects.FavoritesPage;
import pageObjects.ProductListPage;

public class ProductListPageSteps {

    private TestContext testContext;
    private ProductListPage productListPage;

    public ProductListPageSteps(TestContext context){
        this.testContext = context;
        productListPage = testContext.getPageObjectManager().getProductListPage();
    }

    @Then("^a new ProductList page is displayed$")
    public void aNewProductListPageIsDisplayed() {
        testContext.getWait().toBeClickable(productListPage.getLastElement());
        Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(testContext.getScenarioContext().getContext(Context.SEARCHTEXT).toString().split(" ")[0]));
    }

    @When("^user navigate to a \"([^\"]*)\" product$")
    public void userNavigateToAProduct(String productName){
        productListPage.toProduct(productName);
        testContext.getWebDriverManager().switchWindow();
    }
}
