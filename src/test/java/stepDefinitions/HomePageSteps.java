package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import enums.Context;
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
        homePage.toCategory(category);
    }

    @When("^user click on \"([^\"]*)\" buttons$")
    public void userClickOnButtons(String arg0) throws IllegalAccessException, ClassNotFoundException, InterruptedException {
//        testContext.getPageObjectManager().clickButton(arg0,testContext.getScenarioContext().getContext(Context.PAGE));
//        testContext.getPageObjectManager().clikerrrr(testContext.getScenarioContext().getContext(Context.PAGE),arg0);
    }
}
