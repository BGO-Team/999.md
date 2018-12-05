package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import dataProviders.TestDataFileReader;
import org.junit.Assert;
import pageObjects.MyNews;

public class MyNewsSteps {

    private TestContext testContext;
    private MyNews myNews;

    public MyNewsSteps(TestContext context) {
        testContext = context;
        myNews = testContext.getPageObjectManager().getMyNews();
    }

    //TODO: HeaderSteps


    @And("^user verify if his news is displayed in My News Page$")
    public void userVerifyIfHisNewsIsDisplayedInMyNewsPage() {

        Assert.assertTrue(myNews.newsAdded());
        System.out.println( " The news " + TestDataFileReader.getTitleNewsInput() + " is displayed " + myNews.newsAdded());
    }


    @And("^user click on news that was already created$")
    public void userClickOnNewsThatWasAlreadyCreated(){

        myNews.findMyNews();

    }
}