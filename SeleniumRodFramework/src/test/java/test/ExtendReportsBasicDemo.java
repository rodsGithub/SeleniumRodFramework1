package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportsBasicDemo {

	private static WebDriver driver = null;

	public static void main(String[] args) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test1 = extent.createTest("Google Search Test One", "This is a test to validate Google search functionality");

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		// Settings for Google Chrome:
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		// Start Google Chrome Maximized:
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);

        // log(Status, details)
        test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com/"); // go to google.
		test1.pass("Navigated to goodle.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step"); // Search for...
		test1.pass("Entered Text in Search Box");
		
		driver.findElement(By.id("gbqfbb")).click();   // Click to search.
		test1.pass("Click on button");

		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		
		test1.info("Test Completed");
		
		
		
		
		// Repeat same code but now add a failure:
		
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test2 = extent.createTest("Google Search Test Two", "This is a test to validate Google search functionality");

//		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		// Settings for Google Chrome:
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		// Start Google Chrome Maximized:
//		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);

        // log(Status, details)
        test2.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com/"); // go to google.
		test2.pass("Navigated to goodle.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step"); // Search for...
		test2.pass("Entered Text in Search Box");
		
		// Here add the failure (it is just the description for the report, not actually a real failure):
		driver.findElement(By.id("gbqfbb")).click();   // Click to search.
		test2.fail("Click on button");

		driver.close();
		driver.quit();
		test2.pass("Close the browser");
		
		test2.info("Test Completed");
		
		
		
        // calling flush writes everything to the log file *** this is IMPORTANT, otherwise anything will be written to the report.
        extent.flush();

	}

}
