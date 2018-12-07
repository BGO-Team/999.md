package cucumber;

import utils.PageObjectManager;
import utils.WebDriverManager;
import utils.WaitUtil;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;
    private WaitUtil wait;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        scenarioContext = ScenarioContext.getInstance();
        wait = new WaitUtil(webDriverManager.getDriver());
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

    public WaitUtil getWait() {
        return wait;
    }
}
 