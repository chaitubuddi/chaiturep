package myPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Workbook;
import jxl.read.biff.BiffException;
//static Webdriver driver;
public class WorkingwithDB {
	public static void main(String[] args) throws BiffException, IOException {
		
		WebDriver driver;
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 WebDriverWait wait=new WebDriverWait(driver, 60);
		Actions Act=new Actions(driver); 
	
	driver.get("https://partners.beta-wspbx.com");
	driver.findElement(By.id("xusername")).sendKeys("panterraadmin");
	driver.findElement(By.id("password")).sendKeys("thr3@d3nc0d3");
	driver.findElement(By.className("normalButton")).click();
	/*String url = driver.getCurrentUrl();
	String newurl = url+"/#q=ask+questions";
	driver.get(newurl);*/
	driver.navigate().to("https://partners.beta-wspbx.com/servicemanager/get_query_result");
	if(driver.findElement(By.xpath(".//*[@id='mainbody']/form/table[1]/tbody/tr/td[2]")).getText().equals("Compare Query Results"));
	System.out.println("We are in Compare Query Results Page");
	//selecting the db in dropdown
	Select s = new Select(driver.findElement(By.name("seleteddbid")));
	s.selectByValue("1");
	System.out.println(s.getFirstSelectedOption());
	//code for reading the queries fromexcel
	String FilePath = "D:\\SeleniumSoftwraes\\Testdata.xls";
	FileInputStream fs = new FileInputStream(FilePath);
	Workbook wb = Workbook.getWorkbook(fs);
	
//	System.out.println("warehouse db is selected");
	//need to fetch the data the
}
}
