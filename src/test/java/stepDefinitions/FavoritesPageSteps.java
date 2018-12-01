package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.enums.Context;
import NineNineNine.pageObjects.FavoritesPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class FavoritesPageSteps {

    private TestContext testContext;
    private FavoritesPage favoritesPage;

    public FavoritesPageSteps(TestContext context){
        testContext = context;
        favoritesPage = testContext.getPageObjectManager().getFavoritesPage();
    }

    //TODO: ProductPageSteps

    @Then("product is in Favorite List")
    public void productIsInFavoriteList() {
        Assert.assertTrue(favoritesPage.containsProduct(testContext.getScenarioContext().getContext(Context.PRODUCT)));
    }
}
