package NineNineNine.cucumber;

import NineNineNine.enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private Map<Context, String> scenarioContext;

    private ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public static ScenarioContext getInstance(){
        if (instance == null)
            instance = new ScenarioContext();
        return instance;
    }

    public void setContext(Context key, String value){
        scenarioContext.put(key, value);
    }

    public String getContext(Context key){
        return scenarioContext.get(key);
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key);
    }

}
