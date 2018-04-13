package myPackage;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class AutoItExample {
public static void main(String[] args) {
	System.setProperty(LibraryLoader.JACOB_DLL_PATH,"D:\\SeleniumSoftwraes\\jacob-1.18\\jacob-1.18\\jacob-1.18-x86.dll");
	
	AutoItX x = new AutoItX();
    x.run("notepad.exe");
    x.winWaitActive("Untitled - Notepad");
    //Verify note pad window
    if (x.winExists("Untitled - Notepad"))
    {
    	System.out.println("Note pad displayed");
    }
    //x.winActivate("Untitled - Notepad");
    x.send("Good morning");
    x.winClose("Untitled - Notepad");

}
}
