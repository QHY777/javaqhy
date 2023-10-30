package CourseGrading;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] wide=new int[n];
		for(int i=0;i<n;i++) {
			wide[i]=sc.nextInt();
			System.out.println(wide[i]);
		}
		sc.close();
	}

}
