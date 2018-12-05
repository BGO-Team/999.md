package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import dataProviders.TestDataFileReader;
import pageObjects.AddNewsPage;

public class AddNewsPageSteps {

        private TestContext testContext;
        private AddNewsPage addNewsPage;

        public AddNewsPageSteps(TestContext context) {
            testContext = context;
            addNewsPage = testContext.getPageObjectManager().getAddNewsPage();
        }

        //TODO: AddNewsPageSteps


    @When("^user is on Add a new news page$")
    public void userIsOnAddANewNewsPage(){
        addNewsPage.toNewsPage();
    }


    @And("^user add a new news$")
    public void userAddANewNews() throws InterruptedException {
         addNewsPage.clickCategoryTypeNewsMenu();
         addNewsPage.choseCategoryTell();
        Thread.sleep(3000);
         addNewsPage.clickSubCategoryButton();
         addNewsPage.choseAccesSubCategory();
        Thread.sleep(3000);
         addNewsPage.clickTypeSellBuyButton();
         addNewsPage.choseSellType();
        Thread.sleep(3000);
         addNewsPage.clickRegionButton();
         addNewsPage.choseChisinauRegion();
        Thread.sleep(3000);
         addNewsPage.clickNegotiablePriceCheckBox();
         addNewsPage.titleNewsInput(TestDataFileReader.getTitleNewsInput());
         addNewsPage.infoNewsInput(TestDataFileReader.getInfoNewsInput());
         addNewsPage.clickAgreeRulesCheckBox();
         addNewsPage.submitNewsButton();
    }
}
