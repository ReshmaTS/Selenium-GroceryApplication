package base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBase 
{
	 public  WebDriver driver;
	 
	@BeforeMethod 
public void initializeBrowser()
			{
				driver=new ChromeDriver();
				//driver=new FirefoxDriver();
				// driver=new EdgeDriver();
				// open url
				driver.get("https://groceryapp.uniqassosiates.com/admin/login");
				
				// maximize the tab
				driver.manage().window().maximize();
				//driver.manage().window().minimize();	
			}
		@AfterMethod	
			public void closeBrowser()
			{
				// close the tab only
				//driver.close();
				
				//close entire window
				//driver.quit();
				//System.out.println("Browser closed");
			}
}
