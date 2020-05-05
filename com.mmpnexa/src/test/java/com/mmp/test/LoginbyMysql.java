package com.mmp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginbyMysql {
	private static String url = "jdbc:mysql://localhost:3306/users";    
	private static String driverName = "com.mysql.jdbc.Driver";   
	private static String username = "root";   
	private static String password = "root";
	private static Connection con;
	public static void main(String[] args) {
		
	
    {
		try {
			Class.forName(driverName);
			try {
				
			//Create a connection to DB by passing Url,Username,Password as parameters
		con = DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
				
				//Executing the Queries
				//stmt.executeUpdate("INSERT INTO users.patient VALUES ('asp2282','Googleapple$1')");
		ResultSet rs = stmt.executeQuery("SELECT * FROM users.patient");
			
		rs.last();
        int rows = rs.getRow();
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		int cols = rsmd.getColumnCount();
		System.out.println(rows +"--" + cols);
		String[][] inputArr= new String[rows][cols];
                int i =0;
				rs.beforeFirst();
				//Iterating the data in the Table
				while (rs.next())
				{
					for(int j=0;j<cols;j++)
					{
						inputArr[i][j]=rs.getString(j+1);
						System.out.print(inputArr[i][j]);
			         }	
			     }
					
			} 
			catch (SQLException ex)
			{
				ex.printStackTrace();
				System.out.println("Failed to create the database connection."); 
			}
		} 
		catch (ClassNotFoundException ex) 
		{
			ex.printStackTrace();
			System.out.println("Driver not found."); 
		}
    }
		
 }		
		
	@Test
	 public void login(String username,String password)
	 {	

 WebDriver driver;
System.setProperty("webdriver.chrome.driver", "C:\\Users\\pathi\\workspace\\org.mmp\\org-Browsers\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");

driver.findElement(By.id("username")).sendKeys(username);
driver.findElement(By.id("password")).sendKeys(password);
driver.findElement(By.name("submit")).click();
driver.quit();

}
}
