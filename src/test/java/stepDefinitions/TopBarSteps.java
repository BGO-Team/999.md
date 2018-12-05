package stepDefinitions;

import cucumber.TestContext;
import dataProviders.TestDataFileReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.TopBar;
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

    @Then("^User Name is showing on Top Bar$")
    public void userNameIsShowingOnTopBar() {
        topBar.toTopBar();
        Assert.assertEquals(TestDataFileReader.getUserLogin(), topBar.getUserName());
    }

    @When("^user change language$")
    public void userChangeLanguage() {
        topBar.toTopBar();
        topBar.changeLanguage();
    }

    @Then("^language was changed on \"([^\"]*)\"$")
    public void languageWasChangedOn(String language) {
        switch (language){
            case "Romanian" :
                testContext.getWait().waitFor().until(ExpectedConditions.urlContains("ro"));
                Assert.assertEquals("ro", testContext.getWebDriverManager().getDriver().getCurrentUrl().substring(15, 17));
                break;
            case "Russian" :
                testContext.getWait().waitFor().until(ExpectedConditions.urlContains("ru"));
                Assert.assertEquals("ru", testContext.getWebDriverManager().getDriver().getCurrentUrl().substring(15, 17));
                break;
            default :
                throw new IllegalArgumentException("This language does not supported");
        }

    }

    @When("^user is on UserSettings$")
    public void userIsOnUserSettings(){

        topBar.toTopBar();
        topBar.userNameButton();


    }
}
