package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import constants.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase{
	public HomePage homepage;
	public AdminPage adminpage;
	@Test(priority=1, description="verify create new admin")
	public void verifyAdminTest() throws IOException, InterruptedException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginSheet");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginSheet");
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.signin();
		adminpage=homepage.adminUsers();
		
		/*
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();	
		*/
		
		
		/*
		// Admin users
		WebElement adminusers=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminusers.click();
		Thread.sleep(2500);
		//nEW
		WebElement newAdmin=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newAdmin.click();
		Thread.sleep(2500);
		
		*/
		
		FakerUtility fakerUtility=new FakerUtility();
		String randomUsername=fakerUtility.createRandomUserName();
		String randomPassword=fakerUtility.createRandomPassword();
		
		
		/*
		WebElement newusername=driver.findElement(By.xpath("//input[@name='username']"));
		newusername.sendKeys(randomUsername);
		
		WebElement newpassword=driver.findElement(By.xpath("//input[@name='password']"));
		newpassword.sendKeys(randomPassword);
		
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='user_type']"));
		
		Select userType=new Select(dropdown);
	//	userType.selectByVisibleText("Staff");
		userType.selectByVisibleText(Constants.USERTYPE_STAFF);
		
		WebElement saveAdmindetails=driver.findElement(By.xpath("//button[@type='submit' and @name='Create']"));
		 saveAdmindetails.click();
		 */
		
		//Page object model 
		//AdminPage adminpage=new AdminPage(driver);
		//adminpage.adminUsers();
		//adminpage.newUser();
		 /*adminpage.newUsername(randomUsername);
		adminpage.newPassword(randomPassword);
		adminpage.dropdownOption();
		adminpage.saveAdmin(); */
		adminpage.newUser().newUsername(randomUsername).newPassword(randomPassword).dropdownOption().saveAdmin();
		adminpage.isSuccessAlertDisplayed();
		
		 // Assertion
		// WebElement successfulalert=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		// return successfulalert.isDisplayed();
		
		
		   // Assert.assertTrue(adminpage.isSuccessAlertDisplayed(), "Success alert is not displayed!");
		    
		    Assert.assertTrue(adminpage.isSuccessAlertDisplayed(),Messages.CREATE_NEW_ADMIN);
		    
		}
	}


