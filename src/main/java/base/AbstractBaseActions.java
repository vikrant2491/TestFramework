package base;

import org.apache.log4j.Logger;

import cucumber.api.Scenario;


public class AbstractBaseActions {
	private static Logger logger = Logger.getLogger(AbstractBaseActions.class);
	
	
	public void setUp(){
		logger.info("******************************************");
		logger.info("*********Initializing Testframework****");
		logger.info("******************************************");
		Constants.driver = RealWebDriver.getDriver();
		
	}
	
	public void beforeScenarioAction(Scenario scenario){
//		logger.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logger.info("Executing test scenario"+scenario.getName());	
//		logger.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	
	public void afterScenarioAction(Scenario scenario){
//		logger.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		logger.info("Ending test scenario"+scenario.getName());	
//		logger.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	
	public void tearDown(){
		logger.info("******************************************");
		logger.info("*********Finalizing Testframework****");
		logger.info("******************************************");
		if(Constants.driver!=null){
			Constants.driver.quit();
		}
		
	}

}
