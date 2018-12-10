package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import enums.Context;
import org.junit.Assert;
import pageObjects.Header;
import pageObjects.Page;

public class HeaderSteps {
    private TestContext testContext;
    private Header header;

    public HeaderSteps(TestContext context) {
        testContext = context;
        header = (Header) Page.getPageObject("Header", testContext.getWebDriverManager().getDriver());
    }

    @And("user go to FavoritesPage")
    public void userGoToFavoritesPage() {
        Assert.assertNotNull(header.getFavoritesButton());
        header.toFavorites();
    }

    @And("^user search the news \"([^\"]*)\"$")
    public void userSearchTheNewsThatWasAlreadyCreated(String newsName) {
        header.searchFor(newsName);
    }

    @And("^inserts \"([^\"]*)\"$")
    public void inserts(String text) {
        Assert.assertNotNull(header.getSearchButton());
        Assert.assertNotNull(header.getSearchField());
        header.searchFor(text);
        testContext.getScenarioContext().setContext(Context.SEARCHTEXT, text);
    }

    @And("^user navigate to header$")
    public void userGoToHeader() {
        Assert.assertNotNull(header.getHeaderPicture());
        testContext.getScenarioContext().setContext(Context.PAGE, "Header");
    }
}
