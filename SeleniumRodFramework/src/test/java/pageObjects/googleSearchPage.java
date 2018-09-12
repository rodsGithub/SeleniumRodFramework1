package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class googleSearchPage {
	
	private static WebElement element = null;
	
	public static WebElement textboxSearch(WebDriver driver) {
		
		WebElement element = driver.findElement(By.name("q"));
		return element;
		
	}
	
	public static WebElement buttonSearch(WebDriver driver) {
		element = driver.findElement(By.id("gbqfbb"));
		return element;
	}  

}
