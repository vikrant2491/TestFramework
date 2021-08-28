package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import bsh.Capabilities;

public class SignUp {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
//		List<HashMap<String, String>> testdata = getExcelData("https://corecompeteglobal-my.sharepoint.com/:x:/g/personal/komal_khatri_corecompete_com/ESU8CggNkmZPlHBvs9gjvzoBETZfHBGdWzHhfTjA5PMOaQ?rtime=v7cTINRb2Ug");
		TakesScreenshot sc = (TakesScreenshot)driver;
		File file = sc.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File(""));
		DesiredCapabilities c = new DesiredCapabilities();
		
		String val = "";
		WebElement elem = driver.findElement(By.xpath(""));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value="+val, elem);
		
		
		
	}
	
	public static List<HashMap<String, String>> getExcelData(String path) throws Exception{
		List<HashMap<String, String>> testDatas = new ArrayList<>();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for(int i=1;i<rowCount;i++){
			Row row = sheet.getRow(i);	
			row.getLastCellNum();
			HashMap<String, String> testData = new HashMap<>(); 
			String firstName = row.getCell(1).getStringCellValue();
			String middleName = row.getCell(2).getStringCellValue();
			String lastName = row.getCell(3).getStringCellValue();
			testData.put("firstName", firstName);
			testData.put("middleName", middleName);
			testData.put("lastName", lastName);		
//			testDatas.add(testData);
		}
		return testDatas;
	}

}
