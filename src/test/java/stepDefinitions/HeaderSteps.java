package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import enums.Context;
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
