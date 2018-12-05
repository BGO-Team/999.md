package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import dataProviders.TestDataFileReader;
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

    @And("^user fill in Login and Password Input field and click Submit$")
    public void userFillInLoginAndPasswordInputField() {
        loginFrame.loginAs(TestDataFileReader.getUserLogin(), TestDataFileReader.getUserPassword());
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().waitFor().until(ExpectedConditions.not(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topbar-popup")));
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().toBeVisible(testContext.getPageObjectManager().getHeader().getHeaderPicture());
    }

    @And("^user fill in Login and Password Input field as Corneliu and click Submit$")
    public void userFillInLoginAndPasswordInputFieldAsCorneliu() {
        loginFrame.loginAs(TestDataFileReader.getUser2Login(), TestDataFileReader.getUser2Password());
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().waitFor().until(ExpectedConditions.not(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topbar-popup")));
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().toBeVisible(testContext.getPageObjectManager().getHeader().getHeaderPicture());
    }

}
