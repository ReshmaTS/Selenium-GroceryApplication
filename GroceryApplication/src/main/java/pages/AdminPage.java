package pages;

import java.time.Duration;

import org.apache.logging.log4j.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.PageUtility;
//import org.testng.Assert;
import utilities.WaitUtility;

public class AdminPage {
	
	// waitutility object
    WaitUtility waitutility=new WaitUtility();
    
	PageUtility pageutility=new PageUtility();

	public WebDriver driver;
	public AdminPage(WebDriver driver) {
	this.driver = driver;
	
	// page factory initialization 
			PageFactory.initElements(driver, this);
			
			
			// Implicit Wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	
	/* 
	 // cut and paste this in Home page for chaining
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusers;
public void adminUsers()
{
	//WebElement adminusers=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
	//adminusers.click();
	
	pageutility.clickOnElement(adminusers);
	
}

  */
	
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newAdmin;
	public AdminPage newUser()
	{
		//WebElement newAdmin=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		//newAdmin.click();
		pageutility.clickOnElement(newAdmin);
		return this;
	}
	
	@FindBy(xpath="//input[@name='username']")WebElement newusername;
	public AdminPage newUsername(String randomUsername)
	{
		//WebElement newusername=driver.findElement(By.xpath("//input[@name='username']"));
		//newusername.sendKeys(randomUsername);
		pageutility.sendDataToElement(newusername , randomUsername);
		return this;
	}

	@FindBy(xpath="//input[@name='password']")WebElement newpassword;
	public AdminPage newPassword(String randomPassword)
	{
		//WebElement newpassword=driver.findElement(By.xpath("//input[@name='password']"));
		//newpassword.sendKeys(randomPassword);
		pageutility.sendDataToElement(newpassword , randomPassword);
		return this;
		
	}
	
	@FindBy(xpath="//select[@id='user_type']")WebElement dropdown;
	public AdminPage dropdownOption()
	{
	
	//--> istead of this line we use @FindBy ...
     //WebElement dropdown=driver.findElement(By.xpath("//select[@id='user_type']"));
		
		//Select userType=new Select(dropdown);
		//userType.selectByVisibleText("Staff");
		// using constant 
		//userType.selectByVisibleText(Constant.USERTYPE_STAFF);
		pageutility.dropdownOption(dropdown);
		return this;
		
	}
	
	@FindBy(xpath="//button[@type='submit' and @name='Create']")WebElement saveAdmindetails;
	public AdminPage saveAdmin()
	{
		// explicit wait
				waitutility.waitUntilClickable(driver,saveAdmindetails);
		
		//WebElement saveAdmindetails=driver.findElement(By.xpath("//button[@type='submit' and @name='Create']"));
		 //saveAdmindetails.click();
				pageutility.clickOnElement(saveAdmindetails);
				return this;
	}
	
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successfulalert;
	public boolean isSuccessAlertDisplayed() {
	    //WebElement successfulalert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
	    return successfulalert.isDisplayed();
	   
	}
	
	
	
}
