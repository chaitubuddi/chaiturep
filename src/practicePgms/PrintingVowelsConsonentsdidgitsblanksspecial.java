package practicePgms;

public class PrintingVowelsConsonentsdidgitsblanksspecial {
public static void main(String[] args) {
	int digits=0,vowels=0,consonents=0,blanks=0;
	String str="This code is aw3s0m3";
	str=str.toLowerCase();
	for(int i=0;i<str.length();i++)
	{
		char ch=str.charAt(i);
		String vowel="";
		String consono="";
		String digit="";
		String blank="";
	//	System.out.println(ch);
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
		{
		 vowel=	vowel+str.charAt(i);
			++vowels;
		//System.out.print(vowel);
		}
		
		else if(ch>='a'&&ch<='z')
		{
			consono=consono+str.charAt(i);
			++consonents;
			//System.out.println(consono);
		}
		else if(ch>='0' && ch<='9')
		{
			digit=digit+str.charAt(i);
			++digits;
			System.out.print(digit);
		}
		else if(ch==' ')
		{
			++blanks;
		}
	}
System.out.println(">"+digits);
//System.out.println(">"+vowels);
//System.out.println(">"+consonents);
}
}
