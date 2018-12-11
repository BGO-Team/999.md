package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.io.IOException;

import static dataProviders.TestDataFileWriter.WritePropertiesFile;

public class Hooks {
//    private WebDriverManager webDriverManager;
//    private PageObjectManager pageObjectManager;
//    private ScenarioContext scenarioContext;
//    private WaitUtil waitUtil;
    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }


    @Before
    public void setUp() throws IOException {

    }

    @After
    public void tearDown(){
        testContext.getWebDriverManager().getLoggerUtil().close();
        testContext.getWebDriverManager().closeDriver();
    }
}
