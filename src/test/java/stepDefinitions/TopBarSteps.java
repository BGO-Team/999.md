package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Page;
import pageObjects.TopBar;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.lang.reflect.Method;

public class TopBarSteps {
    private TestContext testContext;
    private TopBar topBar;

    public TopBarSteps(TestContext context){
        testContext = context;
        topBar = (TopBar) Page.getPageObject("TopBar",testContext.getWebDriverManager().getDriver());
    }

    @Then("^\"([^\"]*)\" User Name is showing on Top Bar$")
    public void userNameIsShowingOnTopBar(String user) throws Throwable {
        topBar.toTopBar();
        Class clazz = Class.forName("dataProviders.TestDataFileReader");
        Method getUserLogin = clazz.getDeclaredMethod("getUserLogin", String.class);
        String login = (String) getUserLogin.invoke(clazz, user);
        Assert.assertEquals(login, topBar.getUserName());
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
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
}
