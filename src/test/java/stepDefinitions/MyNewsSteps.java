package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataProviders.TestDataFileReader;
import enums.Context;
import org.junit.Assert;
import pageObjects.Header;
import pageObjects.MyNews;
import pageObjects.SubCategoryPage;

public class MyNewsSteps {

    private TestContext testContext;
    private MyNews myNews;
    private Header header;
    private SubCategoryPage subCategoryPage;

    public MyNewsSteps(TestContext context) {
        testContext = context;
        myNews = testContext.getPageObjectManager().getMyNews();
        header = testContext.getPageObjectManager().getHeader();
    }

    @Then("^user verify if his news is displayed in My News Page$")
    public void userVerifyIfHisNewsIsDisplayedInMyNewsPage() {
        header.myNews();
        Assert.assertTrue(myNews.newsAdded().equalsIgnoreCase(TestDataFileReader.getTitleNewsInput() +
                testContext.getScenarioContext().getContext(Context.TEXT).toString()));
        System.out.println(TestDataFileReader.getTitleNewsInput() +
                testContext.getScenarioContext().getContext(Context.TEXT).toString());
    }


    @And("^user click on news with name \"([^\"]*)\"$")
    public void userClickOnNEwsWithName(String newsName) {
        myNews.toProduct(newsName);
        testContext.getWebDriverManager().switchWindow();
    }
}