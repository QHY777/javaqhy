package sj2;
/*
 * 题目要求：
 * 给定一个无向图G=(V,E)，若U为V子集，请对任意的顶点u, v为U的元素，
 * 有边(u,v)为E元素，则称U为G的一个完全子图。G的完全子图U是一个团，
 * 当且仅当U不包含在G的更大的完全子图中。G的最大团则指包含定点数最多的团。
 * 对给定的无向图，找出最大团中顶点的个数。
 * 基于课程说明的蛮力和回溯算法思路，设计实现基于蛮力法和回溯算法相关的数据结构和算法
 * 
 * 原理可以参考 https://wenku.baidu.com/view/1bd93526a5e9856a561260e2.html
 */
public class MaxClique {

	/*进入左子树采用，不然进入右子树
	 * 扩展结点在第i层，进入左子树前必须确认从顶点i到已选入的顶点集的每个顶点都有边相连
	 * 进入右子树前，必须确认还有足够多的可选择顶点使得算法有可能在右子树中找到更大图团
	 */
	static int[] x;   //当前解
	static int n; //顶点数
	static int cn ;//当前顶点数
	static int bestn; //当前最大顶点数
	static int[] bestx;    //当前最优方案
	static int[][] a; //邻接矩阵
	
	public static int maxClique(int[] v) {
		n=v.length;
		x=new int[n];
		cn=0;
		bestn=0;
		bestx=v;
		//回溯搜索
		backtrack(0);
		return bestn;
	}
	private static void backtrack(int i) {
		if(i>n-1) {      //到叶结点
			for(int j=0;j<n;j++) {
				bestx[j]=x[j];
				System.out.print(bestx[j]+" ");
			}
			bestn=cn;
			System.out.println();
			return;
		}
		//检查顶点i与当前团的连接
		else {
			boolean flag=true;
			for(int j=0;j<i;j++) {
				if(x[j]==1&&a[i][j]==0) {  //与之前选入的点不相连
					flag=false;
					break;
				}
			}
			if(flag) { //true，进入左子树
				x[i]=1;
				cn++;
				backtrack(i+1);
				cn--;
			}
			if(cn+n-i>bestn) { //进入右子树
				x[i]=0;
				backtrack(i+1);
			}
		}
	}
	public static void main(String[] args) {
		int[] v= {1,2,3,4,5};  //顶点
		a=new int[][]{{0,1,0,1,1},   //邻接矩阵
		    {1,0,1,0,1},
		    {0,1,0,0,1},
		    {1,0,0,0,1},
		    {1,1,1,1,0}};
        System.out.println("最大团结果为：");
		System.out.println("最大顶点数："+maxClique(v));
	}
}
