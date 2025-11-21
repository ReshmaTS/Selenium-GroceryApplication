package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	
	
	// waitutility object
    WaitUtility waitutility=new WaitUtility();
    
    PageUtility pageutility=new PageUtility();
    
	
	public WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver = driver;
	
	// page factory initialization 
			PageFactory.initElements(driver, this);
			// WAIT 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	
	
	@FindBy(xpath="//a[@class='nav-link']//img[@class='img-circle']")WebElement admin;
	public HomePage adminButton() {
		
		// explicit wait
		waitutility.waitUntilClickable(driver,admin);
		
		//WebElement admin=driver.findElement(By.xpath("//a[@class='nav-link']//img[@class='img-circle']"));
		//admin.click();
		pageutility.clickOnElement(admin);
		return this;
		
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//child ::i[@class='ace-icon fa fa-power-off']")WebElement logout;
public LoginPage logout() {
	//WebElement logout=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//child ::i[@class='ace-icon fa fa-power-off']"));
	//logout.click();
	pageutility.clickOnElement(logout);
	return new LoginPage(driver);
}

@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminusers;
public AdminPage adminUsers()
{
	//WebElement adminusers=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
	//adminusers.click();
	
	pageutility.clickOnElement(adminusers);
	return new AdminPage(driver);
}


@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']")WebElement manageNews;
public NewsPage manageNewsButton()
{
	//WebElement manageNews=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']"));
	//manageNews.click();
	pageutility.clickOnElement(manageNews);
	return new NewsPage(driver);
}


@FindBy(xpath="//p[@class='login-box-msg']")WebElement loginbox;
public boolean logindisplayed()
{
	return loginbox.isDisplayed();
}

}

