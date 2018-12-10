package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import pageObjects.FavoritesPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.Page;

public class FavoritesPageSteps {

    private TestContext testContext;
    private FavoritesPage favoritesPage;

    public FavoritesPageSteps(TestContext context){
        testContext = context;
        favoritesPage = (FavoritesPage) Page.getPageObject("FavoritesPage", testContext.getWebDriverManager().getDriver());
    }

    @Then("product is in Favorite List")
    public void productIsInFavoriteList() {
        Assert.assertTrue(favoritesPage.containsProduct(testContext.getScenarioContext().getContext(Context.PRODUCT).toString()));
    }
}
