package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.dataProviders.TestDataFileReader;
import NineNineNine.pageObjects.TopBar;
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
        Assert.assertEquals(TestDataFileReader.getUserLogin(), topBar.getUserName());
    }

    @When("^user change language$")
    public void userChangeLanguage() {
        topBar.toTopBar();
        topBar.changeLanguage();
    }

    @Then("^language was changed on \"([^\"]*)\"$")
    public void languageWasChangedOn(String language) {
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().toBeClickable(testContext.getPageObjectManager().getHeader().getSearchButton());
        switch (language){
            case "Romanian" :
                Assert.assertEquals(testContext.getWebDriverManager().getDriver().getCurrentUrl().substring(15, 17), "ro");
                break;
            case "Russian" :
                Assert.assertEquals(testContext.getWebDriverManager().getDriver().getCurrentUrl().substring(15, 17), "ru");
                break;
            default :
                throw new IllegalArgumentException("This language does not supported");
        }

    }
}
