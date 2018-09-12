package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoITDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("http://www.tinyupload.com/");
		driver.findElement(By.name("uploaded_file")).click();

		// Me faltó generar el script y compilarlo para generar el exe en AutoIT
		Runtime.getRuntime().exec("D:/whatever/whatever_script.exe");

		Thread.sleep(3000);

		driver.close();

	}

}
