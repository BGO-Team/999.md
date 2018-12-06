package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.PendingException;
import dataProviders.TestDataFileReader;
import enums.Context;
import pageObjects.Header;

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

    @And("^user search the news \"([^\"]*)\"$")
    public void userSearchTheNewsThatWasAlreadyCreated(String newsName) {
        header.searchFor(newsName);
    }

    @And("^inserts \"([^\"]*)\"$")
    public void inserts(String text) {
      header.searchFor(text);
      testContext.getScenarioContext().setContext(Context.SEARCHTEXT,text);
    }

    @And("^user navigate to header$")
    public void userGoToHeader(){
       testContext.getScenarioContext().setContext(Context.PAGE,"Header");
       testContext.getScenarioContext().setContext(Context.CLASSOBJECT,header);
    }
}
