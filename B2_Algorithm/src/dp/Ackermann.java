package dp;

/*
 * 习题3-6 Ackermann函数
Ackermann函数A(m,n)可递归地定义如下:
A(m,n)=n十1   ,m=0
A(m,n)=A(m-1,1)   ,m> 0，n=0
A(m,n)=A(m—1,A(m,n-1)）    ,m>0,n>0
试设计一个计算A(m,n)的动态规划算法,该算法只占用O(m)空间。
(提示:用两个数组val[0:m]和 ind[O:m],使得对任何i有 val[i]=A(i,ind[i])。)
分析与解答:
按定义容易写出递归算法如下:
public static int ackermann(int m, int n)
{
    if(m==0)return n+1;
	if(n==0)return ackermann(m-1,1);
	else return ackermann(m-1,ackermann(m,n-1));
}
按备忘录方法的思想,可将上述算法修改为如下备忘录算法:public static int ack(int m,int n)

 */
public class Ackermann {
	public static int ack(int m, int n) {
	       int[][] a=new int[m][n];
	       if(a[m][n]>0) {
	    	   return a[m][n];
	       }
	       if(m==0) {          //A(m,n)=n十1   ,m=0
	    	   return a[0][n]=n+1;
	       }
	       if(n==0) {          //A(m,n)=A(m-1,1)   ,m> 0，n=0
	    	   return a[m][0]=ack(m-1,1);
	       }
	       return ack(m-1,ack(m,n-1));    //A(m,n)=A(m—1,A(m,n-1)）    ,m>0,n>0
    }

}
