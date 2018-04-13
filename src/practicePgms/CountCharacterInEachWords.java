package practicePgms;


public class CountCharacterInEachWords {
public static void main(String[] args) {
	String str="Geek for geeks";
String	words[]=str.split(" ");
//String s="";
for(int i=0;i<words.length;i++)
{
	String word=words[i];
	String s1="";
//	int find=0;
	for(int j=0;j<word.length();j++)
	{
		s1=s1+word.charAt(j);
		//find++;
	}
	System.out.println(s1+":"+s1.length());
	System.out.println("test");
}
//System.out.println(find);


//	char[] ch = str.toCharArray();
//	for(int i=0;i<ch.length;i++){
//		String s="";
//		while(i<ch.length && ch[i]!=' ')
//		{
//			s=s+ch[i];
//			i++;
//		}
//	if(s.length()>0)
//	{
//		System.out.println(s+"->"+s.length());
//	}
	}


}
