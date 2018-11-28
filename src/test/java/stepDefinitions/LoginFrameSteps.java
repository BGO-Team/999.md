package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.dataProviders.TestDataFileReader;
import NineNineNine.pageObjects.LoginFrame;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class LoginFrameSteps {
    private TestContext testContext;
    private LoginFrame loginFrame;

    public LoginFrameSteps(TestContext context){
        testContext = context;
        loginFrame = testContext.getPageObjectManager().getLoginFrame();
    }

    //TODO: LoginFrameSteps

    @And("^user fill in Login and Password Input field and click Submit$")
    public void userFillInLoginAndPasswordInputField() {
        loginFrame.loginAs(TestDataFileReader.getUserLogin(), TestDataFileReader.getUserPassword());
    }

}
