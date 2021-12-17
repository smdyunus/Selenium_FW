package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPropertiesTest 
{

public static void main(String[] args) 

{
	//file location
	File file = new File("config/data.properties");
	FileInputStream fileInput = null;
	
	//Check the file
	try 
	{
		fileInput = new FileInputStream(file);
	} 
	//Throw error
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	
	Properties prop = new Properties();
	// Load the properties from file
	try 
	{
		prop.load(fileInput);
	} 
	catch (Exception e) 
	{
		e.printStackTrace();	
	}
	
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver");		
	ChromeDriver driver = new ChromeDriver();
	driver.get(prop.getProperty("URL"));
	driver.findElement(By.className("nav-line-1-container")).click();
	System.out.println("Eneter Mobile num");
	driver.findElement(By.id("ap_email")).sendKeys(prop.getProperty("username"));
	
	driver.findElement(By.id("continue")).click();
	System.out.println("Eneter pass");
	driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.id("signInSubmit")).click();
	driver.close();
}	
}