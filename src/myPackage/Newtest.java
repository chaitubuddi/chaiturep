package myPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newtest {
public static void main(String[] args) {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	driver.get("https://www.google.com");
	System.out.println("crome loaded");
	driver.navigate().to("https://www.gmail.com");
	System.out.println("gmail loaded");
}
}
