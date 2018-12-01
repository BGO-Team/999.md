package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.pageObjects.TopBar;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class TopBarSteps {
    private TestContext testContext;
    private TopBar topBar;

    public TopBarSteps(TestContext context){
        testContext = context;
        topBar = testContext.getPageObjectManager().getTopBar();
    }

    //TODO: TopBarSteps

    @Then("^User Name is showing on Top Bar$")
    public void userNameIsShowingOnTopBar() {
        topBar.toTopBar();
        Assert.assertEquals(ConfigFileReader.getUserLogin(), topBar.getUserName());
    }

    @When("^user change language$")
    public void userChangeLanguage() {
        topBar.toTopBar();
        topBar.changeLanguage();
    }
}
