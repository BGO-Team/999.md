package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.dataProviders.TestDataFileReader;
import NineNineNine.pageObjects.Header;
import NineNineNine.pageObjects.Page;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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
                Assert.assertEquals(testContext.getWebDriverManager().getDriver().getCurrentUrl().substring(15, 17), "ro");
                break;
            case "Russian" :
                Assert.assertNotNull(testContext.getWebDriverManager().getDriver().findElement(
                        By.xpath("//meta[contains(@content,\"https://999.md/ru/\")]")));
                Assert.assertEquals(testContext.getWebDriverManager().getDriver().getCurrentUrl().substring(15, 17), "ru");

                break;
            default :
                throw new IllegalArgumentException("This language does not supported");
        }

    }

    @And("user go to FavoritesPage")
    public void userGoToFavoritesPage() {
        header.toFavorites();
    }
}
