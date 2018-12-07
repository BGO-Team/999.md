package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import dataProviders.TestDataFileReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginFrame;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.Page;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoginFrameSteps {
    private TestContext testContext;
    private LoginFrame loginFrame;

    public LoginFrameSteps(TestContext context){
        testContext = context;
        loginFrame = (LoginFrame) Page.getPageObject("LoginFrame", testContext.getWebDriverManager().getDriver());
    }


    @And("^\"([^\"]*)\" user confirm Login and Password$")
    public void userConfirmLoginAndPassword(String user) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Assert.assertNotNull(loginFrame.getUsernameInput());
        Assert.assertNotNull(loginFrame.getPasswordInput());
        Assert.assertNotNull(loginFrame.getSubmitLoginButton());
        Assert.assertNotNull(loginFrame.getCloseLoginButton());

        String login = loginFrame.getUserLogin(user);
        String password = loginFrame.getUserPassword(user);

        loginFrame.loginAs(login, password);

        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().waitFor().until(ExpectedConditions.not(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt("topbar-popup")));
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
//        testContext.getWait().toBeVisible(testContext.getPageObjectManager().getHeader().getHeaderPicture());
    }

    @Then("^a new pop up window is displayed$")
    public void aNewPopUpWindowIsDisplayed(){
        testContext.getWait().waitFor().until(ExpectedConditions.visibilityOf(loginFrame.getFrameTitle()));
        Assert.assertEquals("popup-login-header-title",loginFrame.getFrameTitle().getAttribute("class"));
    }
}
