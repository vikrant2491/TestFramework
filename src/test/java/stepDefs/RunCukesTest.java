package stepDefs;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.AbstractBaseActions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty", "html:target/cucumber/htmlReport", "json:target/cucumber/CucumberTestReport.json"},
		features="src/test/resources/tests",
		glue="stepDefs",
		dryRun=false
//		,tags="@tag1"
)
public class RunCukesTest {
	private TestNGCucumberRunner testRunner;
	AbstractBaseActions base = new AbstractBaseActions();
	@BeforeClass(alwaysRun=true)
	public void setUp(){
		testRunner = new TestNGCucumberRunner(RunCukesTest.class);
		base.setUp();
	}
	
	@DataProvider
	public Object[][] Features(){
		return testRunner.provideFeatures();
	}
	
	@Test(groups="cucumber", dataProvider="Features")
	public void runTests(CucumberFeatureWrapper feature){		
		testRunner.runCucumber(feature.getCucumberFeature());		
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown(){
		base.tearDown();
		testRunner.finish();
	}

}
