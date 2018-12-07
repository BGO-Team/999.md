package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import enums.Context;
import managers.PageObjectManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.Page;

import java.lang.reflect.InvocationTargetException;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context){
        testContext = context;
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) throws Throwable{
        Page.getPage(page, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(Context.PAGE,page);
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClickOn(String button) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Page.clickElement(testContext.getScenarioContext().getContext(Context.PAGE),
                button, testContext.getWebDriverManager().getDriver());
    }
}
