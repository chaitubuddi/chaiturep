package hrmPackage;

 

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import javax.security.auth.kerberos.KerberosKey;

//import AWTPackage.AbstractWTKProgram;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {
public static void main(String[] args)throws AWTException, IOException, InterruptedException {
	//System.setProperty("webdriver.gecko.driver", "D:\\Selenium QAPlanet\\Drivers\\geckodriver-v0.15.0-win64\\geckodriver.exe");
	//System.setProperty("webdriver.chrome.driver", "D:\\Selenium QAPlanet\\Drivers\\chromedriver_win32\\chromedriver.exe");
	//FirefoxDriver driver=new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(driver, 60);
	Actions Act=new Actions(driver);
	driver.get("http://admin5.beta-wspbx.com");
	driver.findElement(By.id("xusername")).sendKeys("reporttest");
	driver.findElement(By.id("password")).sendKeys("abc@1234");
	driver.findElement(By.className("normalButton")).click();
	Thread.sleep(1000);
	WebElement viewlink=driver.findElement(By.linkText("View Manager"));
	WebElement deviceid=driver.findElement(By.id("tab3_10"));
	Act.moveToElement(viewlink).pause(3000).moveToElement(deviceid).click().build().perform();
	
	
}
}