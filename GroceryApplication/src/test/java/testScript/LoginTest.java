package testScript;

import java.io.IOException;

import org.apache.logging.log4j.util.Constants;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Constant;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	
	public HomePage home;
	@Test(priority=1,description= "Verify Login with Valid username and valid password",retryAnalyzer=retry.Retry.class)
	
	public void  verifyLoginWithValidCredentials() throws IOException
	{
		// used to read username and password value from excel sheet
		String usernameValue=ExcelUtility.getStringData(1, 0,Constant.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constant.LOGINSHEET);
		
		
		LoginPage loginpage=new LoginPage(driver);
		
		//loginpage.enterUserName(usernameValue);
		// for chaining purpose
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		
		//loginpage.signin(); changed this for chaining purpose
		home=loginpage.signin();
		loginpage.validcredentialsAssertion();
		
		/*
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		
		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();	
		*/
		
		// hard assertion
		//String actual=driver.getTitle();
	//String expected="Dashboard | 7rmart supermarket";
		//Assert.assertEquals(actual,expected);
		
		// Get the title from page method
        String actualTitle = loginpage.validcredentialsAssertion();
        // Expected title (you can also take it from Constants)
        String expectedTitle = "Dashboard | 7rmart supermarket";
        // Assertion
        Assert.assertEquals(actualTitle, expectedTitle, Messages.VALID_CREDENTIAL_ASSERT);
        		//"Dashboard title mismatch!/login with valid credentials are failed");

		
	}
	
@Test(priority=2, description= "Verify Login with Valid username and invalid password")
public void verifyValidusernameInvalidPassword() throws IOException
{
	String usernameValue=ExcelUtility.getStringData(2, 0,Constant.LOGINSHEET);
	String passwordValue=ExcelUtility.getStringData(2, 1,Constant.LOGINSHEET);
	

	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(usernameValue).enterPassword(passwordValue).signin();
	//loginpage.enterPassword(passwordValue);
	//loginpage.signin();
	loginpage.Invalidcredentials();
	
	
	/*
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
	*/
	
	// Assertion
	String actualMessage=driver.getCurrentUrl();
	String expectedMessage = "https://groceryapp.uniqassosiates.com/admin/login";
	//Assert.assertEquals(actualMessage, expectedMessage,"login URL mismatched-Login failed");
	
	// Using Message class.constant --> Message class created in src/main/java , constant also
	Assert.assertEquals(actualMessage, expectedMessage, Messages.VALIDUSERNAME_INVALIDPASSWORD_ASSERT); 
}

@Test(priority=3,description= "Verify Login with Inalid username and invalid password")
public void verifyInvalidusernamevalidPass() throws IOException
{
	String usernameValue=ExcelUtility.getStringData(3, 0,Constant.LOGINSHEET);
	String passwordValue=ExcelUtility.getStringData(3, 1,Constant.LOGINSHEET);
	

	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(usernameValue).enterPassword(passwordValue).signin();
	//loginpage.enterPassword(passwordValue);
	//loginpage.signin();
	loginpage.Invalidcredentials();
	
	
	
	/*
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);

	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
	*/
	
	String actualMessage=driver.getCurrentUrl();
	String expectedMessage = "https://groceryapp.uniqassosiates.com/admin/login";
	
	//Assert.assertEquals(actualMessage, expectedMessage,"login URL mismatched and testcase failed");
	
	// Using Message class.constant --> Message class created in src/main/java , constant also
		Assert.assertEquals(actualMessage, expectedMessage,Messages.INVALIDUSERNAME_INVALIDPASSWORD_ASSERT);
		
}


@Test(priority=4, description= "Verify Login with invalid username and valid password",dataProvider = "loginProvider")

public void verifyInvalidusernameInvalidpassword(String username, String password) throws IOException
//public void verifyInvalidusernameInvalidpassword() throws IOException
{

	
	//String usernameValue=ExcelUtility.getStringData(4, 0, "LoginSheet");
	//String passwordValue=ExcelUtility.getStringData(4, 1, "LoginSheet");
	
	
	/*String usernameValue=ExcelUtility.getStringData(4, 0,Constant.LOGINSHEET);
	String passwordValue=ExcelUtility.getStringData(4, 1,Constant.LOGINSHEET);
	*/
	
	/*
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	
	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
	*/
	
	
	LoginPage loginpage=new LoginPage(driver);
	//loginpage.enterUserName(usernameValue);
	loginpage.enterUserName(username).enterPassword(password).signin();
	//loginpage.enterUserName(username);
	//loginpage.enterPassword(password);
	//loginpage.signin();
	loginpage.Invalidcredentials();
	
	String actualMessage=driver.getCurrentUrl();
	String expectedMessage = "https://groceryapp.uniqassosiates.com/admin/login";
	//Assert.assertEquals(actualMessage, expectedMessage, " Expected URL Mismatch");
	
	// Using Message class.constant --> Message class created in src/main/java , constant also
			Assert.assertEquals(actualMessage, expectedMessage, Messages.INVALIDUSERNAME_VALIDPASSWORD_ASSERT);
	
}
//  Data provider concept
@DataProvider(name="loginProvider")
public Object[][] getDataFromDataProvider() throws IOException
{
	return new Object[][] 
	{   new Object[] {"user","password"},
		new Object[] {"username","pass"},
		new Object[] {"user","password"}
	};
}
}
