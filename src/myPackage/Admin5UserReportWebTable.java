package myPackage;


import static org.testng.Assert.expectThrows;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Program for Printing total records for user cdr in gr

public class Admin5UserReportWebTable {
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
		//driver.switchTo().activeElement().sendKeys();
		driver.get("https://admin-dce.unifiedcloudit.com");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.id("xusername")).sendKeys("accountvalidation");
	driver.findElement(By.id("password")).sendKeys("abc@1234");
	driver.findElement(By.className("normalButton")).click();
	Actions action=new Actions(driver);
	WebElement reportlink = driver.findElement(By.linkText("Report Manager"));
	WebElement graphicaltab = driver.findElement(By.id("tab6_253"));
	action.moveToElement(reportlink).pause(3000).moveToElement(graphicaltab).click().perform();
	Set<String> windows = driver.getWindowHandles();
	Iterator<String> itr=windows.iterator();
	while(itr.hasNext())
	{
		String parentwindow=itr.next();
		String childwindow=itr.next();
		driver.switchTo().window(childwindow);
		System.out.println("in child window");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlayDiv")));
		//wait.until(ExpectedConditions.presenceOfElementLocated((By.id("summarygraphmainid"))));
		System.out.println("summary page loaded");
		//code to click on user tab
		
		WebElement usertablink = driver.findElement(By.xpath("//a[@id='ptctabid2']/div"));
		action.moveToElement(usertablink).click().build().perform();
		
		String s=driver.findElement(By.id("overlayDiv")).getCssValue("display");
		System.out.println(s);
		System.out.println("clicked on user tab");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlayDiv")));
	//waiting until the summary page loads
		System.out.println("waiting for user summary page is completed");	
			//click on select report user cdr
		//clicking on select report 
		WebElement selectreport=driver.findElement(By.xpath("//*[@id='usersummary']/div[1]/div[1]/div[1]/div[1]/span[2]"));
		System.out.println("clicked on select report");
		//usercdrlink path
		WebElement usercdrlink = driver.findElement(By.xpath("//div[@id='calendarpopupin_id_selreport']/div[1]"));
		action.moveToElement(selectreport).click().pause(3000).moveToElement(usercdrlink).click().build().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlayDiv")));
			Thread.sleep(2000);
		System.out.println("clicked on user cdr");
		//selecting pages from Jump dropdown
		Select select=new Select(driver.findElement(By.id("paginationdtoObj_pgnumber_topfrm")));
		List<WebElement> elements = select.getOptions();
		int size=elements.size();
		if(size>1)
		{
		select.selectByIndex(size-1);
		
	
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='statusMessage_div']/span"), "Processing"));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='statusMessage_div']/span")));
		
		System.out.println("sucessfully waited");
				String value=driver.findElement(By.name("paginationdtoObj.recordsto")).getAttribute("value");
		System.out.println("total count is" +value);
		
		}
		else
		{
			String value=driver.findElement(By.name("paginationdtoObj.recordsto")).getAttribute("value");
			System.out.println("total count is" +value);
		}
		
		driver.close();
		driver.switchTo().window(parentwindow);
		System.out.println("in parent window");
	}
	
	
	}
}
