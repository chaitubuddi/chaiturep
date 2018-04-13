package hrmPackage;



public class StringReverse {
	public static void main(String[] args) {
		String a="Hello World";
		System.out.println(a.length());
		System.out.println(a.length()-1);
	//	
		//8for(int i=0;i<=a.length()-1;i++){
	    //System.out.print(a.charAt(i));*/
//	}
System.out.println("");
	for(int i = a.length()-1; i >= 0; --i){
	    System.out.println(a.charAt(i)); 
	}
}
}
