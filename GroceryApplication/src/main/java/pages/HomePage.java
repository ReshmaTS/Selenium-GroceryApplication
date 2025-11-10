package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver = driver;
}
	public void adminButton() {
		
		WebElement admin=driver.findElement(By.xpath("//a[@class='nav-link']//img[@class='img-circle']"));
		admin.click();
	}
	
public void logout() {
	WebElement logout=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']//child ::i[@class='ace-icon fa fa-power-off']"));
	logout.click();
}

}

