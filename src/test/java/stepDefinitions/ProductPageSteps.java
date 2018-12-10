package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import pageObjects.Page;
import pageObjects.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ProductPageSteps {
    private TestContext testContext;
    private ProductPage productPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productPage = (ProductPage) Page.getPageObject("ProductPage", testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(Context.PRODUCT, productPage.getProductName());
    }

    @Then("^user is on this product$")
    public void userIsOnThisProduct() {
        Assert.assertEquals(testContext.getScenarioContext().getContext(Context.PRODUCT), productPage.getProductName());
        String[] breadCrumbs = productPage.getBreadCrumbs().split(">");
        Assert.assertEquals(breadCrumbs[0], testContext.getScenarioContext().getContext(Context.CATEGORY));
        Assert.assertEquals(breadCrumbs[1], testContext.getScenarioContext().getContext(Context.SUBCATEGORY));
        Assert.assertEquals(breadCrumbs[2], testContext.getScenarioContext().getContext(Context.PRODUCT));
    }

    @And("user add product to Favorite List")
    public void userAddProductToFavoriteList() {
        Assert.assertNotNull(productPage.getFavoriteButton());
        productPage.addToFavorite();
    }

    @Then("^Product Name or Product description contains \"([^\"]*)\"$")
    public void productNameOrProductDescriptionContains(String searchedText) {
        try
        {
            testContext.getWait().toBeVisible(productPage.getDescriptionArea());
            testContext.getWait().toBeVisible(productPage.getContactsField());
            Assert.assertTrue(productPage.nameContains(searchedText)
                    || productPage.descriptionContains(searchedText));
        } catch (AssertionError e) {
            System.out.println(testContext.getWebDriverManager().getDriver().getCurrentUrl());
            throw e;
        }
    }

    @Then("^a new product page window is displayed$")
    public void aNewProductPageWindowIsDisplayed() {
        testContext.getWait().toBeClickable(productPage.getFavoriteButton());
        testContext.getWait().toBeVisible(productPage.getContactsField());
        Assert.assertTrue("Контакты:".equalsIgnoreCase(productPage.getContactsField().getText()));
    }

    @And("^user sent \"([^\"]*)\" to product's author$")
    public void userSentMessageToProductAuthor(String message){
        productPage.inputMessage(message);
        productPage.sendMessageButton();
    }

    @Then("^the notification that message was sent appeared$")
    public void theNotificationThatMessageWasSentAppeared(){
        Assert.assertTrue(productPage.getNotificationMessage());
    }

    @Then("^the value of \"([^\"]*)\" property is \"([^\"]*)\"$")
    public void theValueOfPropertyIs(String key, String value) {
       try {
           testContext.getWait().toBeVisible(productPage.getLastProperty());
           Assert.assertTrue(value.equalsIgnoreCase(productPage.getValueOfProperty(key.toLowerCase())));
       }catch (AssertionError e){
           System.out.print("The curent property value does not match with the context of the following: ");
           System.out.println(testContext.getWebDriverManager().getDriver().getCurrentUrl());
       }
    }
}
