package sj5_TSP;
//Traveling Salesman Problem
public class TSP_Backtrack {

	static int n;        //图G的顶点数
	static int[] x;      //当前解
	static int[] bestx;  //当前最优解
	static float bestc;  //当前最优值ֵ
	static float cc;     //当前费用/路程
	static float[][] a;  //图G邻接矩阵
	
	public static float tsp(int [] v) {
		//置x为单位排列
		x=new int[n+1];
		for(int i=1;i<=n;i++) {
			x[i]=i;
		}
		bestc=Float.MAX_VALUE;
		bestx=v;
		cc=0;
		//搜索x[2:n]的全排列
		backtrack(2);
		return bestc;
	}
	
	private static void backtrack(int i) {
		if(i==n) {
			if(a[x[n-1]][x[n]]<Float.MAX_VALUE&&
					a[x[n]][1]<Float.MAX_VALUE&&
					(bestc==Float.MAX_VALUE||cc+a[x[n-1]][x[n]]+a[x[n]][1]<bestc)) {
				for(int j=1;j<=n;j++) {
					bestx[j]=x[j];
				}
				bestc=cc+a[x[n-1]][x[n]]+a[x[n]][1];
			}
		}else {
			for(int j=i;j<=n;j++) {
				//是否可进入x[j]子树
				if(a[x[i-1]][x[j]]<Float.MAX_VALUE&&
						(bestc==Float.MAX_VALUE||cc+a[x[i-1]][x[j]]<bestc)) {
					//搜索子树
					swap(x,i,j);
					cc+=a[x[i-1]][x[i]];
					backtrack(i+1);
					cc-=a[x[i-1]][x[i]];
					swap(x,i,j);
				}
			}
		}
	}
	private static void swap(int[] a,int b,int c) {
		int temp;
		temp=a[b];
		a[b]=a[c];
		a[c]=temp;
	}
	public static void main(String[] args) {
		int[] v= {Integer.MAX_VALUE,0,1,2,3};
		a= new float[][]{{Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE},
			              {Float.MAX_VALUE,Float.MAX_VALUE,8,5,36},   //按ppt数据
						  {Float.MAX_VALUE,6,Float.MAX_VALUE,8,5},
						  {Float.MAX_VALUE,8,9,Float.MAX_VALUE,5},
						  {Float.MAX_VALUE,7,7,8,Float.MAX_VALUE}};
		n=4;
		System.out.println("回溯法最优方案距离："+tsp(v));
	}
}
