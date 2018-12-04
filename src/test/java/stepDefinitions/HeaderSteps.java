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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderSteps {
    private TestContext testContext;
    private Header header;

    public HeaderSteps(TestContext context){
        testContext = context;
        header = testContext.getPageObjectManager().getHeader();
    }

    //TODO: HeaderSteps



    @And("user go to FavoritesPage")
    public void userGoToFavoritesPage() {
        header.toFavorites();
    }
}
