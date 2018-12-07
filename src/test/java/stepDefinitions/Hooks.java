package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){
        testContext.getWebDriverManager().getLoggerUtil().close();
        testContext.getWebDriverManager().closeDriver();
    }
}
