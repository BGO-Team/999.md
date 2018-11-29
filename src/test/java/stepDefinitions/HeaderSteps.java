package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.dataProviders.TestDataFileReader;
import NineNineNine.pageObjects.Header;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderSteps {
    private TestContext testContext;
    private Header header;

    public HeaderSteps(TestContext context){
        testContext = context;
        header = testContext.getPageObjectManager().getHeader();
    }

    //TODO: HeaderSteps

    @Then("^language was changed on \"([^\"]*)\"$")
    public void languageWasChangedOn(String language) {
        switch (language){
            case "Romanian" :
                Assert.assertNotNull(testContext.getWebDriverManager().getDriver().findElement(
                        By.xpath("//meta[contains(@content,\"https://999.md/ro/\")]")));
                break;
            case "Russian" :
                Assert.assertNotNull(testContext.getWebDriverManager().getDriver().findElement(
                        By.xpath("//meta[contains(@content,\"https://999.md/ru/\")]")));
                break;
            default :
                throw new IllegalArgumentException("This language does not supported");
        }

    }
}
