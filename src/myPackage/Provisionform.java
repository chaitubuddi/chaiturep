package myPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Provisionform {
	public WebDriver driver;
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
	public void csdTest()
	{
		driver.get("https://admin5.beta-wspbx.com/adminfive/signuppages/CSDLoginAction.action");
	try{
		driver.findElement(By.xpath(".//*[@id='CSDLoginAction_dealerinfo_dealername']")).sendKeys("qa");
	driver.findElement(By.xpath(".//*[@id='CSDLoginAction_dealerinfo_dpassword']")).sendKeys("abc@1234");	
	driver.findElement(By.xpath(".//*[@id='CSDLoginAction_submit']")).click();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("clicked");
	}
}
