package base;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AmazonTabs {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("driver.chrome.webdriver", "chromedriver.exe");
		
		//Extension code
		ChromeOptions opt1 = new ChromeOptions();
		opt1.addExtensions(new File(""));
		
		//Add arguments - Give a custom profile
		ChromeOptions opt2 = new ChromeOptions();
		opt2.addArguments("user-data-dir=pathToProfile");
		
		//start-maximized
		opt2.addArguments("start-maximized");
		opt2.addArguments("--headless");
		opt2.addArguments("--disable-gpu");
		opt2.addArguments("--allow-insecure-localhost");
		opt2.addArguments("--lang=fr-CA");
		opt2.addArguments("disable-infobars");
		opt2.addArguments("Make-default-browser");
		opt2.addArguments("Incognito");
		opt2.addArguments("Disable-popup-blocking");
		
		//load extension with arguments
		opt2.addArguments("load-extension=/path/to/extension");
		
		// For insecure certs
		opt2.setAcceptInsecureCerts(true);
		
		//Alerts
		opt2.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		//download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "");
		opt2.setExperimentalOption("prefs", prefs);
		
		//disable popup blocking
		opt2.setExperimentalOption("excludeSwitches",
			    Arrays.asList("disable-popup-blocking"));
		
		//Set binary
		opt2.setBinary("/path/to/other/chrome/binary");
		
		// Add the WebDriver proxy capability.
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("myhttpproxy:3337");
		opt2.setCapability("proxy", proxy);
		
		//set headless
		opt2.setHeadless(true);
		
		//Set webdriver with service
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeDriverService service = new ChromeDriverService.Builder()
		                            .usingDriverExecutable(new File("/usr/local/chromedriver"))
		                            .usingAnyFreePort()
		                            .build();
		ChromeOptions options = new ChromeOptions();
		options.merge(capabilities);    
		ChromeDriver driver1 = new ChromeDriver(service, options);
		
		//Set capabilities
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", "77.0");
		capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one
		capabilities.setCapability("build", "LambdaTestSampleApp");
		capabilities.setCapability("name", "LambdaTestJavaSample");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		capabilities.setCapability("selenium_version","4.0.0-alpha-2");
		capabilities.setCapability("timezone","UTC+05:30");
		capabilities.setCapability("geoLocation","IN");
		capabilities.setCapability("chrome.driver","78.0");
				
		WebDriver driver = new ChromeDriver(opt2);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='nav-xshop']/a[@class='nav-a  ' and @data-csa-c-type='link']"));
		for(WebElement elem: tabs){
			System.out.println(elem.getText());
		}
		driver.close();
	}
	

}
