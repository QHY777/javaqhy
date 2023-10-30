package blue13;

import java.util.Scanner;

public class e {

	public static double jiecheng(double i) {
		if(i==1)
			return 1;
		else {
			return jiecheng(i-1)*i;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double k=sc.nextDouble();
		sc.close();
		double bei=(int) Math.pow(10, k);
		for(double i=1;;i++) {
			double number=jiecheng(i);
			if(number%bei==0&&number%(10*bei)!=0) {
				System.out.printf("%.0f",i);
				break;
			}
		}
	}
}
