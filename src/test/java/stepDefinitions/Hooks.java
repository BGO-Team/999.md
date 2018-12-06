package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.LoggerManager;

import java.io.File;

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
        testContext.getWebDriverManager().getLoggerManager().close();
        testContext.getWebDriverManager().closeDriver();
    }
}
