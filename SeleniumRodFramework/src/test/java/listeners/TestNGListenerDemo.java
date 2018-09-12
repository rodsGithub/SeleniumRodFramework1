package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.SkipException;
import org.testng.annotations.Test;

// @Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("I'm inside TEST 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I'm inside TEST 2");
//		Assert.assertTrue(false);
		

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		System.out.println(projectPath);						// Print it to make sure it is working fine.
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);		
		
		driver.get("http://google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("abcd");
		
		driver.close();
		
		
	}

	@Test
	public void test3() {
		System.out.println("I'm inside TEST 3");
		throw new SkipException("This test is skipped");
	}

}
