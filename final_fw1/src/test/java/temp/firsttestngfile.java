package temp;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class firsttestngfile {
	
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "drivers/chromedriver";
    public WebDriver driver ; 
     
  @Test(priority = 1)
  public void login() {   
      System.out.println("This is a login");    
  }
  
  @Test(priority = 2)
  public void home() {     
      System.out.println("This is a home"); 
  }
  
  @Test(priority = 3)
  public void payment() {     
      System.out.println("This is a payment"); 
  }
  
  @Test(priority = 4)
  public void logout() {     
      System.out.println("This is a logout"); 
  }
}