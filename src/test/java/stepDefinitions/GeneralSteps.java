package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import enums.Context;
import utils.PageObjectManager;
import cucumber.api.java.en.When;

public class GeneralSteps {

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) throws Throwable{
        PageObjectManager.getPage(page, webDriverManager.getDriver());
        testContext.getScenarioContext().setContext(Context.PAGE,page);
        testContext.getScenarioContext().setContext(Context.CLASSOBJECT, testContext.getPageObjectManager().getHomePage());
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClickOn(String button) throws ClassNotFoundException{
        testContext.getPageObjectManager().clickElement(testContext.getScenarioContext().getContext(Context.PAGE),
                button, testContext.getScenarioContext().getContext(Context.CLASSOBJECT));
    }
}
