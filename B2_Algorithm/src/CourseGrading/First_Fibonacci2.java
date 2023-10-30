package CourseGrading;

import java.util.Scanner;

class Matrix2{
	int m11;
	int m12;
	int m21;
	int m22;
	Matrix2(int a,int b,int c,int d){
		this.m11=a;
		this.m12=b;
		this.m21=c;
		this.m22=d;
	}
}
public class First_Fibonacci2 {
	public static Matrix2 cheng(Matrix2 a,Matrix2 b) {
		return new Matrix2((a.m11*b.m11+a.m12*b.m21)%10000,(a.m11*b.m12+a.m12*b.m22)%10000,(a.m21*b.m11+a.m22*b.m21)%10000,(a.m21*b.m12+a.m22*b.m22)%10000);
	}

	public Matrix2 pow(int n) {
		Matrix2 m0=new Matrix2(1,1,1,0);
		Matrix2 matrix = null; 
		if(n == 1) { 
			matrix = m0; 
		} 
		else if(n % 2 == 0) { 
			matrix = pow(n / 2);
			matrix = cheng(matrix, matrix); 
		} 
		else if(n % 2 == 1) { 
			matrix = pow((n - 1) / 2); 
			matrix = cheng(matrix, matrix); 
			matrix = cheng(matrix, m0);
		} 
		return matrix; 
	} 

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		long result;
		if(n==0) {
			System.out.println(0);
		}else {
			First_Fibonacci2 f=new First_Fibonacci2();
			Matrix2 m=f.pow(n);
			result=m.m12;
			System.out.println(result);
		}
		
	}
}
