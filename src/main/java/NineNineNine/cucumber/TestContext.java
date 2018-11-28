package NineNineNine.cucumber;

import NineNineNine.dataProviders.ConfigFileReader;
import NineNineNine.dataProviders.TestDataFileReader;
import NineNineNine.managers.PageObjectManager;
import NineNineNine.managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;
    private ConfigFileReader configFileReader;
    private TestDataFileReader testDataFileReader;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        scenarioContext = ScenarioContext.getInstance();
        configFileReader = new ConfigFileReader();
        testDataFileReader = new TestDataFileReader();
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

    public ConfigFileReader getConfigFileReader(){
        return configFileReader;
    }

    public TestDataFileReader getTestDataFileReader(){
        return testDataFileReader;
    }
}
 