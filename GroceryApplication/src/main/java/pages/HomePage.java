package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	
	
	// waitutility object
    WaitUtility waitutility=new WaitUtility();
	
	public WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver = driver;
	
	// page factory initialization 
			PageFactory.initElements(driver, this);
			// WAIT 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	
	
	@FindBy(xpath="//a[@class='nav-link']//img[@class='img-circle']")WebElement admin;
	public void adminButton() {
		
		// explicit wait
		waitutility.waitUntilClickable(driver,admin);
		
		//WebElement admin=driver.findElement(By.xpath("//a[@class='nav-link']//img[@class='img-circle']"));
		admin.click();
		
		
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//child ::i[@class='ace-icon fa fa-power-off']")WebElement logout;
public void logout() {
	//WebElement logout=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//child ::i[@class='ace-icon fa fa-power-off']"));
	logout.click();
}

}

