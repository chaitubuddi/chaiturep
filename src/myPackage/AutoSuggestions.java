package myPackage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestions {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.co.in");
	WebElement E=driver.findElement(By.id("lst-ib"));
	E.sendKeys("selenium");
	WebElement ul=driver.findElement(By.className("sbsb_b"));
	List <WebElement> lic=ul.findElements(By.tagName("li"));
	for(WebElement li: lic)
	{
		//String itemname=li.findElement(By.className("sbqs_c")).getText();
		String itemname=li.findElement(By.cssSelector("div.sbqs_c")).getText();
		System.out.println(itemname);
	if(itemname.equals("selenium webdriver"))
	{
		li.click();
	break;
	}
	}
	Thread.sleep(1000);
	driver.quit();
	
	/*Iterator <WebElement> it=lic.iterator();
	while(it.hasNext())
	{
		WebElement Lil =  it.next();   
		//String itemlist=Lil.findElement(By.xpath("//div[@class='sbqs_c']")).getText();
		 String data=Lil.findElement(By.cssSelector("div.sbqs_c")).getText();
		System.out.println(data);
		
	}
	driver.quit();*/
}
}
