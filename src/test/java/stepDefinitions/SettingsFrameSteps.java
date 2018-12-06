package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import org.junit.Assert;
import pageObjects.SettingsFrame;

public class SettingsFrameSteps {
    private TestContext testContext;
    private SettingsFrame settingsFrame;

    public SettingsFrameSteps(TestContext context) {
        testContext = context;
        settingsFrame = testContext.getPageObjectManager().getSettingsFramePage();
    }

    @Then("^a settings frame is opened$")
    public void aSettingsFrameIsOpened() {
        settingsFrame.changeFrame();
        testContext.getWait().toBeClickable(settingsFrame.getSaveButton());
        Assert.assertTrue(settingsFrame.getSaveButton().getText().equalsIgnoreCase("сохранить"));
        testContext.getScenarioContext().setContext(Context.PAGE,"SettingsFrame");
        testContext.getScenarioContext().setContext(Context.CLASSOBJECT,settingsFrame);
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
}
