import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DesiredCapabilities_Demo {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.

		// Create an object for this Desired Capabilities Class:
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);

		// Settings for Internet Explorer (first, we must go to Internet Explorer settings: Internet Option->Security->Uncheck "Disable or Enable Protected...etc" for ALL zones)
		System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer/IEDriverServer.exe");
		
//		WebDriver driver = new InternetExplorerDriver(caps);
		/*      The constructor InternetExplorerDriver(Capabilities) is deprecated.
		 * "Deprecated", it means that the class or method is no longer considered important. It is so unimportant, in fact, that 
		 * it should no longer be used at all, as it might well cease to exist in the future. The need for deprecation comes 
		 * about because as a class evolves, its API changes
		 *
		 * From: https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/ie/InternetExplorerDriver.html
		 * InternetExplorerDriver(Capabilities capabilities)
		 * Deprecated.
		 * Use InternetExplorerDriver(InternetExplorerOptions)
		 * 
		 */
		
		/*
		 * Since Above Code no longer works, since it was deprecated, I had to workaround using merge method along with InternetExplorerOptions:
		 * 
		 * https://stackoverflow.com/questions/51729275/how-to-ignore-protected-mode-settings-for-internet-explorer-using-setcapability
		 * 
		 * You need to use the method merge() from MutableCapabilities Class to merge the DesiredCapabilities type of object 
		 * into InternetExplorerOptions type object and initiate the WebDriver and WebClient instance by passing the 
		 * InternetExplorerOptions object
		 * 
		 *  Check below 3 lines of code:
		 */
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.merge(caps);
		WebDriver driver = new InternetExplorerDriver(options);

		driver.manage().window().maximize();
		
		// Somehow Internet Explorer does nto work correctly.

		driver.get("https://www.google.com/"); // go to google.
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.id("gbqfbb")).click();

		driver.close(); // Close browser
		driver.quit();  // Quit webdriver.


	}

}
