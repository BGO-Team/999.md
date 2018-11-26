package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.pageObjects.LoginFrame;

public class LoginFrameSteps {
    private TestContext testContext;
    private LoginFrame loginFrame;

    public LoginFrameSteps(TestContext context){
        testContext = context;
        loginFrame = testContext.getPageObjectManager().getLoginFrame();
    }

    //TODO: LoginFrameSteps
}
