package practicePgms;

public class NoOfOccurene {
public static void main(String[] args) {
	String s="testingg";
	char[] ca =s.toCharArray();
	 
	char[] cb = new char[s.length()];
	for(int i=0;i<s.length();i++)
	{
		int count =0;
		
		cb[i] = ca[i];
		for(int j = 0;j<s.length();j++){
			if(s.charAt(i)==s.charAt(j))
			{
				count++;
			
			}
		}
	
		
		System.out.println(ca[i]+"---->"+count);
	}
}
}
