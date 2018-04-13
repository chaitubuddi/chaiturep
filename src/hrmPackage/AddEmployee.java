package hrmPackage;

 

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

//import AWTPackage.AbstractWTKProgram;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee {
public static void main(String[] args)throws AWTException, IOException, InterruptedException {
	//System.setProperty("webdriver.gecko.driver", "D:\\Selenium QAPlanet\\Drivers\\geckodriver-v0.15.0-win64\\geckodriver.exe");
	//System.setProperty("webdriver.chrome.driver", "D:\\Selenium QAPlanet\\Drivers\\chromedriver_win32\\chromedriver.exe");
	//FirefoxDriver driver=new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwraes\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(driver, 60);
	Actions Act=new Actions(driver);
	driver.get("http://apps.qaplanet.in/qahrm/login.php");
	//vrifying the home page title
	wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	{
		System.out.println("Home Page is displayed");
	}
	//creating webelements for username,password,login and clear
	WebElement ObjUn=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
	WebElement ObjPwd=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
	WebElement ObjLogin=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
	WebElement ObjClear=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
//verifying the username
	if(ObjUn.isDisplayed())
{
	System.out.println("username field is displayed");
}
else
{
	System.out.println("username field is not displayed");
}
	//verifying the password field
if(ObjPwd.isDisplayed())
{
	System.out.println("Password field is displayed");
}
else
{
	System.out.println("Password field is not displayed");
}
//verifying the both login and clear fields
if(ObjLogin.isDisplayed() && ObjClear.isDisplayed())
{
	System.out.println("Login button and clear buttons are displayed properly");
}
else
{
	System.out.println("Login button and clear buttons are not displayed properly");
}

//storing the username and password in objects
String StrUname="qaplanet1";
String StrPwd="user1";
//entering username 
ObjUn.sendKeys(StrUname);
//entering password
ObjPwd.sendKeys(StrPwd);
//click on login
ObjLogin.click();
//After logged into HRM, verifying the Home page
Boolean res=wait.until(ExpectedConditions.titleIs("OrangeHRM"));
//verifying home page
if(res)
{
	System.out.println("home page is displayed properly");
}
else
{
	System.out.println("home page is not displayed");
}
//verifying welcome message
String welcometext=driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
if(welcometext.equals("Welcome "+StrUname))
{
	System.out.println("welcome "+StrUname+" is displayed and verified");
}
else
{
	System.out.println("welcome text is not displayed and verified");
}
//verifying the change password link and Logout link
WebElement ObjChangePwd=driver.findElement(By.xpath("//ul[@id='option-menu']/li[2]"));
WebElement ObjLogout=driver.findElement(By.xpath("//ul[@id='option-menu']/li[3]"));
if(ObjChangePwd.isDisplayed() && ObjLogout.isDisplayed())
{
	System.out.println("change password and logout is displayed");
}
else
{
	System.out.println("change password and logout is not displayed");
}
//to click on on add employee need to mouse over on PIM
WebElement ObjPIM=driver.findElement(By.xpath("//li[@id='pim']/a"));
//mouse hover on PIM link
Act.moveToElement(ObjPIM).pause(2000).perform();
//clicking on add employee
WebElement ObjAddEmp=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add Employee")));
ObjAddEmp.click();
//switch to frame
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
String ObjAddEmpText=driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText();
if(ObjAddEmpText.equals("PIM : Add Employee"))
{
	System.out.println("Add employee page is displayed");
}
else
{
	System.out.println("Add employee page is not displayed");
}
//get employee code
String ObjEmpCode=driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
System.out.println(ObjEmpCode);
String Fname="latest";
String Lname="user";
//click on save without entering the all fields 
WebElement ObjSave=driver.findElement(By.id("btnEdit"));
ObjSave.click();
Alert A=wait.until(ExpectedConditions.alertIsPresent());
if(A.getText().equals("Last Name Empty!"))
{
	System.out.println("Last Name Empty! alert displayed");

	A.accept();
}
else
{
	System.out.println("alert text is not there");
}
//webelemnts for first and last names

WebElement LastName=driver.findElement(By.id("txtEmpLastName"));
LastName.sendKeys(Lname);
ObjSave.click();
//click on save again and handle alert

//handling alert
Alert al=wait.until(ExpectedConditions.alertIsPresent());
if(al.getText().equals("First Name Empty!"))
{
	System.out.println("First Name Empty! alert displayed");
	al.accept();
}
else
{
	System.out.println("alert text is not there to click on ok");
}
//entering first name
WebElement FirstName=driver.findElement(By.name("txtEmpFirstName"));
FirstName.sendKeys(Fname);
//uploading photo of employee
//Robot rt=new Robot();
//StringSelection ss=new StringSelection("")
driver.findElement(By.id("photofile")).click();
//AbstractWTKProgram.robot();
Thread.sleep(2000);
Runtime.getRuntime().exec("D:\\LatestSeleniumScripts\\AutoITPrograms\\imageupload.exe");
Thread.sleep(2000);
System.out.println("image uploaded");
Thread.sleep(5000);
ObjSave.click();


//wait for personal details text
if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
{
	System.out.println("Personl details is displayed");
}
else
{
	System.out.println("Personal details page is not displayed");
}
//verifying the first name and last name in personal details page
WebElement ObjVerLastName=driver.findElement(By.id("txtEmpLastName"));
if(ObjVerLastName.getAttribute("value").equals(Lname))
		{
	System.out.println("Last Name is Properly displayed as "+Lname);
		}
else
{
	System.out.println("Last Name is not Properly displayed as");
}
WebElement ObjVerFirstName=driver.findElement(By.id("txtEmpFirstName"));
if(ObjVerFirstName.getAttribute("value").equals(Fname))
{
System.out.println("First Name is Properly displayed as "+Fname);
}
else
{
System.out.println("First Name is not Properly displayed as");
}

//to click on emp list
//moving to pim list
driver.switchTo().parentFrame();
Act.moveToElement(ObjPIM).pause(2000).perform();
//clicking on add employee
WebElement ObjEmpList=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Employee List")));
ObjEmpList.click();
//switch to frame
wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));

//verify the employee list page
if(driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
{
	System.out.println("employee information page is displayed");
}
//to get row count in order to verify emp code and emp name
//int rc=driver.findElements(By.xpath("//table[@class='data-table']/tbody/thead/tr")).size();
int rc=driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
int i;
for(i=1;i<=rc;i++)
{
	//get emp code from column
String StrEmpcode=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
//String sEmpID=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
//get emp name from third column
String StrEmpName=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
if(StrEmpcode.equals(ObjEmpCode) && StrEmpName.equals(Fname+" "+Lname))
{
	System.out.println("Empcode is "+StrEmpcode+" ,"+StrEmpName+" displayed at :"+i);
break;
}
}
//switch to default page
driver.switchTo().defaultContent();
ObjLogout.click();
//wait for home page
wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
//Verify OrangeHRM - New Level of HR Management
		if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Signoff Sucessfull & Home Page displayed");
		}
		else
		{
			System.out.println("Failed to Signoff");
			return;
		}	


driver.quit();

}

}