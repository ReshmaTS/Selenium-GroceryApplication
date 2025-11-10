package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage 
{
	
	public WebDriver driver;
	//Constructor 
	public NewsPage(WebDriver driver) {
		this.driver = driver;		
	}

	public void manageNewsButton()
	{
		WebElement manageNews=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and@class='small-box-footer']"));
		manageNews.click();
	}
	
	public void createNewsbutton()
	{
		WebElement createnew=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @class='btn btn-rounded btn-danger']"));
		createnew.click();
	}
	public void enterNews()
	{
		WebElement textbox=driver.findElement(By.id("news"));
		textbox.sendKeys("Todays news Headlines");
	}
	public void savebutton()
	{
		WebElement save=driver.findElement(By.xpath("//button[@name='create']"));
		save.click();
	}
}
