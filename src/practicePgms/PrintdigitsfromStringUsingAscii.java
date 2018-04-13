package practicePgms;

public class PrintdigitsfromStringUsingAscii {


public static void main(String[] args) {

    String s = "adf1hgjyu2frdsff3vgyu4bnjhasd";
    char[] sarr = s.toCharArray();
    int sum=0;
    String ss="";
    for (int i = 0; i < sarr.length; i++)
    {         
    	if(sarr[i]/1>=48 && sarr[i]/1<=57)
    	{
System.out.println("test:"+sarr[i]/1);
    		//      	   System.out.print((int)c+", ");
//    		sum= sum+(int)sarr[i];
    		ss = ss+sarr[i];
         }
    }
    System.out.println(ss);
    
    int i=Integer.parseInt(ss);
System.out.println(i);
while(i>0)
{
int sumcheck=(i%10);
sum=sum+sumcheck;
i=i/10;
}
System.out.println(sum);
}
}

    


