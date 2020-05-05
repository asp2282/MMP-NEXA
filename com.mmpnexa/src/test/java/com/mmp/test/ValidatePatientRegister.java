package com.mmp.test;


import org.testng.annotations.Test;

import com.mmp.pages.RegistrationPage;
import org.testng.annotations.BeforeTest;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;  
import org.testng.annotations.AfterTest;

public class ValidatePatientRegister {
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() throws InterruptedException {
		  
				
				System.setProperty("webdriver.ie.driver", "C:\\Users\\pathi\\workspace\\org.mmp\\org-Browsers\\IEDriverServer.exe");
			    driver = new InternetExplorerDriver();
				String mmpUrl = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/";
				driver.get(mmpUrl);
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String expectedurl = driver.getCurrentUrl();
				System.out.println(expectedurl);
				try {
					Assert.assertEquals(expectedurl, mmpUrl);
				System.out.println("The page was successfully opened");
				} catch (AssertionError e) {
					e.printStackTrace();
				System.out.println("The page was not successfully opened");
				}
				
				WebElement patientLogin = driver.findElement(By.xpath("//a[contains(text(),'Patient Login')]"));
				patientLogin.click();
				
				Thread.sleep(3000);
				WebElement registerButton = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
				registerButton.click();
	           }
  @Test
  public void registerPatientaccount() throws InterruptedException {
	  
	 
	  try {
		  RegistrationPage hashMap = new RegistrationPage();
		   HashMap<String,String> registrationInfo = hashMap.registerPatient();
		   System.out.println(registrationInfo);
		  	  
		   System.out.println("Registered patient");
	      } 
	  catch (Exception b)
	      {
		   System.out.println("Patient was not  registered");
	      }
	  
  }
  
 
  @AfterTest
  public void afterTest() throws InterruptedException 
  {
		    driver.quit();
			Thread.sleep(5000);
			
  }
}  
  
  
  
  
