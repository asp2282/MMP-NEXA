package com.mmp.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

/*   
     Tester: Amita
     Date Created: 8/24/2019
     Verified By: Shantosh 
     Description: Parent Script                   
 */

public class DriverScript {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public DriverScript()
	{
		try
		{
			File src = new File("./org-config/Config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);	
		}
		catch(Exception e)
		{
			System.out.println("File Not Found :"+e.getMessage());
		}
	}
}