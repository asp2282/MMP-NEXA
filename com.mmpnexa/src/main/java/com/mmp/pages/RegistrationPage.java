package com.mmp.pages;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	    HashMap<String,String> hMap = new HashMap<String,String>();
		Random rnd = new Random();
		WebDriver driver;
		
		
		public  HashMap<String, String> registerPatient() 
	{ 
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pathi\\workspace\\org.mmp\\org-Browsers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
        
	
		WebElement stateTxtField = driver.findElement(By.id("state"));
		stateTxtField.sendKeys("NC");
		hMap.put("state", stateTxtField.getAttribute("value"));
		
		WebElement cityTxtField = driver.findElement(By.id("city"));
		cityTxtField.sendKeys("Springfield");
		hMap.put("city", cityTxtField.getAttribute("value"));
		
		WebElement addressTxtField = driver.findElement(By.id("address"));
		addressTxtField.sendKeys("1234 Grand Ave Springfield");
		hMap.put("address", addressTxtField.getAttribute("value"));
		
		WebElement zipcodeTxtField = driver.findElement(By.id("zipcode"));
		//long zipValue = 10000+rnd.nextInt(90000);
		//zipcodeTxtField.sendKeys(""+zipValue);
		zipcodeTxtField.sendKeys("38244");
		hMap.put("zipcode", zipcodeTxtField.getAttribute("value"));
		
		WebElement ageTxtField = driver.findElement(By.id("age"));
		//long ageValue = 10+rnd.nextInt(90);
		//ageTxtField.sendKeys(""+ageValue); 
		ageTxtField.sendKeys("39");
		hMap.put("age", ageTxtField.getAttribute("value"));
		
		WebElement heightTxtField = driver.findElement(By.id("height"));
		heightTxtField.sendKeys("5.5");
		hMap.put("height", heightTxtField.getAttribute("value"));
		
		WebElement weightTxtField = driver.findElement(By.id("weight"));
		weightTxtField.sendKeys("115");
		hMap.put("weight", weightTxtField.getAttribute("value"));
		
		WebElement phaTxtField = driver.findElement(By.id("pharmacy"));
		phaTxtField.sendKeys("walgreen");
		hMap.put("pharmacy", phaTxtField.getAttribute("value"));
		
		WebElement phaaddTxtField = driver.findElement(By.id("pharma_adress"));
		phaaddTxtField.sendKeys("1234Grand Ave Springfield IL");
		hMap.put("pharma_adress", phaaddTxtField.getAttribute("value"));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		Date d = new Date();
	 
		
		WebElement datePickerTxtField = driver.findElement(By.id("datepicker"));
		datePickerTxtField.sendKeys(sdf.format(d));
		hMap.put("datepicker", datePickerTxtField.getAttribute("value"));
		
		WebElement firstnameTxtField = driver.findElement(By.id("firstname"));
		String fNameValue = "AutoTesterFN" +  (char) (65+rnd.nextInt(26));
		firstnameTxtField.sendKeys(fNameValue);
		System.out.println("firstname:"+fNameValue);
		hMap.put("firstname", firstnameTxtField.getAttribute("value"));
		
		
		
		WebElement lastnameTxtField = driver.findElement(By.id("lastname"));
		String LNameValue = "testerLN" +  (char) (65+rnd.nextInt(26));
		lastnameTxtField.sendKeys(LNameValue);
		System.out.println("lastname:"+LNameValue);
		hMap.put("lastname", lastnameTxtField.getAttribute("value"));
		
		
		
		WebElement emailTxtField = driver.findElement(By.id("email"));
		String emailValue = "testerEmail" +10+rnd.nextInt(90)+  (char) (65+rnd.nextInt(26))+"@gmail.com";
		emailTxtField.sendKeys(emailValue );
		hMap.put("email", emailTxtField.getAttribute("value"));
		
		WebElement usernameTxtField = driver.findElement(By.id("username"));
		String UNameValue = "Auto_Testerasp" +  (char) (65+rnd.nextInt(26));
		usernameTxtField.sendKeys(UNameValue);
		System.out.println("username: "+UNameValue);
		hMap.put("username", usernameTxtField.getAttribute("value"));
		
		WebElement passwordTxtField = driver.findElement(By.id("password"));
	    passwordTxtField.sendKeys("Google_2282");
	    System.out.println("password:"+"Google2282");
		hMap.put("password", passwordTxtField.getAttribute("value"));
		
		WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmpassword"));
		confirmpasswordTxtField.sendKeys("Google_2282");
		hMap.put("confirmpassword", confirmpasswordTxtField.getAttribute("value"));
		
		Select select = new Select(driver.findElement(By.id("security")));
		select.selectByVisibleText("what is your best friend name");
		
		WebElement answerTxtField = driver.findElement(By.id("answer"));
		answerTxtField.sendKeys("Dipa");
		hMap.put("answer", answerTxtField.getAttribute("value"));
		
	 
		WebElement ssnTxtField = driver.findElement(By.id("ssn"));
		long ssnValue = 100000000+rnd.nextInt(900000000);
		ssnTxtField.sendKeys(""+ssnValue);
		hMap.put("ssn", ssnTxtField.getAttribute("value"));
		
		WebElement licenseTxtField = driver.findElement(By.id("license"));
		licenseTxtField.sendKeys("12345678");
		System.out.println("License Value:: "+ licenseTxtField.getAttribute("value"));
		hMap.put("license", licenseTxtField.getAttribute("value"));
		
		driver.findElement(By.name("register")).click();
		
		
		//input[@name='register']
		
		Alert regalrt = driver.switchTo().alert();
		String successMsg = regalrt.getText();
		System.out.println("regmsg:"+successMsg);
		hMap.put("successMsg", successMsg);
		//String expected = "Thank you for registering with MMP";
		//Assert.assertEquals(successMsg.trim(),expected);
		regalrt.accept();
		
		return hMap;
		
		}
}


//First Name: Amita  , 
//Last Name :Patel , 
//DOB: 02/02/1982,  
//Lience :23459876,      
//SSN :3456789012,    
//State :NC,          
//City:Springfield ,     
//Address: 1234 Grand Ave Springfield,    
//Zipcode: 38244 ,   
//Age:39,   
//Height : 5.5,  
//Weight : 115,    
//Pharmacy :Walgreen ,   
//Pharmacy Address :1234Grand Ave Springfield IL ,  
//Email: aspatel2282@gmail.com ,    
//User Name: asp2282 ,    
//Selact security question :selact from dropdown list , :best friend   
//Answer :Dipa,     
//Password :Googleapple$1,   
//Confirm Password: Googleapple$1


    
	
	


