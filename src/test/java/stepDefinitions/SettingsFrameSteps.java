package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import dataProviders.TestDataFileReader;
import gherkin.lexer.Pa;
import org.junit.Assert;
import pageObjects.Page;
import pageObjects.SettingsFrame;

public class SettingsFrameSteps {
    private TestContext testContext;
    private SettingsFrame settingsFrame;

    public SettingsFrameSteps(TestContext context) {
        testContext = context;
        settingsFrame = (SettingsFrame) Page.getPageObject("SettingsFrame", testContext.getWebDriverManager().getDriver());
    }

    @Then("^a settings frame is opened$")
    public void aSettingsFrameIsOpened() {
        settingsFrame.changeFrame();
        testContext.getWait().toBeClickable(settingsFrame.getSaveButton());
        Assert.assertTrue(settingsFrame.getSaveButton().getText().equalsIgnoreCase("сохранить"));
        testContext.getScenarioContext().setContext(Context.PAGE,"SettingsFrame");
    }

    @When("^user inserts \"(.+?)\" and \"(.+?)\"$")
    public void userInsertsAnd(String firstName, String lastName) {
        settingsFrame.setNameDetails(firstName, lastName);
    }

    @And("^insert the folowing \"(.+?)\" \"(.+?)\" \"(.+?)\" birth details$")
    public void insertTheFolowingBirthday(String day, String month, String year) {
        settingsFrame.setBirthDay(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
    }

    @Then("^The data is saved$")
    public void theDataIsSaved() {
        Assert.assertTrue(settingsFrame.getSuccessMessage().equalsIgnoreCase("СОХРАНЕНО"));
    }

    @And("^set the gender to \"([^\"]*)\"$")
    public void setTheGenderTo(String gender) {
        settingsFrame.selectGender(gender);
    }

    @Then("^new details are not saved$")
    public void newDetailsAreNotSaved() {
        Assert.assertFalse(settingsFrame.getSuccessMessage().equalsIgnoreCase("СОХРАНЕНО"));
    }

    @Then("^user verify his details$")
    public void userVerifyHisDetails() {
        Assert.assertEquals(TestDataFileReader.getFirstName(), settingsFrame.firstnameVerify());
        System.out.println(settingsFrame.firstnameVerify());
        Assert.assertEquals(TestDataFileReader.getLastName(), settingsFrame.lastnameVerify());
        System.out.println(settingsFrame.lastnameVerify());
        settingsFrame.emailSettings();
        Assert.assertEquals(TestDataFileReader.getEmailAdress(), settingsFrame.emailVerify());
        System.out.println(settingsFrame.emailVerify());
    }

    @Then("^user verify the incoming \"([^\"]*)\"$")
    public void userVerifyTheIncoming(String message){
        Assert.assertEquals(message, settingsFrame.getIncomingMessage());
    }

    @Then("^user verify the sent \"([^\"]*)\"$")
    public void userVerifyTheSentMessage(String message){
        Assert.assertEquals(message, settingsFrame.getSentMessage());
    }
}
