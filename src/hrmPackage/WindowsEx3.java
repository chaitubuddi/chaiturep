package hrmPackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsEx3 {
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
     // It will return the parent window name as a String
        String parent=driver.getWindowHandle();
        driver.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();
     // This will return the number of windows opened by Webdriver and will return Set of St//rings
        Set<String>s1=driver.getWindowHandles();

     // Now we will iterate using Iterator
     Iterator<String> I1= s1.iterator();

     while(I1.hasNext())
     {

        String child_window=I1.next();

     // Here we will compare if parent window is not equal to child window then we            will close

    // if(parent.equalsIgnoreCase((child_window)))
    // {
     driver.switchTo().window(child_window);

//     System.out.println(driver.switchTo().window(child_window).getTitle());

     driver.close();
     

     }
     // once all pop up closed now switch to parent window
     driver.switchTo().window(parent);

     }
     }
