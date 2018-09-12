package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
	
		System.setProperty("webdriver.chrome.driver", "C:/JavaProjects/SeleniumRodFramework/drivers/chromedriver/chromedriver.exe");
	
		ChromeOptions options = new ChromeOptions();
		// headless - does not display chrome GUI.
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/"); // go to google.
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.id("gbqfbb")).click();
		
		driver.close();
		driver.quit();
		
		System.out.println("Completed");

	}

}
