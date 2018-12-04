package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;

public class Hooks {
    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @After
    public void tearDown(){
        testContext.getWebDriverManager().getLoggerManager().close();
        testContext.getWebDriverManager().closeDriver();
    }
}
