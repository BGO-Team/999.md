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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoginFrameSteps {
    private TestContext testContext;
    private LoginFrame loginFrame;

    public LoginFrameSteps(TestContext context){
        testContext = context;
        loginFrame = testContext.getPageObjectManager().getLoginFrame();
    }


    @And("^\"([^\"]*)\" user confirm Login and Password$")
    public void userConfirmLoginAndPassword(String user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Assert.assertNotNull(loginFrame.getUsernameInput());
        Assert.assertNotNull(loginFrame.getPasswordInput());
        Assert.assertNotNull(loginFrame.getSubmitLoginButton());
        Assert.assertNotNull(loginFrame.getCloseLoginButton());

        Class clazz = Class.forName("dataProviders.TestDataFileReader");
        Method getUserLogin = clazz.getDeclaredMethod("getUserLogin", String.class);
        String login = (String) getUserLogin.invoke(clazz, user);

        Method getUserPassword = clazz.getDeclaredMethod("getUserPassword", String.class);
        String password = (String) getUserPassword.invoke(clazz, user);

        loginFrame.loginAs(login, password);

        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().waitFor().until(ExpectedConditions.not(ExpectedConditions.frameToBeAvailableAndSwitchToIt("topbar-popup")));
        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        testContext.getWait().toBeVisible(testContext.getPageObjectManager().getHeader().getHeaderPicture());
    }

    @Then("^a login frame is displayed$")
    public void aNewPopUpWindowIsDisplayed(){

        testContext.getWait().waitFor().until(ExpectedConditions.visibilityOf(loginFrame.getFrameTitle()));
        Assert.assertEquals("popup-login-header-title",loginFrame.getFrameTitle().getAttribute("class"));
    }
}
