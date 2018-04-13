package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	public WebDriver driver;
@DataProvider(name="Authentication")
public Object[][] getData()
{
	Object[][] data=new Object[2][2];
	data[0][0]="accountvalidation";
	data[0][1]="abc@1234";
	data[1][0]="dcw.qa";
	data[1][1]="abc@1234";
	return data;
}
@Test(dataProvider="Authentication")
public void test(String Username , String Password) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\New folder\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
	System.out.println("username is:" +Username);
	System.out.println("password is "+Password);
	driver.get("https://admin-dce.unifiedcloudit.com");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.id("xusername")).sendKeys(Username);
	driver.findElement(By.id("password")).sendKeys(Password);
	driver.findElement(By.className("normalButton")).click();
	System.out.println("logged in ");
	Actions action=new Actions(driver);
	WebElement signouticon=driver.findElement(By.xpath("html/body/header/div/div[3]/div/span[2]/span/img"));
	signouticon.click();
	WebDriverWait wait=new WebDriverWait(driver, 60);
	WebElement signouttext=driver.findElement(By.xpath(".//*[@id='settingsmenu_div']/a"));
	wait.until(ExpectedConditions.visibilityOf(signouttext));
	signouttext.click();
	
//	WebElement signouttext=driver.findElement(By.xpath(".//*[@id='settingsmenu_div']/a"));
	//action.moveToElement(signouticon).click().pause(2000).moveToElement(signouttext).click();
	
	
	//Thread.sleep(4000);
	
	
	System.out.println("successfullly logged out");
}
}
