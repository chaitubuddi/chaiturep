package myPackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithBrowsers {
public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://qaplanet.in/");
	//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[@class='social']/li[3]")).click();
    Thread.sleep(4000);
    Set <String> wl=driver.getWindowHandles();
    for(String w: wl)
    {
    	System.out.println(w);
    }
Iterator <String> it=wl.iterator();

	String first=it.next();
	String second=it.next();

driver.switchTo().window(second);
Thread.sleep(4000);
//to click on not now
driver.findElement(By.id("expanding_cta_close_button")).click();
Thread.sleep(2000);
if(driver.findElement(By.xpath("//div[@id='blueBarDOMInspector']/div/div/div/div/a/i")).isDisplayed())
{
	System.out.println("fb page is displayed");
}
else
{
	System.out.println("fb page not displayed");
}
	//switch to first window
driver.switchTo().window(first);
System.out.println("switched to first window");
driver.quit();
}
}
