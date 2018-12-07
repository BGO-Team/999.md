package stepDefinitions;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.PageObjectManager;
import utils.WaitUtil;
import utils.WebDriverManager;

public class Hooks {
//    private WebDriverManager webDriverManager;
//    private PageObjectManager pageObjectManager;
//    private ScenarioContext scenarioContext;
//    private WaitUtil waitUtil;
    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    //TODO: hooks

    @Before
    public void setUp(){
//        webDriverManager = new WebDriverManager();
//        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
//        scenarioContext = ScenarioContext.getInstance();
//        waitUtil = WaitUtil.getInstance(webDriverManager.getDriver());
    }

    @After
    public void tearDown(){
        testContext.getWebDriverManager().getLoggerUtil().close();
        testContext.getWebDriverManager().closeDriver();
    }
}
