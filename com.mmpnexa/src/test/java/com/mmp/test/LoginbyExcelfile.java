package com.mmp.test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mmp.pages.ExcelUtil;



public class LoginbyExcelfile {
	
 public WebDriver driver;
 HashMap<String,String> hMap = new HashMap<String,String>();
	@Test(priority=1)
	public void validateValidLogin() throws Exception

	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pathi\\workspace\\com.mmpnexa\\mmp-browsers\\geckodriver.exe");
        driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		ExcelUtil excel = new ExcelUtil("./mmp-data/data.xlsx");
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
	
	@Test(priority=2)
	public void validateInvalidLogin() throws Exception{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pathi\\workspace\\com.mmpnexa\\mmp-browsers\\geckodriver.exe");
        driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		ExcelUtil excel = new ExcelUtil("./mmp-data/data.xlsx");
		String data = excel.getCellData(0, 2, 0);
		//Object cell1= System.out.println(data);
		String data1 = excel.getCellData(0, 2, 1);
	 	//Object cell2 = System.out.println(data1);
		driver.findElement(By.id("username")).sendKeys(data);
		driver.findElement(By.id("password")).sendKeys(data1);
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		
		Alert alrt = driver.switchTo().alert();
		String alertMsg1 = alrt.getText();
		System.out.println(alertMsg1);
		hMap.put("alertMsg", alertMsg1);
		
		alrt.accept();
		String expected = "Wrong username and password.";
		Assert.assertEquals(alertMsg1.trim(),expected);
		//Assert.assertEquals(alertMsg1, expected);
		Thread.sleep(2000);
		
	}
	
	@Test(priority=3)
	public void loginBlank() throws Exception{
		/*ExcelUtil excel = new ExcelUtil("./mmp-data/data.xlsx");
		String data = excel.getCellData(0, 3, 0);
		//Object cell1= System.out.println(data);
		String data1 = excel.getCellData(0, 3, 1);
	 	//Object cell2 = System.out.println(data1);*/
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pathi\\workspace\\com.mmpnexa\\mmp-browsers\\geckodriver.exe");
        driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		
		Alert alrt = driver.switchTo().alert();
		String alertMsg = alrt.getText();
		System.out.println(alertMsg);
		//hMap.put("alertMsg", alertMsg);
		String expected = "Wrong username and password.";
		Assert.assertEquals("alertmsg", expected);
		alrt.accept();
		Thread.sleep(2000);
		
		
	}
}
