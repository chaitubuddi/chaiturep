package myPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowScrollBy {
	public static void main(String[] args) {
		
	
	//public void scrollDown(){
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.softwaretestingmaterial.com");
		//to perform Scroll on application using  Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,1050)", "");
		//to got ot bottom of the page
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//to got to web page up
		js.executeScript("window.scrollBy(0,-250)", "");
}
}