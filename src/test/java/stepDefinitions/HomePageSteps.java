package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.dataProviders.TestDataFileReader;
import NineNineNine.enums.Context;
import NineNineNine.managers.WebDriverManager;
import NineNineNine.pageObjects.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class HomePageSteps extends Throwable{
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context){
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    //TODO: HomePageSteps

    @When("^user click on \"([^\"]*)\" category$")
    public void userClickOnCategory(String category) {
        homePage.toCategory(category);
    }
}
