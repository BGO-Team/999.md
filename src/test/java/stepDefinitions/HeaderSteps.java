package stepDefinitions;

import cucumber.TestContext;
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


    @And("^user search the news that was already created$")
    public void userSearchTheNewsThatWasAlreadyCreated() {

        header.searchThis(TestDataFileReader.getInputSearch());
        header.submitSearch();

    }

}
