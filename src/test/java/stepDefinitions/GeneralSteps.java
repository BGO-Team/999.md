package stepDefinitions;

import cucumber.TestContext;
import managers.PageObjectManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context){
        testContext = context;
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) throws Throwable{
        PageObjectManager.getPage(page, testContext.getWebDriverManager().getDriver());
    }

    @When("^user click on \"([^\"]*)\" button$")
    public void userClickOn(String button) {
        switch (button) {
            case "Log In" :
                testContext.getPageObjectManager().getTopBar().toLoginFrame();
                break;
            default :
                throw new IllegalArgumentException("This button does not exist");
        }
    }
}
