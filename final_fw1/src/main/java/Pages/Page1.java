package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Page1 {
	
	  //WebElements and Methods
    WebDriver driver;

    //Initialising all the webelements
    public Page1(WebDriver driver)
    {
            this.driver = driver;
            PageFactory.initElements(driver, this);
    }

    //Find all the webelements
    @FindBy(className="nav-line-1-container")
    WebElement signinbtn;

    @FindBy(id="ap_email")
    WebElement mobile;

    @FindBy(id="continue")
    WebElement continueBtn;

    @FindBy(id="ap_password")
    WebElement pwd;
    
    
    @FindBy(id="signInSubmit")
    WebElement submitBtn;

    @FindBy(xpath="//span[contains(text(),'password is incorrect')]")
    WebElement incorrectLoginError;


    public void clickSignInBtn() {
            signinbtn.click();
    }

    public void enterMobileNum(String enterMobileNum) {
            mobile.sendKeys(enterMobileNum);
    }

    public void clickContinueBtn() {
            continueBtn.click();
    }

    public void enterPassword(String password) {
            pwd.sendKeys(password);
    }
    public void clicksubmitBtn() {
            submitBtn.click();
    }

    
  //Perform all the Action by creating setter method
    public void loginToAmazon(String mobile, String password) {
            this.clickSignInBtn();
            this.enterMobileNum(mobile);
            this.clickContinueBtn();
            this.enterPassword(password);
            this.clicksubmitBtn();
            String t = driver.getTitle();
            System.out.println(t);
    }

    public void loginStatus() {
            String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    String actualTitle="";
    actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle);
            }

    public String incorrectLoginPwd() {
            return incorrectLoginError.getText();
    } 
}
//1. Create a Constuctor
//2. Write a WebElements
//3. Steps
