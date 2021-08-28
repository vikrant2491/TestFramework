package stepDefs;



import org.apache.log4j.Logger;

import TestObjects.HomePage_TO;
import cucumber.api.java.en.Given;

public class Steps {
	private static Logger logger = Logger.getLogger(Steps.class);
	
	@Given("^User search for \"([^\"]*)\" item$")
	public void entertext(String arg1) throws Throwable {
		HomePage_TO homePage = new HomePage_TO();
		homePage.searchText(arg1);
	}

}
