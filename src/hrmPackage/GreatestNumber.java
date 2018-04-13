package hrmPackage;

import java.util.Scanner;

public class GreatestNumber {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the First Number");
	int num1=s.nextInt();
	System.out.println("enter the second number");
	int num2=s.nextInt();
	System.out.println("enter the third number");
	int num3=s.nextInt();
	if(num1>num2)
		if(num1>num3)
			System.out.println("The greatest num is:"+ num1);
	if(num2>num1)
		if(num2>num3)
			System.out.println("The greatest num is:"+ num2);
	if(num3>num1)
		if(num3>num2)
			System.out.println("The greatest num is:"+ num3);
				
}
}
