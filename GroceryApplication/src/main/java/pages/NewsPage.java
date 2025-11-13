package pages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class NewsPage 
{
	
	// waitutility object
    WaitUtility waitutility=new WaitUtility();
	
	public WebDriver driver;
	//Constructor 
	public NewsPage(WebDriver driver) {
		this.driver = driver;	
		
		// page factory initialization 
				PageFactory.initElements(driver, this);
				// IMPLICIT WAIT
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']")WebElement manageNews;
	public void manageNewsButton()
	{
		//WebElement manageNews=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']"));
		manageNews.click();
	}
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @class='btn btn-rounded btn-danger']")WebElement createnew;
	public void createNewsbutton()
	{
		//WebElement createnew=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @class='btn btn-rounded btn-danger']"));
		createnew.click();
	}
	
	@FindBy(id="news")WebElement textbox;
	public void enterNews()
	{
		//WebElement textbox=driver.findElement(By.id("news"));
		textbox.sendKeys("Todays news Headlines");
	}
	
	@FindBy(xpath="//button[@name='create']")WebElement save;
	public void savebutton()
	{
		
		// explicit wait
		waitutility.waitUntilClickable(driver,save);
		
		//WebElement save=driver.findElement(By.xpath("//button[@name='create']"));
		save.click();
	}
	
	
	public boolean isSuccessAlertDisplayed() {
	    return driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed();
	}
	
	
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement newssearch;
	public void searchButton()
	{
		//WebElement newssearch=driver.findElement(By.xpath("//a[@onclick='click_button(2)']"));
		newssearch.click();
	}
	
	@FindBy(xpath="//input[@class='form-control']")WebElement todaysnews;
	public void searchTopicinTextbox()
	{
		//WebElement  todaysnews=driver.findElement(By.xpath("//input[@class='form-control']"));
		todaysnews.sendKeys("Todays headlines");
	}
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement searchnews;
	public void searchNews()
	{
		//WebElement  searchnews=driver.findElement(By.xpath("//button[@class='btn btn-danger btn-fix']"));
		searchnews.click();
	}
	
	
	public String searchbuttonAssertion()
	{
        return driver.getCurrentUrl();
    }
	
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")WebElement backtoHome;
	public void backtoHome()
	{
		//WebElement backtoHome=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/home']"));
		backtoHome.click();
	}
	
	
	public String backtohomeAssertion()
	{
		 return driver.getCurrentUrl();
	}
	
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement reset;
	public void resetbutton()
	{
		//WebElement reset=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-warning']"));
		reset.click();
	}
	
	public String reseteAssertion()
	{
		 return driver.getCurrentUrl();
	}
	
	
	
	public boolean assertionrefresh()
	{
		String actualMessage=driver.getCurrentUrl();
		String expectedMessage = "https://groceryapp.uniqassosiates.com/admin/list-news";
		return actualMessage.equals(expectedMessage); 
	}
}
