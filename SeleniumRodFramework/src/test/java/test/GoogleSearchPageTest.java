package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		googleSearchTest();

	}

	public static void googleSearchTest(){

		// Browser Set Up:
		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
				
		driver.get("https://www.google.com/"); // go to google.
				
		searchPageObj.setTextInSearchBox("A B C D");
		
		searchPageObj.clickSearchButton();
		
		driver.close();


	}

}
