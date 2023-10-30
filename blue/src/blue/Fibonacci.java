package blue;

import java.util.Scanner;
/*Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。

当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。*/
public class Fibonacci {
    public int fibonacci(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
	  public static void main(String[] args) {
		  System.out.println("请输入1~1000000间整数:");
		  Scanner sc=new Scanner(System.in);
		  int n=sc.nextInt();
		  Fibonacci f=new Fibonacci(); 
		  System.out.println(f.fibonacci(n)%10000);
		  sc.close();
	  }
}
