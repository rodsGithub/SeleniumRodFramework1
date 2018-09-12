package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_Demo {

	// With TestNG we DON'T need the main method, so then remove it...

	static WebDriver driver = null;
	public static String browserName=null;

	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		PropertiesFile.getProperties();

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();

		}


	}

	@Test
	public static void googleSearch() {

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
		//driver.quit();
		System.out.println("Test completed successfully");
		PropertiesFile.setProperties();

	}

}
