package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.TopBarSettings;

public class TopBarSettingsSteps {

    private TestContext testContext;
    private TopBarSettings topBarSettings;

    public TopBarSettingsSteps(TestContext context) {
        testContext = context;
        topBarSettings = testContext.getPageObjectManager().getTopBarSettings();
    }

    //TODO: TopBarSettingsSteps
    @Then("^user verify firstname and lastname$")
    public void userVerifyIfFirstnameAndSecondnameAreTheSame() {
        Assert.assertEquals("Corneliu",topBarSettings.firstnameVerify());
        System.out.println(topBarSettings.firstnameVerify());
        Assert.assertEquals("Ciorici",topBarSettings.lastnameVerify());
        System.out.println(topBarSettings.lastnameVerify());

    }

    @And("^user verify email adress$")
    public void userVerifyEmailAdress(){

        topBarSettings.emailSettings();
        Assert.assertEquals("cciorici@inbox.ru",topBarSettings.emailVerify());
        System.out.println(topBarSettings.emailVerify());
    }

}
