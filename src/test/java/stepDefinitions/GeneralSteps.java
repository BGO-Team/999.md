package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import dataProviders.TestDataFileReader;
import enums.Context;
import org.junit.Assert;
import pageObjects.Page;
import cucumber.api.java.en.When;

import java.lang.reflect.InvocationTargetException;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context){
        testContext = context;
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) {
        Page.toPage(page, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(Context.PAGE, page);
        Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(TestDataFileReader.getApplicationUrl()));
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClickOn(String button) {
        Page.clickElement(testContext.getScenarioContext().getContext(Context.PAGE),
                button, testContext.getWebDriverManager().getDriver());
        Assert.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(TestDataFileReader.getApplicationUrl()));
    }
}
