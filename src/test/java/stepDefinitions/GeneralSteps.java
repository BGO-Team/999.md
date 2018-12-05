package stepDefinitions;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import enums.Context;
import managers.PageObjectManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context){
        testContext = context;
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) throws Throwable{
        PageObjectManager.getPage(page, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(Context.PAGE,page);
        testContext.getScenarioContext().setObjContext(Context.ClASSOBJECT,testContext.getPageObjectManager().getHomePage());
    }

    @When("^user click on \"([^\"]*)\" button$")
    public void userClickOn(String button) throws IllegalAccessException, ClassNotFoundException, InterruptedException {
        testContext.getPageObjectManager().clickButton(testContext.getScenarioContext().getContext(Context.PAGE),button,testContext.getScenarioContext().getObjContext(Context.ClASSOBJECT));

    }
}
