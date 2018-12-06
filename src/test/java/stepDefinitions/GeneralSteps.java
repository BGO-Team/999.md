package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import enums.Context;
import managers.PageObjectManager;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) throws Throwable {
        PageObjectManager.getPage(page, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(Context.PAGE, page);
        testContext.getScenarioContext().setContext(Context.ClASSOBJECT, testContext.getPageObjectManager().getHomePage());
    }

    @And("^user click on \"([^\"]*)\"$")
    public void userClickOn(String button) throws ClassNotFoundException {
        testContext.getPageObjectManager().clickElement(testContext.getScenarioContext().getContext(Context.PAGE),
                button, testContext.getScenarioContext().getContext(Context.ClASSOBJECT));
    }
}
