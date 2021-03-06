package temp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testAnno 
{
        public WebDriver driver;
        public String url = "https://www.amazon.in/";	

        
	@BeforeSuite
    public void setUp()
    {   
    	System.setProperty("webdriver.chrome.driver","drivers/chromedriver");		
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("The setup process is completed");
    }
    
    @BeforeTest
    public void profileSetup()
    {
        driver.manage().window().maximize();
        System.out.println("The profile setup process is completed");
        
    }

    @BeforeClass
    public void appSetup()
    {
        driver.get(url);
        System.out.println("The app setup process is completed");
    }
    
    @BeforeMethod
    public void checkLogin()
    {
    	WebElement signinbtn = driver.findElement(By.className("nav-line-1-container"));
    	signinbtn.click();
    	WebElement email = driver.findElement(By.id("ap_email"));
    	email.sendKeys("9620301980");
    	
    	WebElement continueBn = driver.findElement(By.id("continue"));
    	continueBn.click();
    	
    	WebElement email1 = driver.findElement(By.id("ap_password"));
    	email1.sendKeys("Yunus@5818");
    	
    	WebElement btn = driver.findElement(By.id("signInSubmit"));
    	btn.click();
    	
        System.out.println("The login process on lamdatest is completed");
    }
    
    @SuppressWarnings("unlikely-arg-type")
    
	@Test(groups="urlValidation")
    public void testCurrentUrl() throws InterruptedException
    {
    	String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    	String actualTitle="";	
    	actualTitle = driver.getTitle();

    	equals(actualTitle.contentEquals(expectedTitle));
        System.out.println("Title is matched");
    }
    
    @AfterMethod
    public void screenShot() throws Exception
    {
    	File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File("screenshots/login.png"));

		System.out.println("Screenshot of the test is taken");
    }
    
    @AfterClass
    public void closeUp()
    {
        driver.close();
        System.out.println("The close_up process is completed");
    }
    
    @AfterTest
    public void reportReady()
    {
        System.out.println("Report is ready to be shared, with screenshots of tests");
    }
    
    @AfterSuite
    public void cleanUp()
    {
        
        System.out.println("All close up activities completed");
    }
    
    @BeforeGroups("urlValidation")
    public void setUpSecurity() {
        System.out.println("url validation test starting");
    }
  
    @AfterGroups("urlValidation")
    public void tearDownSecurity() {
        System.out.println("url validation test finished");
    }
        
}
