package stepDefinitions;

import NineNineNine.cucumber.TestContext;
import NineNineNine.pageObjects.Header;

public class HeaderSteps {
    private TestContext testContext;
    private Header header;

    public HeaderSteps(TestContext context){
        testContext = context;
        header = testContext.getPageObjectManager().getHeader();
    }

    //TODO: HeaderSteps
}
