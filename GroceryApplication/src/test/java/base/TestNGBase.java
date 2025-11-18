package base;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameters;

import utilities.ScreenshotUtility;

public class TestNGBase 
{
	 public  WebDriver driver;
	// @Parameters("browser")
	 
	@BeforeMethod(alwaysRun = true) 
	
public void initializeBrowser()
			{
		ChromeOptions options = new ChromeOptions();
					Map<String,Object> prefs=new HashMap<>();
					prefs.put("profile.password_manager_leak_detection", false);
					options.setExperimentalOption("prefs", prefs);
					driver=new ChromeDriver(options);
				//driver=new ChromeDriver();
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
		
		
		// for Screenshot 
		@AfterMethod(alwaysRun = true)
		public void driverQuit(ITestResult iTestResult) throws IOException
		{
			if(iTestResult.getStatus()==ITestResult.FAILURE)
			{
				ScreenshotUtility screenShot=new ScreenshotUtility();
				screenShot.getScreenshot(driver, iTestResult.getName());
			}
			driver.quit();

		}
}
