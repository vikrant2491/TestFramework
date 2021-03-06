package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='nav-logo']/a")
	public WebElement logo;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	public WebElement searchField;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	public WebElement searchButton;

}
