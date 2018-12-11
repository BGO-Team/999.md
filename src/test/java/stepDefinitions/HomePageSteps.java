package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import org.junit.Assert;
import pageObjects.Header;
import pageObjects.HomePage;
import pageObjects.Page;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = (HomePage) Page.getPageObject("HomePage", testContext.getWebDriverManager().getDriver());
    }

    @When("^user click on \"([^\"]*)\" category$")
    public void userClickOnCategory(String category) {
        Assert.assertNotNull(homePage.getLastCategory());
        homePage.toCategory(category);
        testContext.getScenarioContext().setContext(Context.CATEGORY, category);
        Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains("/category/"));
    }

    @Then("^user remains on HomePage$")
    public void userRemainsOnHomePage() {
        testContext.getWait().toBeVisible(new Header(testContext.getWebDriverManager().getDriver()).getHeaderPicture());
        Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().equalsIgnoreCase("https://999.md/ru/"));
    }
}
