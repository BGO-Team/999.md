package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.pageObjects.HomePage;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageSteps{
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context){
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    //TODO: HomePageSteps

    @When("^user click on \"([^\"]*)\" category$")
    public void userClickOnCategory(String category) {
//        testContext.getWebDriverManager().getDriver().switchTo().defaultContent();
        homePage.toCategory(category);
    }
}
