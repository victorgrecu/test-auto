package com.worldpay.steps;

import com.worldpay.beans.ScenarioContext;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
    @Autowired
    private ScenarioContext scenarioContext;

    @Before
    public void resetScenarioContext(){
        scenarioContext.reset();
    }
}
