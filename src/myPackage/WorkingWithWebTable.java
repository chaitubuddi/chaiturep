package myPackage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.WebAssert;

public class WorkingWithWebTable {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("D:\\Webtablecode\\htmlcode.html");
	driver.manage().window().maximize();
	//to get row count
	int rc= driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr")).size();
	System.out.println("row count: "+rc);
	//to get column count
	int colc=driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr[1]/td")).size();
	System.out.println("column count: "+colc);
	//to get cell count
	int celc=driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr/td")).size();
	System.out.println("cell count: "+celc);
	//to get cell data with for loop 
	for (int i=1;i<=rc;i++)
	{
		for (int j=1;j<=colc;j++)
		{
			String data=driver.findElement(By.xpath("//table[@id='idCourse']/tbody/tr["+i+"]/td["+j+"]")).getText();
			System.out.println("" +data);
		}
		//break;
System.out.println();
	}
	//2nd way to get cell data
	List<WebElement> TDLS=driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr/td"));
	Iterator<WebElement> It=TDLS.iterator();
	while(It.hasNext())
	{
		WebElement TD=It.next();
		System.out.println("" +TD.getText() );
	}
//3rd way to get cell data
	for(WebElement TD: TDLS)
	{
		System.out.format(TD.getText() + "+\t");
		//System.out.println(TD.getText());
	}
	System.out.println();
	//4th way to get cel data
	List<WebElement> rows = driver.findElements(By.tagName("tr"));

    //Print data from each row (Data from each td tag)
    for (WebElement row : rows) {
    List<WebElement> cols = row.findElements(By.tagName("td"));
           for (WebElement col : cols) {
                 System.out.print(col.getText() + "\t");
           }
   System.out.println();
   }
driver.quit();
}
}
