package pages;

import org.apache.logging.log4j.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
//import org.testng.Assert;

public class AdminPage {
	

	public WebDriver driver;
	public AdminPage(WebDriver driver) {
	this.driver = driver;
}
	
	public void adminUsers()
	{
		WebElement adminusers=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminusers.click();
	}
	
	public void newUser()
	{
		WebElement newAdmin=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newAdmin.click();
	}
	
	public void newUsername(String randomUsername)
	{
		WebElement newusername=driver.findElement(By.xpath("//input[@name='username']"));
		newusername.sendKeys(randomUsername);
	}

	
	public void newPassword(String randomPassword)
	{
		WebElement newpassword=driver.findElement(By.xpath("//input[@name='password']"));
		newpassword.sendKeys(randomPassword);
		
	}
	
	public void dropdownOption()
	{
WebElement dropdown=driver.findElement(By.xpath("//select[@id='user_type']"));
		
		Select userType=new Select(dropdown);
		//userType.selectByVisibleText("Staff");
		userType.selectByVisibleText(Constant.USERTYPE_STAFF);
		
	}
	
	public void saveAdmin()
	{
		WebElement saveAdmindetails=driver.findElement(By.xpath("//button[@type='submit' and @name='Create']"));
		 saveAdmindetails.click();
	}
	
	
	
	public boolean isSuccessAlertDisplayed() {
	    WebElement successfulalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
	    return successfulalert.isDisplayed();
	}
	
	
	
}
