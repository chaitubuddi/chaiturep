package hrmPackage;

import java.util.Scanner;

public class CheckPosNeg {
public static void main(String[] args) {
	Scanner S=new Scanner(System.in);
	System.out.println("Enter the Number:");
	int input=S.nextInt();
	if(input>=0)
	{
		System.out.println("Entered numberd is Positive number");
		
	}
	else
	{
		System.out.println("negative number");
	}
}
}
