package CourseGrading;

import java.util.Scanner;

public class Second_Monkey {
	public static double pow2(double y) {
		double result=Math.log(y)/Math.log(2);	
		return result;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		sc.close();
		int x=Integer.parseInt(String.valueOf(input.charAt(0)));
		int y=Integer.parseInt(String.valueOf(input.charAt(1)));
		int z=Integer.parseInt(String.valueOf(input.charAt(3)));
		int n=(int) ((x*10+y)*Math.pow(10, z));
		int k=(int) Math.floor(pow2(n));
		int m=(int) (n-Math.pow(2, k));
		System.out.println(2*m+1);
	}

}
