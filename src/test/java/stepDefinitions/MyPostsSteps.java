package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataProviders.TestDataFileReader;
import enums.Context;
import org.junit.Assert;
import pageObjects.MyPosts;
import pageObjects.Page;

public class MyPostsSteps {

    private TestContext testContext;
    private MyPosts myPosts;

    public MyPostsSteps(TestContext context) {
        testContext = context;
        myPosts = (MyPosts) Page.getPageObject("MyPosts", testContext.getWebDriverManager().getDriver());
    }

    @Then("^user verify if his post is displayed in My Posts Page$")
    public void userVerifyIfHisPostIsDisplayedInMyPostsPage() {
        Assert.assertTrue(myPosts.newsAdded().equalsIgnoreCase(TestDataFileReader.getTitleNewsInput() +
                testContext.getScenarioContext().getContext(Context.TEXT).toString()));
        System.out.println(TestDataFileReader.getTitleNewsInput() +
                testContext.getScenarioContext().getContext(Context.TEXT).toString());
    }


    @And("^user click on news with name \"([^\"]*)\"$")
    public void userClickOnNEwsWithName(String newsName) {
        myPosts.toProduct(newsName);
        testContext.getWebDriverManager().switchWindow();
    }
}