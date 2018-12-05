package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import dataProviders.TestDataFileReader;
import org.junit.Assert;
import pageObjects.LoginFrame;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFrameSteps {
    private TestContext testContext;
    private LoginFrame loginFrame;

    public LoginFrameSteps(TestContext context){
        testContext = context;
        loginFrame = testContext.getPageObjectManager().getLoginFrame();
    }

    @And("^user confirm Login and Password$")
    public void userFillInLoginAndPasswordInputField() {
        Assert.assertNotNull(loginFrame.getUsernameInput());
        Assert.assertNotNull(loginFrame.getPasswordInput());
        Assert.assertNotNull(loginFrame.getSubmitLoginButton());
        Assert.assertNotNull(loginFrame.getCloseLoginButton());
        loginFrame.loginAs(TestDataFileReader.getUserLogin(), TestDataFileReader.getUserPassword());
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().waitFor().until(ExpectedConditions.not(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topbar-popup")));
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().toBeVisible(testContext.getPageObjectManager().getHeader().getHeaderPicture());
    }
}
