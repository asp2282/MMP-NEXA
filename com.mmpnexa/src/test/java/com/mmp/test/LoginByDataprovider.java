package com.mmp.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginByDataprovider {
	
	@Test(dataProvider="logindata")
	public void patientLogin(String uname,String pword)
	{
		 WebDriver driver;
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pathi\\workspace\\org.mmp\\org-Browsers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	 
	    	driver.findElement(By.id("username")).sendKeys(uname);
	    	driver.findElement(By.id("password")).sendKeys(pword);
	    	driver.findElement(By.name("submit")).click();
	    	driver.quit();
	   	}
	@DataProvider(name="logindata")
	public Object[][]testdata() {
		Object[][]data=new Object[2][2];
		data[0][0]="asp2282";
		data[0][1]="Googleapple$1";
		data[1][0]="asp2282";
		data[1][1]="Googleapple$1";
		return data;
	
		
	}
	
	
	}


