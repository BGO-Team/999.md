package NineNineNine.cucumber;

import NineNineNine.enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private Map<Context, Object> scenarioContext;

    private ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public static ScenarioContext getInstance(){
        if (instance == null)
            instance = new ScenarioContext();
        return instance;
    }

    public void setContext(Context key, Object value){
        scenarioContext.put(key, value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key);
    }

    public Boolean isCintains(Context key){
        return scenarioContext.containsKey(key);
    }

}
