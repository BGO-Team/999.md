package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ChatFrame;
import pageObjects.Page;

public class ChatFrameSteps {
    private TestContext testContext;
    private ChatFrame chatFrame;

    public ChatFrameSteps(TestContext context) {
        testContext = context;
        chatFrame = (ChatFrame) Page.getPageObject("ChatFrame", testContext.getWebDriverManager().getDriver());
    }

    @When("^user go to the ChatFrame$")
    public void userGoToTheChatFrame() {
        testContext.getScenarioContext().setContext(Context.PAGE,"ChatFrame");
        chatFrame.toChatFrame();
        testContext.getWait().toBeClickable(chatFrame.getSentMessage());
    }
}
