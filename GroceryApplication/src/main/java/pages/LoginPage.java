package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver; // WebDriver instance 
	//Constructor to pass driver to the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void enterUserName(String usernameValue) {
		
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		
		}
	public void enterPassword(String passwordValue){
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);	
		
	}
	public void signin() {
		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();	
	}

	
}
