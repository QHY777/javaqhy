package CourseGrading;

import java.util.Scanner;

public class First_Fibonacci3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		long num;
		int[] result={0,1}; 
		if(n < 2) 
			num=result[n]; 
	    long a = 0; 
	    long b = 1; 
		long c = 0;
		for(int i = 2;i<= n;i++){ 
			c = (a+b)%10000; 
			a=b;
			b=c;
		} 
		num=c;
		System.out.println(num);
	}
	
}
