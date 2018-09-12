package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	WebDriver driver = null; 

	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");    // Gives the location of the project, to use it below.

		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);

	}

	// Since we are adding the data provider function, inside we don't have to include anything, except for a sysout..
	@Test(dataProvider="test1data")
	public void test1 (String username, String password) throws Exception {
		System.out.println(username + " | " + password);

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);

	}

	@DataProvider(name = "test1data")
	public Object[][] getData(){

		String excelPath = "C:/JavaProjects/SeleniumRodFramework/excel/data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;

	}

	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		// Define an Object Array:
		// "rowCount-1" -> Not to process the column headers.
		Object data[][] = new Object [rowCount-1][colCount];

		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//				System.out.print(cellData + " | ");   // Send to consol the cell data.
				data[i-1][j] = cellData;
			}

			System.out.println();
		}

		return data;

	}

}
