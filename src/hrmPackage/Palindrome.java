package hrmPackage;

public class Palindrome {
public static void main(String[] args) {
	String reverse="";
	String s ="mome test";
	for(int i=s.length()-1;i>=0;i--)
	{
	reverse=reverse+s.charAt(i);
	
	}
	
	System.out.println(reverse);
	/*if(reverse.equals(s))
	{
		System.out.println("it is palindrome");
		
	}
	else
	{
		System.out.println("not palindrome");
	}*/
	}
}
