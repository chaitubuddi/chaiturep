package hrmPackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestwindowEx {
	public static WebDriver driver;
	public static void main(String[] args ) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.codeproject.com");
        Set<String> codeprojectWindowID = driver.getWindowHandles();
		System.out.println("Main Window Handle ----------------- " + codeprojectWindowID);

		Iterator<String> it = codeprojectWindowID.iterator();

		while (it.hasNext()) {
		    // Get element
		    Object element = it.next();
		    System.out.println(element);
		}
		driver.findElement(By.xpath("//*[@id='C']/div[1]/div[3]/a[2]/img")).click();
		// Go to second window and click on forgot password link

				codeprojectWindowID = driver.getWindowHandles();
				it = codeprojectWindowID.iterator();
				String MainWindowHandle = it.next();
				String NewWindowHandle = it.next();
				System.out.println(MainWindowHandle);
				System.out.println(NewWindowHandle);

				Thread.sleep(3000);

				driver.switchTo().window(NewWindowHandle);
			driver.findElement(By.xpath("//*[@id='link-forgot-passwd']")).click();

				// Go to 3rd popup window and click on Submit button

				codeprojectWindowID = driver.getWindowHandles();
				it = codeprojectWindowID.iterator();
				it.next();
				it.next();

				String NewPopUPWindow = it.next();

				driver.switchTo().window(NewPopUPWindow);

				driver.findElement(By.xpath("//input[@class='button g-button g-button-submit']")).click();

				// Close all Opened windows
				driver.close();

				driver.switchTo().window(NewWindowHandle);
				driver.close();

				driver.switchTo().window(MainWindowHandle);
				driver.close();



	}
	
}
