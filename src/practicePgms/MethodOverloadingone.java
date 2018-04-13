package practicePgms;

public class MethodOverloadingone {
static int add(int a, int b)
{
	return(a+b);
}
static double add(double a, double b)
{
	return (a+b);
}
public static void main(String[] args) {
	System.out.println(MethodOverloadingone.add(1, 2));
	System.out.println(MethodOverloadingone.add(2.0, 2.0));
}
}
