package sortingandFilteringPack;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.collections.CollectionUtils;
class TableData
{
	public static WebDriver driver1;
	public static LinkedList<String> getTableColumnData(int column_no, String tableName)
	{
		LinkedList<String> values=new LinkedList<String>();
		
		WebElement table=driver1.findElement(By.id(tableName));
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		Iterator<WebElement> itr=rows.iterator();
		while(itr.hasNext())
		{
		WebElement row=itr.next();
		List<WebElement> columns=row.findElements(By.tagName("td"));
		Iterator<WebElement> itr1=columns.iterator();
		int count=0;
		String value;
		while(itr1.hasNext())
		{
			WebElement column=itr1.next();
			if(count==column_no)
			{
				String data=column.getText();
				value=data;
                values.add(value);
                break;			
			}
			count++;
		}
		}
		
		return values;
		
		
	}
	public static boolean isTableColumnSorted(LinkedList<String> expected, LinkedList<String> actual)
	{
		boolean result=false;
		Collections.sort(expected);
		if(expected==actual)
		result=true;
		
		return result;
		
	}
}
public class VerifySortingFuntionality extends TableData{
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
	public void verifySorting() throws InterruptedException
	{
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
			}
			else
			{
				getTableColumnData(3, "usercdrdata");
				//Collections.sort(valu);
				//isTableColumnSorted(LinkedList<String> values , actual);
			}
			driver.close();
			driver.switchTo().window(parentwindow);
			System.out.println("in parent window");
	}
}
}
