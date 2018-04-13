package hrmPackage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsEx2 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Launch the URL

        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        String handle= driver.getWindowHandle();

        System.out.println(handle);
        driver.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();
        Set handles = driver.getWindowHandles();
        
        System.out.println(handles);
        for(String handle1: driver.getWindowHandles())
        {
        	driver.switchTo().window(handle1);
        	System.out.println(handle1);
        }
        //closing the pop up window
        driver.close();
        System.out.println("child window is closed");
        //closing original window	
        driver.quit();
        //clicking on New message window
}
}
