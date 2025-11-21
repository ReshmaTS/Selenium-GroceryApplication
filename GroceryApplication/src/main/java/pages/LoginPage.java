package pages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	
	// waitutility object
    WaitUtility waitutility=new WaitUtility();
    
    // CREATE OBJECT OF PPageUtility class
    PageUtility pageutility=new PageUtility();
    
    
	public WebDriver driver; // WebDriver instance 
	
	//Constructor to pass driver to the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;	
		
		// page factory initialization 
		PageFactory.initElements(driver, this);
		// IMPLICIT WAIT
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@FindBy(xpath="//input[@name='username']")WebElement username;
	
	//public void enterUserName(String usernameValue)
// change void to LoginPage (Chaining)
	public LoginPage enterUserName(String usernameValue)
	   {
		// Commented below line for pagefactory.
		//WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		//username.sendKeys(usernameValue);
		
		// call pageuitily
		pageutility.sendDataToElement(username, usernameValue);
		return this;
		}
	
	
	@FindBy(xpath="//input[@name='password']")WebElement password;
	public LoginPage enterPassword(String passwordValue)
	{
		//WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		pageutility.sendDataToElement(password, passwordValue);
		return this;
	}
	
	
	@FindBy(xpath="//button[@type='submit']")WebElement signIn;
	public HomePage signin() {
		//WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		
		// explicit wait
		waitutility.waitUntilClickable(driver,signIn);
		//signIn.click();
		pageutility.clickOnElement(signIn);
		return new HomePage(driver);
	}
	
	
	// assertion
		public String  validcredentialsAssertion()
		{
			String actual=driver.getTitle();
			return actual;		
	    }
		
		// assertion
	  public String Invalidcredentials()
	  {
		  String actual=driver.getCurrentUrl();
		  return actual;
	  }

}
