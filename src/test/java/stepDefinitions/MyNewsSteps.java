package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import dataProviders.TestDataFileReader;
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

    //TODO: HeaderSteps


    @Then("^user verify if his news is displayed in My News Page$")
    public void userVerifyIfHisNewsIsDisplayedInMyNewsPage() {
        header.myNews();
        Assert.assertEquals(myNews.newsAdded(),TestDataFileReader.getTitleNewsInput() + myNews.timeTitle());
        System.out.println(" The news " + TestDataFileReader.getTitleNewsInput() + myNews.timeTitle() + " is displayed ");
    }


    @And("^user click on news \"([^\"]*)\"$")
    public void userClickOnNewsThatWasAlreadyCreated(String newsName) {

//        myNews.findMyNews();
        myNews.toProduct(newsName);

    }
}