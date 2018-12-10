package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import enums.Context;
import pageObjects.Page;
import cucumber.api.java.en.When;

import java.lang.reflect.InvocationTargetException;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) {
        Page.toPage(page, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(Context.PAGE, page);
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClickOn(String button) {
        testContext.getWait().toBeVisible(Page.clickElement(testContext.getScenarioContext().getContext(Context.PAGE),
                button, testContext.getWebDriverManager().getDriver()));
    }

    @And("^user navigates to \"([^\"]*)\"$")
    public void userNavigatesToFrame(String frameName) throws InterruptedException {
        testContext.getScenarioContext().setContext(Context.PAGE, frameName);
        Page.goToFrame(frameName, testContext.getWebDriverManager().getDriver());
        Thread.sleep(2000);
    }
}
