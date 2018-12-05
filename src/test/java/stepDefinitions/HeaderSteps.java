package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import dataProviders.TestDataFileReader;
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

    @Then("^User clicked on My News Page$")
    public void userClickedOnMyNewsPage(){

        header.myNews();

    }


    @And("^user search the news that was already created$")
    public void userSearchTheNewsThatWasAlreadyCreated() {

        header.searchThis(TestDataFileReader.getTitleNewsInput());
        header.submitSearch();

    }

}
