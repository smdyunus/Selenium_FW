package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonLogin {

	//Web Elements and methods
	WebDriver driver;
	
	//Initialize all the webElements
	public AmazonLogin(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Find all the elements and keep it here
	@FindBy(className ="nav-line-1-container")
	WebElement signInBtn;
	
	//Action
	public void signInBtn() {
		signInBtn.click();	
	}
	@FindBy(id ="ap_email")
	WebElement email;
	
	//Action
	public void emailadd(String emailadd) {
		email.sendKeys(emailadd);
	}

	
	@FindBy(id ="continue")
	WebElement continueBtn;
	
	//Action
	public void continueBtn() {
		continueBtn.click();
	}
	
	@FindBy(id ="ap_password")
	WebElement password;
	
	//Action
	public void enterPassword(String enterPassword) {
		password.sendKeys(enterPassword);
	}
	
	@FindBy(id ="signInSubmit")
	WebElement signInSubmit;
	
	//Action
	public void signInSubmit() {
		signInSubmit.click();
	}
	
	
	@FindBy(xpath = "//span[contains(text(),'password')]")
	WebElement errorText;
	
	//Perform all the actions by using setter methods
	
	public void loginToAmazon(String mobile, String password) 
	{
		this.signInBtn();
		this.emailadd(mobile);
		this.continueBtn();
		this.enterPassword(password);
		this.signInSubmit();
		String t = driver.getTitle();
		System.out.println(t);
	}
	
	
	public void loginStatus() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);	
	}
	
	public String incorrectLoginError() {
		return 
				errorText.getText();
	
	}
	
	
}
