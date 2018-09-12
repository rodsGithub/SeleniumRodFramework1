package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

	// With TestNG we DON'T need the main method, so then remove it...

	static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		// Settings for Google Chrome:
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		//		WebDriver driver = new ChromeDriver();
		// Start Google Chrome Maximized:
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);

	}

	@Test
	public static void googleSearch2() {

		driver.get("https://www.google.com/"); // go to google.
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		// click on search

		//driver.findElement(By.name("btnK")).click(); // This line does not work because the search hides the button.
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("gbqfbb")).click();

	}
	
	
	@Test
	public static void googleSearch3() {

		driver.get("https://www.google.com/"); // go to google.
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		// click on search

		//driver.findElement(By.name("btnK")).click(); // This line does not work because the search hides the button.
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.id("gbqfbb")).click();

	}	

	@AfterTest
	public void tearDownTest() {

		// close browser and quit webdriver.
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}

}
