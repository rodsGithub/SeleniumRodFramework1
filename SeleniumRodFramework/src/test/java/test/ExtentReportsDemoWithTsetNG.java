package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTsetNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	WebDriver driver;

	@BeforeSuite // It runs before ALL @Test have ran.
	public void setUp() {

		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}


	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);

	}


	@Test
	public void test1() throws Exception {

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		driver.get("https://www.google.com/"); // go to google.
		test.pass("Navigated to google.com");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		// info(details)
		test.info("This step shows usage of info(details)");
		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");

	}


	@Test
	public void test2() throws Exception {

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MySecondTest", "Sample description");
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		// info(details)
		test.info("This step shows usage of info(details)");
		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");

	}

	@AfterTest // This is similar as to afterEach in protractor, it runs after every @Test is run.
	public void tearDownTest() {

		// close browser and quit webdriver.
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}



	@AfterSuite // It runs after ALL @Test have ran.	

	public void tearDown() {
		// calling flush writes everything to the log file
		extent.flush();
	}

}
