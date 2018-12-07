package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import enums.Context;
import pageObjects.Page;
import utils.PageObjectManager;
import cucumber.api.java.en.When;

public class GeneralSteps {
    private TestContext testContext;


    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) throws Throwable{
        Page.getPage(page, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(Context.PAGE,page);
        testContext.getScenarioContext().setContext(Context.CLASSOBJECT, testContext.getPageObjectManager().getHomePage());
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClickOn(String button) throws ClassNotFoundException{
        Page.clickElement(testContext.getScenarioContext().getContext(Context.PAGE),
                button, testContext.getScenarioContext().getContext(Context.CLASSOBJECT));
    }
}
