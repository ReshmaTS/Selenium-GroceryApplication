package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import freemarker.template.utility.Constants;
import utilities.ScreenshotUtility;

public class TestNGBase 
{
	
	Properties prop;
	FileInputStream f;
	
	
	 public  WebDriver driver;
	 @Parameters("browser")
	 
	@BeforeMethod(alwaysRun = true) 
//	public void initializeBrowser()
	 
	 // pass parameter for 
public void initializeBrowser(String browser) throws Exception
	 {
	prop = new Properties();
	f= new FileInputStream(Constant.CONFIGFILE);
	prop.load(f);

	// this is for crossbrowser testing
if(browser.equalsIgnoreCase("chrome"))
		{
	ChromeOptions options = new ChromeOptions();
	Map<String,Object> prefs=new HashMap<>();
	prefs.put("profile.password_manager_leak_detection", false);
	options.setExperimentalOption("prefs", prefs);
	driver=new ChromeDriver(options);
		}
else if(browser.equalsIgnoreCase("firefox"))
{
	driver=new FirefoxDriver();
}
else 
{
	System.out.println("Invalid Browser");
}

		//	{
		//ChromeOptions options = new ChromeOptions();
					//Map<String,Object> prefs=new HashMap<>();
					//prefs.put("profile.password_manager_leak_detection", false);
					//options.setExperimentalOption("prefs", prefs);
					//driver=new ChromeDriver(options);
				//driver=new ChromeDriver();
				//driver=new FirefoxDriver();
				// driver=new EdgeDriver();
				// open url
			//	driver.get("https://groceryapp.uniqassosiates.com/admin/login");
				// maximize the tab
				//driver.manage().window().minimize();	
			//}


driver.get(prop.getProperty("url"));
driver.manage().window().maximize();

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
