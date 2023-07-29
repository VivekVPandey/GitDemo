package JavaCodes;

import java.util.ArrayList;

public class Notes {

public static void main(String[] args) {
	
	int num= 123456;
//	System.out.println(num%10); //5 > 50+4> 54321
//	System.out.println(num/10); //1234
	System.out.println(num);
	//Count number of digits in a number
	int temp=num,count=0;
	while(temp>0) {
		
		count++;
		temp=temp/10;
	}
	System.out.println("Count of digits in number: "+count);
	temp=num;
	String rev="";
	//Reverse a number
	
	while(temp>0) {
		rev=rev+(temp%10);
		temp=temp/10;
	}	
	System.out.println(rev);
	int reversed=Integer.parseInt(rev);
	System.out.println(reversed);
	
}
	
}
