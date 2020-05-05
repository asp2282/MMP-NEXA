package com.mmp.test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.mmp.pages.ExcelUtil;

public class LoginbyJexcelfile {
	public WebDriver driver;
	 HashMap<String,String> hMap = new HashMap<String,String>();
		@Test(priority=1)
		public void patientLogin() throws Exception

		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\pathi\\workspace\\com.mmpnexa\\mmp-browsers\\geckodriver.exe");
	        driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
			ExcelUtil excel = new ExcelUtil("./mmp-data/testdata.xls");
			String data = excel.getCellData(0, 1, 0);
			//Object cell1= System.out.println(data);
			String data1 = excel.getCellData(0, 1, 1);
			//Object cell2 = System.out.println(data1);
			driver.findElement(By.id("username")).sendKeys(data);
			driver.findElement(By.id("password")).sendKeys(data1);
			Thread.sleep(2000);
			driver.findElement(By.name("submit")).click();
			Thread.sleep(2000);
			
			
		}

}
