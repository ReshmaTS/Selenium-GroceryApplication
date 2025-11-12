package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver = driver;
	
	// page factory initialization 
			PageFactory.initElements(driver, this);
}
	
	
	@FindBy(xpath="//a[@class='nav-link']//img[@class='img-circle']")WebElement admin;
	public void adminButton() {
		
		//WebElement admin=driver.findElement(By.xpath("//a[@class='nav-link']//img[@class='img-circle']"));
		admin.click();
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//child ::i[@class='ace-icon fa fa-power-off']")WebElement logout;
public void logout() {
	//WebElement logout=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//child ::i[@class='ace-icon fa fa-power-off']"));
	logout.click();
}

}

