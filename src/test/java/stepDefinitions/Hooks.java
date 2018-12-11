package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataProviders.TestDataFileWriter;

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
    public void setUp() {
//        TestDataFileWriter.WritePropertiesFile("testUserFirst", "qwerty123");
//        TestDataFileWriter.WritePropertiesFile("testUserSecond", "qwerty123");
//        TestDataFileWriter.WritePropertiesFile("testUserThird", "ProBook6570b");
    }

    @After
    public void tearDown(){
        testContext.getWebDriverManager().getLoggerUtil().close();
        testContext.getWebDriverManager().closeDriver();
    }
}
