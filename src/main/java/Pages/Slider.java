package Pages;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://appsurify.com/qa-automation-tool-pricing/");
		WebElement sliderTip = driver.findElement(By.xpath("(//div[@class='e-handle e-handle-first e-control e-tooltip e-lib'])[1]"));
		Actions action = new Actions(driver);
		action.clickAndHold(sliderTip).moveByOffset(10, 0).release().build().perform();

	}

}
