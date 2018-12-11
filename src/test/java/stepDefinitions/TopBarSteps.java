package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Page;
import pageObjects.TopBar;

import java.lang.reflect.Method;

public class TopBarSteps {
    private TestContext testContext;
    private TopBar topBar;

    public TopBarSteps(TestContext context) {
        testContext = context;
        topBar = (TopBar) Page.getPageObject("TopBar", testContext.getWebDriverManager().getDriver());
    }

    @Then("^\"([^\"]*)\" User Name is shown on Top Bar$")
    public void userNameIsShowingOnTopBar(String user) throws Throwable {
        topBar.toTopBar();
        Method getUserLogin = Class.forName("dataProviders.TestDataFileReader").getDeclaredMethod("getUserLogin", String.class);
        String login = (String) getUserLogin.invoke(Class.forName("dataProviders.TestDataFileReader"), user);
        Assert.assertEquals(login, topBar.getUserName());
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
    }

    @When("^user changes language$")
    public void userChangeLanguage() {
        Assert.assertNotNull(topBar.getLanguageButton());
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
            default:
                throw new IllegalArgumentException("This language does not supported");
        }
    }

    @And("^user clicks on message button$")
    public void userClicksOnMessageButton() {
        testContext.getWait().toBeVisible(topBar.getLanguageButton());
        topBar.clickMessagesButton();
        Assert.assertTrue(topBar.getLanguageButton().isDisplayed());
    }
}
