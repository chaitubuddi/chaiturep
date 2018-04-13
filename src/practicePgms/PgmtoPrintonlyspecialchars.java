package practicePgms;

public class PgmtoPrintonlyspecialchars {
public static void main(String[] args) {
	String str="abc@$% 098^ A";
	char[] ch = str.toCharArray();
String caps="";
int cap=0;
int sma=0;
int digit=0;
int spa=0;
int spe=0;
String smalls="";
String digits="";
String spec="";
String spaces="";
	for(int i=0;i<ch.length;i++)
	{
		if((!(ch[i]/1>=65 && ch[i]/1<=90) && !(ch[i]/1>=97 && ch[i]/1<=122) && !(ch[i]>=48 && ch[i]<=57) && !(ch[i]/1==32)))
		{
			System.out.println(ch[i]/1);
			spec=spec+ch[i];
		++spe;
		}
		//if(ch[i]/1>=97 && ch[i]/1<=122 && ch[i]/1>=65 && ch[i]/1<=90) 
//		if(ch[i]/1>=65 && ch[i]/1<=90)
//		{
//			caps=caps+ch[i];
//			++cap;
//		}
//		else if(ch[i]/1>=97 && ch[i]/1<=122)
//		{
//			smalls=smalls+ch[i];
//			++sma;
//		}
//		else if(ch[i]/1>=48 && ch[i]/1<=57)
//		{
//			digits=digits+ch[i];
//			++digit;
//		}
//		else if(ch[i]/1==32)
//		{
//			spaces=spaces+ch[i];
//			++spa;
//		}
//		else
//		{
//			spec=spec+ch[i];
//		++spe;
//		}
//		
	}
//System.out.println(caps+">:"+cap);
//System.out.println(smalls+">:"+sma);
//System.out.println(digits+">:"+digit);
//System.out.println(spaces+">:"+spa);
System.out.println(spec+">:"+spe);
}
}
