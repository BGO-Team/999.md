package cucumber;

import dataProviders.TestDataFileReader;
import managers.PageObjectManager;
import managers.WebDriverManager;
import managers.WaitManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;
    private TestDataFileReader testDataFileReader;
    private WaitManager wait;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        scenarioContext = ScenarioContext.getInstance();
        testDataFileReader = new TestDataFileReader();
        wait = new WaitManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager(){
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }

    public TestDataFileReader getTestDataFileReader(){
        return testDataFileReader;
    }

    public WaitManager getWait() {
        return wait;
    }
}
 