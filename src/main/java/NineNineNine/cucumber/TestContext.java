package NineNineNine.cucumber;

import NineNineNine.managers.PageObjectManager;
import NineNineNine.managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        scenarioContext = ScenarioContext.getInstance();
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
}
 