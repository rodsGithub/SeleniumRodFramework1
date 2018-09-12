package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	// Initialize driver:
	WebDriver driver = null;
	
	// First Locate Objects, using Selenium Class "By ..."
	By textbox_search = By.name("q");
	By button_search = By.id("gbqfbb");
//	By button_search = By.name("btnK");  // Somehow this way does not work-.
	
	// Constructor:
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	// Now add methods for actions (sendKeys)
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	// Now add methods for actions (click)	
	public void clickSearchButton() {
		driver.findElement(button_search).click();		
	}

}
