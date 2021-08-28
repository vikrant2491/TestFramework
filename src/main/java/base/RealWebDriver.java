package base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealWebDriver {
	private static Logger logger = Logger.getLogger(RealWebDriver.class);
	private static WebDriver driver;
	private static RealWebDriver obj;
	
	private RealWebDriver(){
		logger.info("Initializing application driver");
		logger.info("Browser is: "+System.getProperty("browser"));
		logger.info("Browser is: "+System.getProperty("url"));
		String browser = System.getProperty("browser");
		switch (browser.toLowerCase()){
		case "chrome": 
			setdriverAschrome();
			break;
		case "ie":
			setDriverAsIE();
			break;
		default: logger.info("No browser is mentioned");
		}
		if(driver!=null){
			driver.get(System.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
	}
	
	public static WebDriver getDriver(){
		if(driver==null){
			synchronized (RealWebDriver.class){
				obj = new RealWebDriver();
			}
		}
		return driver;		
	}
	
	private void setdriverAschrome(){
		System.setProperty("webdriver.chrome.driver", "chromeDriver.exe");
		ChromeOptions opt = new ChromeOptions();
//		opt.addExtensions(new File(“path for crx file of the extension”));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.acceptInsecureCerts();		
		capabilities.setCapability(ChromeOptions.CAPABILITY, opt);
		driver = new ChromeDriver();
	}
	
	private void setDriverAsIE(){
		System.setProperty("webdriver.ie.driver", "");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("", "");
		driver = new InternetExplorerDriver(capabilities);
	}
	
	
	private void setDriverAsFirefox(){
		System.setProperty("driver.gecko.driver", "");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setAcceptInsecureCerts(true);
		capabilities.setCapability("", "");
		driver = new FirefoxDriver(capabilities);
	}
	
	private void setDriverAsEdge(){
		System.setProperty("webdriver.edge.driver", "");
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		capabilities.setCapability("", "");
		driver = new EdgeDriver(capabilities);
	}

}
