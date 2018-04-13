package practicePgms;

public class Pattern6 {
	/*
1 1 1 1 1 1 1 
2 2 2 2 2 2 
3 3 3 3 3 
4 4 4 4 
5 5 5 
6 6 
7 
	 */
public static void main(String[] args) {
	for(int i=1;i<=7;i++)
	{
		for(int j=7;j>=i;j--)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
}
