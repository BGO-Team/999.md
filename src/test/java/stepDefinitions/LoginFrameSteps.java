package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
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

    @And("^user fill in Login and Password Input field as Corneliu and click Submit$")
    public void userFillInLoginAndPasswordInputFieldAsCorneliu() {
        loginFrame.loginAs(TestDataFileReader.getUser2Login(), TestDataFileReader.getUser2Password());
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().waitFor().until(ExpectedConditions.not(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topbar-popup")));
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().toBeVisible(testContext.getPageObjectManager().getHeader().getHeaderPicture());
    }

    @Then("^a new pop up window is displayed$")
    public void aNewPopUpWindowIsDisplayed(){

        testContext.getWait().waitFor().until(ExpectedConditions.visibilityOf(loginFrame.getFrameTitle()));
        Assert.assertEquals("popup-login-header-title",loginFrame.getFrameTitle().getAttribute("class"));

    }
}
