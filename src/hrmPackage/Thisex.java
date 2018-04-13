package hrmPackage;

public class Thisex {
	int rollno;
	String name;
	float salary;
	Thisex(int rollno,String name,float salary)
	{
		this.rollno=rollno;
		this.name=name;
		this.salary=salary;
		
		
		//this.rollno=rollno;
		//this.name=name;
		//this.salary=salary;
		//System.out.println(rollno + ":" +name + ":" + salary);
	}
	void display()
	{
		System.out.println(rollno + ":" +name + ":" + salary);
	}
public static void main(String[] args) {
	Thisex ex=new Thisex(10, "chaitu", 60000f);
	ex.display();
}
}
