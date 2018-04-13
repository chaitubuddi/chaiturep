package myPackage;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

    public class Partner_Login 
    {
        public WebDriver driver;
        public static WebDriver driver1;
        public String code;
        @Test
        public void Login() throws InterruptedException,Exception 
        {
          ProfilesIni profile = new ProfilesIni();
	      FirefoxProfile myprofile = profile.getProfile("PPBrowser");
	      System.setProperty("webdriver.gecko.driver", "D:\\SeleniumSoftwraes\\geckodriver-v0.18.0-win32\\geckodriver.exe");
	      @SuppressWarnings("deprecation")
		WebDriver driver = new FirefoxDriver(myprofile);
	      driver.manage().window().maximize();
	 	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 	 WebDriverWait wait=new WebDriverWait(driver, 60);
	 		Actions Act=new Actions(driver); 
              
	      //driver.manage().window().maximize();
              driver.get("https://partners.beta-wspbx.com/");
            //  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
              driver.findElement(By.id("xusername")).sendKeys("panterraadmin");
          	driver.findElement(By.id("password")).sendKeys("thr3@d3nc0d3");
          	driver.findElement(By.className("normalButton")).click();
              System.out.println("Welcome :::");
             //Thread.sleep(2000);
             driver.get("https://partners.beta-wspbx.com/servicemanager/get_query_result");
       System.out.println("in query results page");
             // if(driver.findElement(By.xpath(".//*[@id='mainbody']/form/table[1]/tbody/tr/td[2]")).getText().equals("Compare Query Results"));
          //	System.out.println("We are in Compare Query Results Page");
              //driver.quit();
        }


}