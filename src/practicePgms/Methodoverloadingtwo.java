package practicePgms;

public class Methodoverloadingtwo {
void add(int a, int b)
{
	System.out.println(a+b);
}
void add(int a, int b, int c)
{
	System.out.println(a+b+c);
}
public static void main(String[] args) {
	Methodoverloadingtwo obj=new Methodoverloadingtwo();
	obj.add(1, 2);
	obj.add(1,2,3);
	
}
{
	
}
}
