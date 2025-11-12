package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver; // WebDriver instance 
	//Constructor to pass driver to the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;	
		
		// page factory initialization 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")WebElement username;
	public void enterUserName(String usernameValue)
	   {
		// Commented below line for pagefactory.
		//WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		}
	
	
	@FindBy(xpath="//input[@name='password']")WebElement password;
	public void enterPassword(String passwordValue)
	{
		//WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);	
	}
	
	
	@FindBy(xpath="//button[@type='submit']")WebElement signIn;
	public void signin() {
		//WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();	
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
