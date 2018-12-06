package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import dataProviders.TestDataFileReader;
import pageObjects.Header;

public class HeaderSteps {
    private TestContext testContext;
    private Header header;


    public HeaderSteps(TestContext context) {
        testContext = context;
        header = testContext.getPageObjectManager().getHeader();
    }

    @And("user go to FavoritesPage")
    public void userGoToFavoritesPage() {
        header.toFavorites();
    }


    @And("^user search the news \"([^\"]*)\"$")
    public void userSearchTheNewsThatWasAlreadyCreated(String newsName) {

        header.searchThis(newsName);
        header.submitSearch();

    }

}
