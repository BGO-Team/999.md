package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import gherkin.lexer.Pa;
import org.junit.Assert;
import pageObjects.FavoritesPage;
import pageObjects.Page;
import pageObjects.ProductListPage;

public class ProductListPageSteps {

    private TestContext testContext;
    private ProductListPage productListPage;

    public ProductListPageSteps(TestContext context){
        this.testContext = context;
        productListPage = (ProductListPage) Page.getPageObject("ProductList", testContext.getWebDriverManager().getDriver());
    }

    @Then("^a new ProductList page is displayed$")
    public void aNewProductListPageIsDisplayed() {
        testContext.getWait().toBeClickable(productListPage.getLastElement());
        Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(testContext.getScenarioContext().getContext(Context.SEARCHTEXT).toString().split(" ")[0]));
    }

    @When("^user navigate to a \"([^\"]*)\" product$")
    public void userNavigateToAProduct(String productName){
        Assert.assertNotNull(productListPage.getLastElement());
        productListPage.toProduct(productName);
        testContext.getWebDriverManager().switchWindow();
    }
}
