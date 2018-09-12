import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserTesting {
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		System.out.println(projectPath);						// Print it to make sure it is working fine.
		
//		// Settings for FireFox:
//		System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

		// Settings for Google Chrome:
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		
		// Start Google Chrome Maximized:
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);

//		// Settings for Internet Explorer (first, we must go to Internet Explorer settings: Internet Option->Security->Uncheck "Disable or Enable Protected...etc" for ALL zones)
//		System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer/IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();
		
//		driver.get("http://seleniumhq.org/");
		driver.get("https://iprc-qa.run.asv-pr.ice.predix.io");  // QA Environment.
		
		WebElement ssoUser = driver.findElement(By.id("username"));
		WebElement ssoPassword = driver.findElement(By.id("password"));
		WebElement ssoSubmit = driver.findElement(By.id("submitFrm"));
		
		ssoUser.sendKeys("503046730");
		ssoPassword.sendKeys("ill.joy.map-41a");
		ssoSubmit.click();
		
		try {
			
			Thread.sleep(3000);   // Pause for 3 seconds (3000 ms)
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 List<WebElement> listOfInputElementsInputElements = driver.findElements(By.id("ui-dialog-0-label")); // Mow use ALL elements.
				
		int count = listOfInputElementsInputElements.size();  // Count them with SIZE
		
		System.out.println("Count of input Elements : " +count);  // Display the count.
			
		driver.close(); // Closes the web browser
		
//		driver.quit(); // Closes the web browser and Quit all the chrome drivers running.
		
		
		
	}

}
