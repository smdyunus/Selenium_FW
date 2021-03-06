package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.AmazonLogin;

public class AmazonLoginTest {
	
	WebDriver driver;
	AmazonLogin Al;
	

	@BeforeMethod
    public void setUp()
    {   
    	System.setProperty("webdriver.chrome.driver","drivers/chromedriver");		
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("The setup process is completed");
        String baseUrl = "https://www.amazon.in/";
        driver.get(baseUrl);
    }
	
	@Test //Main method
	public void validLogin() {
		Al = new AmazonLogin(driver);
		Al.loginToAmazon("9620301980", "Yunus@5818");
		Al.loginStatus();
		
	}

	@Test //Main method
	public void invalidLogin() {
		Al = new AmazonLogin(driver);
		Al.loginToAmazon("9620301980", "Yunsus@5818");
		Al.incorrectLoginError();
		
	}

	@Test //Main method
	public void one() {
		System.out.println("one");
	}
	
	@Test //Main method
	public void two() {
		System.out.println("two");
	}
	
	@Test //Main method
	public void three() {
		System.out.println("three");
	}
	
	@Test //Main method
	public void fourth() {
		System.out.println("fourth");
	}
	
	@Test
	public void Fifth() {
		System.out.println("Fifth");
	}
	
	@Test
	public void Six() {
		System.out.println("Six");
	}
	
	
	@Test
	public void seven() {
		System.out.println("seven");
	}
	
	
	@Test
	public void eight() {
		System.out.println("eight");
	}
	
	@Test
	public void rty() {
		System.out.println("hello");
	}
	
	@Test
	public void last() {
		System.out.println("last");
	}
	
	@AfterMethod
	public void closeTest() {
		
		driver.close();
        System.out.println("The Closeup process is completed");

	}

}
