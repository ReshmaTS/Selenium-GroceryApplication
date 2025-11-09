package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNGBase;
import utilities.ExcelUtility;


public class NewsTest extends TestNGBase
{
@Test(priority=1, description="verify user is able to create a news in Manage news")
		public void verifyManageNews() throws IOException
		{
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginSheet");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginSheet");
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
		signIn.click();	
		
		// manage News
		WebElement manageNews=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']"));
		manageNews.click();
		
		WebElement createnew=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @class='btn btn-rounded btn-danger']"));
		createnew.click();
		// text news
		WebElement textbox=driver.findElement(By.id("news"));
		textbox.sendKeys("Todays news Headlines");
		//save the news
		WebElement save=driver.findElement(By.xpath("//button[@name='create']"));
		save.click();
		
		
		
		//Assertion
		WebElement newalertbox = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		Assert.assertTrue(newalertbox.isDisplayed(), "News created successfully alert box not displayed");
		
	}


@Test(priority=2, description="Verify that the Search button works correctly and displays results in ManageNews")
public void searchNews() throws IOException, InterruptedException
{
	String usernameValue=ExcelUtility.getStringData(1, 0, "LoginSheet");
	String passwordValue=ExcelUtility.getStringData(1, 1, "LoginSheet");
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
	
	// manage News
	WebElement manageNews=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']"));
	manageNews.click();
	Thread.sleep(2500);
	// click on search option
	WebElement newssearch=driver.findElement(By.xpath("//a[@onclick='click_button(2)']"));
	newssearch.click();
	Thread.sleep(2500);
	// enter a message in text box
	WebElement  todaysnews=driver.findElement(By.xpath("//input[@class='form-control']"));
	todaysnews.sendKeys("Todays headlines");
	Thread.sleep(2500);
	// search button simulation
	WebElement  searchnews=driver.findElement(By.xpath("//button[@class='btn btn-danger btn-fix']"));
	searchnews.click();
	Thread.sleep(2500);	
	
	
	String actualMessage=driver.getCurrentUrl();
	String expectedMessage = "https://groceryapp.uniqassosiates.com/admin/news/index";
	Assert.assertEquals(actualMessage, expectedMessage);
}

@Test(priority=3, description="Verify user can go back to Home page by clicking Home button from Manage News page")

public void verifyBacktoHomeFromManageNews() throws IOException, InterruptedException
{
	String usernameValue=ExcelUtility.getStringData(1, 0, "LoginSheet");
	String passwordValue=ExcelUtility.getStringData(1, 1, "LoginSheet");
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
	
	// manage News
	WebElement manageNews=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']"));
	manageNews.click();
	Thread.sleep(2500);
	
// Back to home 
	WebElement backtoHome=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/home']"));
	backtoHome.click();
	

	String actualMessage=driver.getCurrentUrl();
	String expectedMessage = "https://groceryapp.uniqassosiates.com/admin/home";
	Assert.assertEquals(actualMessage, expectedMessage);
	
}

@Test(priority=4, description="Verify that Reset button reloads the current page successfully")
public void verifyResetinmanageNews() throws InterruptedException, IOException
{
	String usernameValue=ExcelUtility.getStringData(1, 0, "LoginSheet");
	String passwordValue=ExcelUtility.getStringData(1, 1, "LoginSheet");
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernameValue);
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
	signIn.click();	
	
	// manage News
	WebElement manageNews=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']"));
	manageNews.click();
	Thread.sleep(2500);
	// reset
	WebElement reset=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
	reset.click();
	
	
	String actualMessage=driver.getCurrentUrl();
	String expectedMessage = "https://groceryapp.uniqassosiates.com/admin/list-news";
	Assert.assertEquals(actualMessage, expectedMessage);
	
}


}
