package hrmPackage;

import java.util.Scanner;

public class StringCountNoOfWords {
	public static void main(String[] args)
    {
        System.out.println("Enter the string");
 
        Scanner sc = new Scanner(System.in);
 //System.out.println(sc);
        String s=sc.nextLine();
        System.out.println(s.length());
 
        int count = 1;
 
        for (int i = 0; i < s.length(); i++)
        {
            if((s.charAt(i) == ' ') && (s.charAt(i+1) != ' '))
            {
                count++;
            }
        }
 
        System.out.println("Number of words in a string = "+count);
    }
}
