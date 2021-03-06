package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Page1;

public class Page1Test {

	 //Test methods

    WebDriver driver;
    Page1 Al;
 
    @BeforeMethod
    public void setup() {

             System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    String baseUrl = "https://www.amazon.in/";
                    driver.get(baseUrl);
    }
    
    
    @Test(priority =  1)
    public void ValidLogin() throws IOException {
            Al = new Page1(driver);
            Al.loginToAmazon("9620301980", "Yunus@5818");
            Al.loginStatus();
    }

    @Test(priority = 2)
    public void invalidLogin() {
            Al = new Page1(driver);
            Al.loginToAmazon("9620301980", "Yunus@5812");
            AssertJUnit.assertEquals(Al.incorrectLoginPwd(),"Your password is incorrect");
    }

    @Test(priority = 3)
    public void invalidMobile() {
            Al = new Page1(driver);
            Al.loginToAmazon("9620399980", "Yunus@5812");
    }

    @Test(priority = 4)
    public void withoutpwd() {
            Al = new Page1(driver);
            Al.loginToAmazon("9620399980", "");
    }

    @AfterMethod
    public void close() {
            driver.close();
    }
}
