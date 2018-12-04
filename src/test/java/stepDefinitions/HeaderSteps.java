package stepDefinitions;

import cucumber.TestContext;
import pageObjects.Header;
import cucumber.api.java.en.And;

public class HeaderSteps {
    private TestContext testContext;
    private Header header;

    public HeaderSteps(TestContext context){
        testContext = context;
        header = testContext.getPageObjectManager().getHeader();
    }

    @And("user go to FavoritesPage")
    public void userGoToFavoritesPage() {
        header.toFavorites();
    }
}
