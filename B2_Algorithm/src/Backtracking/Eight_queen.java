package Backtracking;

/*
作业4：
1、请分别使用蛮力法和回溯法解决8皇后问题
    在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
    即任意两个皇后都不能处于同一行、同一列或同一斜线上，
    问有多少种摆法。
 */
public class Eight_queen {
	
	static int n=8;   //8皇后
	int[] x=new int[8];   //存放位置数组  x0为第一行,数据为第几列
	int sum;    //可行方案数
	
	//检测每个结点可行性
	private boolean place(int k) {
		for(int j=0;j<k;j++) {
			if((Math.abs(k-j)==Math.abs(x[j]-x[k]))||(x[j]==x[k])){
				return false;
			}
		}
		return true;
	}
	//递归回溯搜索
	private void backtrack(int t) {
		if(t>n-1) {
			sum++;
		}else {
			for(int i=0;i<n;i++) {
				x[t]=i;
				if(place(t)) {
					backtrack(t+1);
				}
			}
		}
	}
	//测试
	public static void main(String[] args) {
		Eight_queen q=new Eight_queen();
		q.backtrack(0);
		System.out.println(q.sum);
	}

}
