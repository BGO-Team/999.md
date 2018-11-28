package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.pageObjects.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context){
        testContext = context;
    }

    //TODO: GeneralSteps

    @After
    public void afterStep() {
        testContext.getPageObjectManager().getHomePage().toHomePage();
    }

    @Given("^user is on \"([^\"]*)\"$")
    public void userIsOn(String page) throws Throwable{
        switch (page) {
            case "Home Page" :
                testContext.getPageObjectManager().getHomePage().toHomePage();
                break;
            default :
                throw new IllegalArgumentException("This page does not exist");
        }
    }

    @When("^user click on \"([^\"]*)\" button$")
    public void userClickOn(String button) throws Throwable {
        switch (button) {
            case "Log In" :
                testContext.getPageObjectManager().getTopBar().toLoginFrame();
                break;
            default :
                throw new IllegalArgumentException("This button does not exist");
        }
    }

}
