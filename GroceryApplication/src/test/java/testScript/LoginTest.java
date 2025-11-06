package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	@Test(priority=1,description= "Verify Login with Valid username and valid password")
	
	public void  verifyLoginWithValidCredentials() throws IOException
	{
		
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginSheet");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginSheet");
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		
		
		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();	
	}
	
@Test(priority=2, description= "Verify Login with Valid username and invalid password")
public void verifyValidusernameInvalidPassword() throws IOException
{
	String usernameValue=ExcelUtility.getStringData(2, 0, "LoginSheet");
	String passwordValue=ExcelUtility.getStringData(2, 1, "LoginSheet");
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	
	
	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
	
}

@Test(priority=3,description= "Verify Login with Inalid username and invalid password")
public void verifyInvalidusernamevalidPass() throws IOException
{
	String usernameValue=ExcelUtility.getStringData(3, 0, "LoginSheet");
	String passwordValue=ExcelUtility.getStringData(3, 1, "LoginSheet");
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	
	
	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
}


@Test(priority=4, description= "Verify Login with invalid username and valid password")
public void verifyInvalidusernameInvalidpassword() throws IOException
{
	
	String usernameValue=ExcelUtility.getStringData(4, 0, "LoginSheet");
	String passwordValue=ExcelUtility.getStringData(4, 1, "LoginSheet");
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	
	
	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
	
}
}
