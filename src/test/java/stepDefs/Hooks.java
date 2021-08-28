package stepDefs;

import base.AbstractBaseActions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	AbstractBaseActions base = new AbstractBaseActions();
	@Before
	public void beforeAction(Scenario scenario){
		base.beforeScenarioAction(scenario);
	}
	
	@After
	public void afterScenario(Scenario scenario){
		base.afterScenarioAction(scenario);
	}

}
