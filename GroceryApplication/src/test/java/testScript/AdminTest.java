package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase{
	
	@Test
	public void verifyAdminTest() throws IOException, InterruptedException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginSheet");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginSheet");
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();	
		
		// Admin users
		WebElement adminusers=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminusers.click();
		Thread.sleep(2500);
		//nEW
		WebElement newAdmin=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newAdmin.click();
		Thread.sleep(2500);
		
		FakerUtility fakerUtility=new FakerUtility();
		String randomUsername=fakerUtility.createRandomUserName();
		String randomPassword=fakerUtility.createRandomPassword();
		
		WebElement newusername=driver.findElement(By.xpath("//input[@name='username']"));
		newusername.sendKeys(randomUsername);
		
		WebElement newpassword=driver.findElement(By.xpath("//input[@name='password']"));
		newpassword.sendKeys(randomPassword);
		
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='user_type']"));
		
		Select userType=new Select(dropdown);
		userType.selectByVisibleText("Staff");
		
		WebElement saveAdmindetails=driver.findElement(By.xpath("//button[@type='submit' and @name='Create']"));
		 saveAdmindetails.click();
		 
		 // Assertion
		 WebElement successfulalert=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		 Assert.assertTrue(successfulalert.isDisplayed()," login page not displayed");
	}

}
