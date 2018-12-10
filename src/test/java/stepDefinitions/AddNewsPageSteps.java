package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import dataProviders.TestDataFileReader;
import enums.Context;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AddNewsPage;
import pageObjects.MyNews;
import pageObjects.Page;

import java.lang.reflect.InvocationTargetException;

public class AddNewsPageSteps {

    private TestContext testContext;
    private AddNewsPage addNewsPage;
    private MyNews myNews;


    public AddNewsPageSteps(TestContext context) {
        testContext = context;
        addNewsPage = (AddNewsPage) Page.getPageObject("AddNewsPage", testContext.getWebDriverManager().getDriver());
    }

    @When("^user is on Add a new news page$")
    public void userIsOnAddANewNewsPage() {
        addNewsPage.toNewsPage();
    }


    @And("^user add a new post with accessories for telephone$")
    public void userAddANewPostWithAccessiriesFirTelephone() {
        addNewsPage.choseCategory("Телефоны и связь");
        testContext.getScenarioContext().setContext(Context.CATEGORY, "Телефоны и связь");
        testContext.getWait().waitFor().until(ExpectedConditions.urlContains("phone-and-communication"));
        addNewsPage.choseSubCategory("Аксессуары");
        testContext.getScenarioContext().setContext(Context.SUBCATEGORY, "Аксессуары");
        testContext.getWait().waitFor().until(ExpectedConditions.urlContains("2Faccessories"));
        addNewsPage.choseSellType("Random");
        testContext.getScenarioContext().setContext(Context.SELLTYPE, "Random");
        testContext.getWait().waitFor().until(ExpectedConditions.urlContains("77"));
        addNewsPage.choseCountry("Random");
        testContext.getScenarioContext().setContext(Context.COUNTRY, "Random");
        addNewsPage.clickNegotiablePriceCheckBox();
        testContext.getScenarioContext().setContext(Context.TEXT,myNews.timeTitle());
        addNewsPage.titleNewsInput(TestDataFileReader.getTitleNewsInput() +
                testContext.getScenarioContext().getContext(Context.TEXT).toString());
        addNewsPage.infoNewsInput(TestDataFileReader.getInfoNewsInput());
        addNewsPage.clickAgreeRulesCheckBox();
        addNewsPage.submitNewsButton();
    }
}
