package stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforeScenario(){
        System.out.println("Scenario start");
    }

    @After
    public void afterScenario(){
        System.out.println("Scenario End");
    }
}
