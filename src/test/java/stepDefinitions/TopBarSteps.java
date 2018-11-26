package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.pageObjects.TopBar;

public class TopBarSteps {
    private TestContext testContext;
    private TopBar topBar;

    public TopBarSteps(TestContext context){
        testContext = context;
        topBar = testContext.getPageObjectManager().getTopBar();
    }

    //TODO: TopBarSteps
}
