package hrmPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowEx1 {
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
        String Handle = driver.getWindowHandle();
        System.out.println(Handle);
        //clicking on New message window
        driver.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();
        String Handle1 = driver.getWindowHandle();
        System.out.println(Handle1);
        driver.switchTo().window(Handle1);
        Thread.sleep(3000);
        driver.close();
        System.out.println("child window closed");
        driver.quit();
	}
}
