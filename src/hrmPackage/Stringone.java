package hrmPackage;

public class Stringone {
	//String str="Hello World";
	static String  s1="Hello World";
	 
	void printRev(String str) {
		 for(int i=str.length()-1;i>=0;i--)
		  System.out.print(str.charAt(i));
		
		
}
	 
public static void main(String[] args) {
	
	System.out.println(s1.length());
	Stringone ss= new Stringone();
	ss.printRev("Hello World");
	
	
}
}
