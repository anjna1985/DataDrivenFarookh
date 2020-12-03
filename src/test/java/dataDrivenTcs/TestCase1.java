package dataDrivenTcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import listener.ResultListener;

public class TestCase1 extends ResultListener {

	public WebDriver driver;
	public FileInputStream fis = null;
	public XSSFWorkbook wb = null;
	public XSSFSheet sheet = null;

	@BeforeTest
	public void loginOperation() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void login() throws IOException, InterruptedException {

		File src = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\DataFile\\Tc2.xlsx");
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			String userName = sheet.getRow(i).getCell(0).getStringCellValue();
			String password = sheet.getRow(i).getCell(1).getStringCellValue();

			Thread.sleep(3000);
			driver.findElement(By.id("txtUsername")).clear();
			driver.findElement(By.id("txtUsername")).sendKeys(userName);
			Thread.sleep(4000);
			driver.findElement(By.id("txtPassword")).clear();
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			Thread.sleep(4000);
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(3000);

			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		}

//		FileOutputStream outputStream = new FileOutputStream(
//				System.getProperty("user.dir") + "//src//main//resource//TestData.xls");
//		wb.write(outputStream);
//		outputStream.close();

	}

	@AfterTest
	// Closing the whole browser session
	public void tearDown() {
		if (driver != null) {
			System.out.println("Closing browser...Please wait");
			driver.quit();
		}

	}

}
