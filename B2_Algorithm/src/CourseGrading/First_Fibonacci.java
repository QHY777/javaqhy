package CourseGrading;

import java.util.Scanner;

class Matrix{
	long m11;
	long m12;
	long m21;
	long m22;
	Matrix(long a,long b,long c,long d){
		this.m11=a;
		this.m12=b;
		this.m21=c;
		this.m22=d;
	}
}
public class First_Fibonacci {
	public static Matrix cheng(Matrix a,Matrix b) {
		return new Matrix((a.m11*b.m11+a.m12*b.m21)%10000,(a.m11*b.m12+a.m12*b.m22)%10000,(a.m21*b.m11+a.m22*b.m21)%10000,(a.m21*b.m12+a.m22*b.m22)%10000);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		Matrix m =new Matrix(1,0,1,0);
		Matrix m0=new Matrix(1,1,1,0);
		long result;
		if(n==0) {
			result=0;
		}else {
			for(int i=0;i<n;i++) {
				m=cheng(m,m0);
			}
			result=m.m12;
		}
//		result=result%10000;
		System.out.println(result);
	}
}
