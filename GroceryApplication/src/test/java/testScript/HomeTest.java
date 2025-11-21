package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	
	public LoginPage login;
	public HomePage home;
	@Test(priority=1, description="verify Logout from admin,  grocery application ")
	public void adminLogout() throws IOException, InterruptedException
	{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginSheet");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginSheet");
		
		
		//Login to Grocery Application
				LoginPage loginpage = new LoginPage(driver);
				loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
				//loginpage.enterPassword(passwordValue);
				home=loginpage.signin();
		
		
		
		
		
		/*WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();	
		//wait for2.5sec before selecting admin 
		Thread.sleep(2500);  */
				
				
				//HomePage homepage = new HomePage(driver);
				home.adminButton();
				login=home.logout();
				
		/*		
	// admin profile selection
		WebElement admin=driver.findElement(By.xpath("//a[@class='nav-link']//img[@class='img-circle']"));
		admin.click();
		
		// Wait for 2.5 seconds before logout
		Thread.sleep(2500);
		// logout
		//WebElement logout=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//i[@class='ace-icon fa fa-power-off']"));
		WebElement logout=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//child ::i[@class='ace-icon fa fa-power-off']"));
		logout.click();
		
		*/
		
		//Assertion
	//	WebElement loginbox = driver.findElement(By.xpath("//p[@class='login-box-msg']"));
       
		//Assert.assertTrue(loginbox.isDisplayed(),"  Admin logout failed");

				// below line need to be corrected
		//Assert.assertTrue(loginpage.logindisplayed(), "Login box is NOT displayed!");
		
		
	}

}
