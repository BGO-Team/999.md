package cucumber;

import utils.WebDriverManager;
import utils.WaitUtil;

public class TestContext {
    private WebDriverManager webDriverManager;
    private ScenarioContext scenarioContext;
    private WaitUtil waitUtil;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        scenarioContext = ScenarioContext.getInstance();
        waitUtil = WaitUtil.getInstance(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager(){
        return webDriverManager;
    }

    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }

    public WaitUtil getWait() {
        return waitUtil;
    }
}
 