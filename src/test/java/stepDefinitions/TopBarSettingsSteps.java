package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import dataProviders.TestDataFileReader;
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
    @Then("^user verify \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userVerifyIfFirstnameAndSecondnameAreTheSame() {
        Assert.assertEquals(TestDataFileReader.getFirstName(), topBarSettings.firstnameVerify());
        System.out.println(topBarSettings.firstnameVerify());
        Assert.assertEquals(TestDataFileReader.getLastName(), topBarSettings.lastnameVerify());
        System.out.println(topBarSettings.lastnameVerify());
        topBarSettings.emailSettings();
        Assert.assertEquals(TestDataFileReader.getEmailAdress(), topBarSettings.emailVerify());
        System.out.println(topBarSettings.emailVerify());

    }


}
