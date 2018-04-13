package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TooltipProgram {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.co.in");
	String tooltip=driver.findElement(By.id("lst-ib")).getAttribute("title");
System.out.println(tooltip);	
driver.quit();
}
}
