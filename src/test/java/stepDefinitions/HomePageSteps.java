package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import pageObjects.HomePage;
import cucumber.api.java.en.When;
import utils.PageObjectManager;

import java.lang.reflect.InvocationTargetException;

public class HomePageSteps{
    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        testContext = context;
        homePage = (HomePage) PageObjectManager.getClass(String.valueOf(HomePage.class),
                testContext.getWebDriverManager().getDriver());
    }

    @When("^user click on \"([^\"]*)\" category$")
    public void userClickOnCategory(String category) {
        homePage.toCategory(category);
        testContext.getScenarioContext().setContext(Context.CATEGORY, category);
    }
}
