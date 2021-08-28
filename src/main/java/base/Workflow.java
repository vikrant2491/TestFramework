package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Workflow {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		option.addArguments("incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		System.out.println(driver.manage().getCookies());
		for(Cookie ck: driver.manage().getCookies()){
			System.out.println(ck.getName());
			System.out.println(ck.getValue());
			System.out.println(ck.getDomain());
			System.out.println(ck.getExpiry());
			System.out.println(ck.isSecure());
			System.out.println("end");
		}
		
		
		WebElement helloDrop = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		WebElement yourOrders = driver.findElement(By.id("nav_prefetch_yourorders"));
		Actions action = new Actions(driver);
		action.moveToElement(helloDrop).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav_prefetch_yourorders")));
		action.moveToElement(yourOrders).click().build().perform();
		
		driver.findElement(By.xpath("//a[@class='a-link-nav-icon']")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile Phone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='Redmi 9A (Nature Green, 2GB RAM, 32GB Storage) | 2GHz Octa-core Helio G25 Processor | 5000 mAh Battery']/parent::a")).click();
		Thread.sleep(1000);
		System.out.println(driver.manage().getCookies());
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add to Cart']//preceding::input[1]"))).click();		
//		Select select = new Select(qty);
//		select.selectByValue("2");
		
	}
	
	public static void readExcel(String path) throws Exception{
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
		Sheet sheet = workbook.getSheet("");
		int rowCount = sheet.getLastRowNum();
		for(int i=0;i<rowCount;i++){
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
			System.out.println(sheet.getRow(i).getCell(1).getStringCellValue());
		}
		workbook.close();
	}

}
