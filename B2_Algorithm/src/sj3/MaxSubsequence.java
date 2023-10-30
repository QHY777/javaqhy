package sj3;

//最长公共子序列（动态规划）
public class MaxSubsequence {
	
	char[] x;    //存放两个子序列,从下标1开始
	char[] y;
	int[][] c;   //c[i][j]记录Xi和Yj最长公共子序列长度
	int[][] b;   //记录，用于打印
	
	//构造函数
	public MaxSubsequence(char[] x,char[] y) {
		this.x=x;        //初始化各成员变量
		this.y=y;
		this.c=new int[x.length][y.length];
		this.b=new int[x.length][y.length];  
	}
	
	//求最大子序列长度
	public int maxLength() {
		for(int i=1;i<x.length;i++) {
			for(int j=1;j<y.length;j++) {
				if(x[i]==y[j]) {
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;
				}else {
					c[i][j]=Math.max(c[i-1][j], c[i][j-1]);
					b[i][j]=c[i-1][j]>=c[i][j-1]? 2:3;
				}
			}
		}
		return c[x.length-1][y.length-1];
	}
	
	public void print(int i,int j,char[] x) {
		if(i==0||j==0) {
			return;
		}
		if(b[i][j]==1) {
			print(i-1,j-1,x);
			System.out.print(x[i]+" ");  //输出子序列最后一个元素
		}
		else if(b[i][j]==2) {
			print(i-1,j,x);
		}else {
			print(i,j-1,x);
		}
	}
	
	public static void main(String[] args) {
		
		char[] x = {'@','a','b','2','3','a','b'};
		char[] y = {'@','a','2','a','b'};
		MaxSubsequence m=new MaxSubsequence(x,y);
		System.out.println("最大子序列长度"+m.maxLength());
		//输出b
//		for(int i=0;i<x.length;i++) {
//			for(int j=0;j<y.length;j++) {
//				System.out.print(m.b[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.print("最大公共子序列:");
		m.print(x.length-1, y.length-1, x);
	}
	

}
