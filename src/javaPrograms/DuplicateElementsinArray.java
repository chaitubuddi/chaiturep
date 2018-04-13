package javaPrograms;

public class DuplicateElementsinArray {
	public static void main(String[] args) {
		Integer[] array={1,2,3,4,1,2};
		
for(int i=0;i<array.length-1;i++)
{
	int count=0;
for(int j=i+1;j<array.length;j++)
{
	
	if((array[i]==array[j]) && (i!=j))
		{
		count++;
		System.out.println(array[i]);
		System.out.println("duplicate count is "+count);
			}
}
}
}
}