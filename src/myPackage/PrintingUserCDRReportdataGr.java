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

public class PrintingUserCDRReportdataGr {
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
			//Thread.sleep(2000);
		System.out.println("clicked on user cdr");
		WebElement pagedrop = driver.findElement(By.name("paginationdtoObj.goTo"));
		Select PageDropdown = new Select(pagedrop);
		int pages = PageDropdown.getOptions().size();
		System.out.println(pages);
		
		
		
		for (int i = 1 ; i <= pages; i++)
		{
			
			//List <WebElement> totalrows = driver.findElements(By.xpath("//table[@id='usercdrdata']/tbody/tr"));
			//int rowsize=totalrows.size();
			
			if (i>1 && i<= pages)
			{
			System.out.println("Inside the if loop with value" +i);
			String s1 = String.valueOf(i);
		      // Thread.sleep(1000);
			driver.findElement(By.linkText(s1)).click();
			//List <WebElement> totalrows = driver.findElements(By.xpath("//table[@id='usercdrdata']/tbody/tr"));
			//int rowsize=totalrows.size();
			System.out.println("Selected the Page:::" +i);
			//Thread.sleep(9000);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='statusMessage_div']/span"), "Processing"));
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='statusMessage_div']/span")));
			
			List <WebElement> totalrows = driver.findElements(By.xpath("//table[@id='usercdrdata']/tbody/tr"));
			int rowsize=totalrows.size();
			//System.out.println("Sleep time Finished");
			for(int row1=1;row1<=rowsize;row1++)
			  {
				 String UserName =driver.findElement(By.xpath("//table[@id='usercdrdata']/tbody/tr["+row1+"]/td[3]")).getText();
				 System.out.println(UserName);
			  }
			}
			
			List <WebElement> totalrows1 = driver.findElements(By.xpath("//table[@id='usercdrdata']/tbody/tr"));
			int rowsize1=totalrows1.size();
			    for(int row=1;row<=rowsize1;row++)
			     {
			   
			    	
				 String UserName =driver.findElement(By.xpath("//table[@id='usercdrdata']/tbody/tr["+row+"]/td[3]")).getText();
				 System.out.println(UserName);
			    	
			    }
		    
		}
		
		
		driver.close();
		driver.switchTo().window(parentwindow);
		System.out.println("in parent window");
	}
	
	
	}
}

	