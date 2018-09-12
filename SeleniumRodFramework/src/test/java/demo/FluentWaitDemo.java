package demo;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://www.google.com/"); // go to google.
		driver.findElement(By.name("q")).sendKeys("abcd nih");
		driver.findElement(By.id("gbqfbb")).click();
		//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

//		driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH")).click();

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH"));
				
				if (linkElement.isEnabled()) {
					System.out.println("Element Found");
					
				}
				
				return linkElement;
			}
		});
		
		element.click();

		Thread.sleep(3000);

		driver.close();
		driver.quit();
	}

}
