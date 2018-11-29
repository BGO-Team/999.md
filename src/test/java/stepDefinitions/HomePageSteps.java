package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.dataProviders.TestDataFileReader;
import NineNineNine.pageObjects.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class HomePageSteps {
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context){
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    //TODO: HomePageSteps

    @When("^user click on \"([^\"]*)\" category$")
    public void userClickOnCategory(String category) {
        if (category.equals("Random")) {
            Random random = new Random();
            int randomCategory = random.nextInt(testContext.getPageObjectManager().getHomePage().category.size()) + 1;
            homePage.toCategory(randomCategory);
        }
        else {

        }

    }

}
