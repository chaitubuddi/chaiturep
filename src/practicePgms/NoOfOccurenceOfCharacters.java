package practicePgms;

public class NoOfOccurenceOfCharacters {
	static final int MAX_CHAR = 256;
public static void main(String[] args) {
	
	String str="abcbdaaa";
	int count[] = new int[MAX_CHAR];
	for(int i=0;i<str.length();i++)
		count[str.charAt(i)]++;
	char ch[]=new char[str.length()];
	//char ch[]=str.toCharArray();
	for(int i=0;i<str.length();i++)
	{
		ch[i]=str.charAt(i);
		int find=0;
		for(int j=0;j<str.length();j++)
		{
			if(str.charAt(i)==ch[j])				
			find++;
		}	
		if(find==1)
		
			System.out.println("No.of occurenews:"+str.charAt(i)+" is :"+count[str.charAt(i)]);
		
		}
	}
	
}

