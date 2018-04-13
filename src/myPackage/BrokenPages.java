package myPackage;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.jna.platform.FileUtils;

public class BrokenPages {
	public WebDriver driver;
	@BeforeMethod
	public void beforeSetup()
	{
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\New folder\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterSetup()
	{
	driver.quit();	
	
	}
	
	@Test
	public void userReportDownload() throws InterruptedException
	{
	
		driver.get("https://streamsadmin5.beta-wspbx.com");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.id("xusername")).sendKeys("sagarsingh@gr.calls");
	driver.findElement(By.id("password")).sendKeys("abc@1234");
	driver.findElement(By.className("normalButton")).click();
	
	
	Actions action=new Actions(driver);
	//action.moveToElement(driver.findElement(By.className(""))).sendKeys(keys)
	//action.keyDown(Keys.CONTROL).sendKeys(Keys.F5);
	WebElement accountlevelservicemanager=driver.findElement(By.linkText("Account Level Service Manager"));
	Point point = accountlevelservicemanager.getLocation();
	int xcord=point.getX();
	int ycord=point.getY();
	System.out.println("x cord is:"+xcord);
	System.out.println("y cord is :"+ycord);
	int height=accountlevelservicemanager.getSize().getHeight();
	int width=accountlevelservicemanager.getSize().getWidth();
	System.out.println(height);
	System.out.println(width);
	WebElement sitesurveylink=driver.findElement(By.xpath(".//*[@id='tab4_40']"));
	WebElement sitesurveysublink=driver.findElement(By.xpath(".//*[@id='tab4_40_163']"));
	action.moveToElement(accountlevelservicemanager).pause(3000).moveToElement(sitesurveylink).pause(2000).moveToElement(sitesurveysublink).click().build().perform();

	Set<String> windows = driver.getWindowHandles();
	Iterator<String> itr=windows.iterator();
	while(itr.hasNext())
	{
		String parentwindow=itr.next();
		String childwindow=itr.next();
		driver.switchTo().window(childwindow);
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();	
	System.out.println(url);
	System.out.println(title);
	driver.close();
	}

	}
@Test
public void test() throws IOException
{
	EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
	File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
	org.apache.commons.io.FileUtils.copyFile(srcFile, new File("C://"));
}

@Test
public void test1() throws IOException
{
	File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
	File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
	org.apache.commons.io.FileUtils.copyFile(srcFile, new File("C://"));
}

}
