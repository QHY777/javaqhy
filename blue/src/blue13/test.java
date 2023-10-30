package blue13;
public class test {
	public static double jiecheng(double i) {
		if(i==1)
			return 1;
		else {
			return jiecheng(i-1)*i;
		}
	}
	public static void main(String[] args) {
		/*int i=12345;
		int temp=0;
		int a,b,c,d,e;
		a=i/10000;
		if(a>0) {
			temp=i%10000;
		}
		b=temp/1000;
		if(b>0) {
			temp=temp%1000;
		}
		c=temp/100;
		if(c>0) {
			temp=temp%100;
		}
		d=temp/10;
		if(d>0) {
			temp=temp%10;
		}
		e=temp;
		System.out.println("a"+a);
		System.out.println("b"+b);
		System.out.println("c"+c);
		System.out.println("d"+d);
		System.out.println("e"+e);*/
		char[] zimu=new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
//		System.out.println(jiecheng(10));
		/*
		 * if("a"=="a") System.out.println("true");
		 */
		/*
		 * int[] num= {1,2,3,4}; System.out.println(num[0]>num[1]?num[0]:num[1]);
		 */
		int[][] result=new int[2][2];
		System.out.println(result[1][1]);
	}	
}
