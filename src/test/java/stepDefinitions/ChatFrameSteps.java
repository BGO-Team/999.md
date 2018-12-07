package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ChatFrame;

public class ChatFrameSteps {
    private TestContext testContext;
    private ChatFrame chatFrame;

    public ChatFrameSteps(TestContext context) {
        testContext = context;
        chatFrame = testContext.getPageObjectManager().getChatFrame();
    }

    @When("^user go to the ChatFrame$")
    public void userGoToTheChatFrame() {
        testContext.getScenarioContext().setContext(Context.PAGE,"ChatFrame");
        testContext.getScenarioContext().setContext(Context.CLASSOBJECT, testContext.getPageObjectManager().getChatFrame());
        testContext.getPageObjectManager().getChatFrame().toChatFrame();
        testContext.getWait().toBeClickable(testContext.getPageObjectManager().getChatFrame().getSentMessage());
    }
}
