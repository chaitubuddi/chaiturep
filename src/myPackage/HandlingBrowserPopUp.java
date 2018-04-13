package myPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingBrowserPopUp {
	WebDriver driver;
	@BeforeMethod
	public void beforeSetup()
	{
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\New folder\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void afterSetup()
	{
	driver.quit();	
	
	}
	
	@Test
	public void handlingBrowserpop() throws IOException
	{
		Runtime.getRuntime().exec("D:\\LatestSeleniumScripts\\AutoITPrograms\\AutenticationReq.exe");
		driver.get("https://www.engprod-charter.net/");
		
	}
	
}
