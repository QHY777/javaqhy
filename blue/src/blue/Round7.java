package blue;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Round7 {
	//四舍五入保留7位小数
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        final double PI=3.14159265358979323;
        DecimalFormat df=new DecimalFormat("0.0000000");	
		double a=PI*n*n;
		System.out.print( df.format(a) );
		sc.close();
    }
	

}
