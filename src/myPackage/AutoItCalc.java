package myPackage;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class AutoItCalc {
	public static void main(String[] args) {
		System.setProperty(LibraryLoader.JACOB_DLL_PATH,"D:\\SeleniumSoftwraes\\jacob-1.18\\jacob-1.18\\jacob-1.18-x86.dll");
		
		AutoItX x = new AutoItX();
		x.run("calc.exe");
		x.winWaitActive("Calculator");
		  if (x.winExists("Calculator"))
	        {
	        	System.out.println("Calculator displayed");
	        }
		  else{
			  System.out.println("calc not displayed");
		  }
//to click on 8
		  x.controlClick("Calculator", "", "Button9");
		  //to click on *
		  x.controlClick("Calculator", "", "Button21");
	//to click on 9
		  x.controlClick("Calculator", "", "Button14");
		  //to click on =
		  x.controlClick("Calculator", "", "Button28");
		  x.sleep(1000);
		  x.winClose("Calculator");
		  System.out.println("propelry closed");
	}
}
