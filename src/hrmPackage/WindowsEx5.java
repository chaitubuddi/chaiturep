package hrmPackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsEx5 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://site22.way2sms.com/content/index.html");
        String mainwindow=driver.getWindowHandle();
        System.out.println(mainwindow);
        driver.findElement(By.linkText("Contact")).click();
        Set <String> allhandles=driver.getWindowHandles();
        Iterator<String> itr=allhandles.iterator();
        while(itr.hasNext())
        {
        	String childwindow=itr.next();
        	driver.switchTo().window(childwindow);
        	System.out.println(childwindow);
    		System.out.println("the popup title is:" + driver.getTitle());
    		if(driver.getTitle().equals("Way2SMS - Contact"))
    		{
    			System.out.println("in popup window");
    			System.out.println(driver.getCurrentUrl());
    		}
        }
      driver.close();
      driver.switchTo().window(mainwindow);
      System.out.println("in main window");
      driver.quit();
}
}