package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import org.junit.Assert;
import pageObjects.HomePage;
import cucumber.api.java.en.When;

public class HomePageSteps{
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context){
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @When("^user click on \"([^\"]*)\" category$")
    public void userClickOnCategory(String category) {
        Assert.assertNotNull(homePage.getLastCategory());
        homePage.toCategory(category);
        testContext.getScenarioContext().setContext(Context.CATEGORY, category);
    }
}
