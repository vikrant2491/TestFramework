package TestObjects;

import org.openqa.selenium.By;

import Pages.HomePage;
import base.Constants;
import cucumber.api.DataTable;

public class HomePage_TO {
	
	HomePage home = new HomePage(Constants.driver);
	
	public void searchText(String text){
		home.searchField.sendKeys(text);
		home.searchButton.click();
		
		
	}

}
