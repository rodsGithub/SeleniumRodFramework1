package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {

		System.out.println("Browser Name is: " + browserName);
		System.out.println("Thread id : " + Thread.currentThread().getId());
		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);

		} else if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();


		} else if(browserName.equalsIgnoreCase("ie")) {

			/*
			 * Settings for Internet Explorer (first, we must go to Internet Explorer settings: 
			 * Internet Option->Security->Uncheck "Disable or Enable Protected...etc" for ALL zones)
			 * 
			 */
			System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer/IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();

		} 


	}

	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(4000);



	}

	@AfterTest
	public void teardown() {

		driver.close();
		System.out.println("Test Completed Successfully");
	}

}
