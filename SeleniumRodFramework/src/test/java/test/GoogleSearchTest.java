package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// This is my page object;
import pageObjects.googleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearch();
		
	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		
		// Settings for Google Chrome:
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		// Start Google Chrome Maximized:
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);

		
		driver.get("https://www.google.com/"); // go to google.
		
		// Use text box element from Page Object:
		googleSearchPage.textboxSearch(driver).sendKeys("Automation Step by Step");
				
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		
		// click on search
		
		//driver.findElement(By.name("btnK")).click(); // This line does not work because the search hides the button.
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
//		driver.findElement(By.id("gbqfbb")).click();
		
		// Use search button element from Page Object:		
		googleSearchPage.buttonSearch(driver).click();
		
		// close browser
		
		driver.close();
		
		System.out.println("Test completed successfully");
		
	}

}
