package sj5_TSP;


public class TSP_greed {
	
	static int n;        //图G的顶点数
	static int[] x;      //当前解ֵ
	static float cc;     //当前费用/路程
	static float[][] a;  //图G邻接矩阵
	static int [] flag;  //0为未访问，1表示访问过
	public static float GTsp(int [] v) {
		//置x为单位排列
		x=new int[n+1];
		flag=new int[n+1];
		flag[1]=1;   //起点已访问
		for(int i=2;i<=n;i++) {
			flag[i]=0;
		}
		for(int i=1;i<=n;i++) {
			x[i]=i;
		}
		cc=0;
        greed();
		return cc;
	}
	private static void greed() {
		int sign=1;
		for(int i=1;i<n;i++) {
			float min=Float.MAX_VALUE;
			for(int j=1;j<=n;j++) {
				if(a[sign][j]<min&&flag[j]==0) {
					min=a[sign][j];
					x[i]=sign;
					cc+=min;
					sign=j;
				}
			}
			flag[sign]=1;   //已访问
		}
		cc+=a[sign][1];
	}
    public static void main(String[] args) {
    	int[] v= {Integer.MAX_VALUE,0,1,2,3};
		a= new float[][]{{Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE},
			              {Float.MAX_VALUE,Float.MAX_VALUE,8,5,36},   //按ppt数据
						  {Float.MAX_VALUE,6,Float.MAX_VALUE,8,5},
						  {Float.MAX_VALUE,8,9,Float.MAX_VALUE,5},
						  {Float.MAX_VALUE,7,7,8,Float.MAX_VALUE}};
		n=4;
		System.out.println("贪心算法距离："+GTsp(v));
    }
}