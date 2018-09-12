package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	public static void main(String[] args) {
		SeleniumWaits();
	}

	public static void SeleniumWaits() {

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);

		// Implicit Wait (altering the timeout default):
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 250 ms is the default for selenium

		driver.get("https://www.google.com/"); // go to google.
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.id("gbqfbb")).click();

		// Explicit Wait
		WebDriverWait wait= new WebDriverWait(driver, 20);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
		
		driver.findElement(By.name("abcd")).click();

		driver.close();
		driver.quit();

	}

}
