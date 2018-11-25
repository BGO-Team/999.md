package DesignPatternsTask;

import NineNineNine.pageObjects.LoginFrame;
import NineNineNine.pageObjects.TopBar;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DesignPatternsTask {

    private WebDriver driver;
    private TopBar topBar;
    private LoginFrame loginFrame;

    @Given("User is on {string} page")
    public void userIsOnPage(final String URL) {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get(URL);
    }

    @When("User move to Top Bar")
    public void userMoveToTopBar() {
        topBar = TopBar.getInstance(driver);
    }

    @When("User click Log In button")
    public void userClickLogInButton() {
        loginFrame = topBar.toLoginFrame();
    }

    @Then("should be displayed {string}, {string} fields")
    public void shouldBeDisplayedFields(String firstField, String secondField) {
        Assert.assertTrue(driver.findElement(By.name(firstField)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name(secondField)).isDisplayed());
        loginFrame.closeLoginFrame();
        driver.close();
    }
}
