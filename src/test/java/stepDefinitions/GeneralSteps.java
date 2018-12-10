package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import enums.Context;
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
        testContext.getScenarioContext().setContext(Context.PAGE,page);
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClickOn(String button) {
        Page.clickElement(testContext.getScenarioContext().getContext(Context.PAGE),
                button, testContext.getWebDriverManager().getDriver());
    public void userClickOn(String button) {
        Page.clickElement(testContext.getScenarioContext().getContext(Context.PAGE),
                button, testContext.getWebDriverManager().getDriver());
    }

    @And("^user navigates to \"([^\"]*)\" frame$")
    public void userNavigatesTo(String frameName) throws NoSuchMethodException, NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        testContext.getScenarioContext().setContext(Context.PAGE,frameName);
        Page.goToFrame(frameName,testContext.getWebDriverManager().getDriver());


    }
}
