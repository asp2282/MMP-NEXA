package com.mmp.base;import java.io.File;

//import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;



public class Base {
	 
	public  WebDriver driver;
	public Properties prop;
 public void launchDriver(){
	 
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pathi\\workspace\\org.mmp\\org-Browsers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000");
 }
 public void getRegisterUrl(){
	 
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pathi\\workspace\\org.mmp\\org-Browsers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
 }
 public void getPatientUrl(){
	 
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pathi\\workspace\\org.mmp\\org-Browsers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
 }
public void getAdminUrl(){
	 
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pathi\\workspace\\mmp\\mmp-browsers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
 }
	
	 //prop=new Properties();
	
	 /*FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/iitp/mmp/patient/resources/data.properties");
	 prop.load(fis);
	
	String browserName=System.getProperty("browser");
	 String browserName=prop.getProperty("browser");

	if(browserName.equals("chrome") ){
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pathi\\workspace\\mmp\\mmp-browsers\\chromedriver.exe");
		 driver = new ChromeDriver();
	 }
	else if (browserName.equals("firefox") ){
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\pathi\\workspace\\mmp\\mmp-browsers\\geckodriver.exe");
		 driver=new FirefoxDriver();
	 }
	 else if (browserName.equals("IE")) {
		 System.setProperty("webdriver.ie.driver", "C:\\Users\\pathi\\workspace\\mmp\\mmp-browsers\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	 }
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;	 
 }*/
 public void getScreenShot(String result) throws IOException {
	 try {
	File src= ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(src, new File("/Users/pathi/Desktop/ScreenShots/"+result+"screenshot.png"));
	 }
	 catch(Error e) {System.out.println("not printed");}
 }
}