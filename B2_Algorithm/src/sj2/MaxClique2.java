package sj2;

import java.util.ArrayList;
import java.util.List;

//蛮力法
public class MaxClique2 {

	static int[] x;   //当前解
	static int n; //顶点数
	static int cn ;//当前顶点数
	static int bestn; //当前最大顶点数
	static int[] bestx;    //当前最优方案
	static int[][] a; //邻接矩阵
	
	List<int[]> list = new ArrayList<int[]>();
	
	//暴力法
	public  void maxClique() {
		n = 5;
		x=new int[n];
		cn=0;
		bestn=0;
		bestx= new int [5];
		a = new int[n][n];
		bestx = new int[5];
		a=new int[][]{{0,1,0,1,1},   //邻接矩阵
		    {1,0,1,0,1},
		    {0,1,0,0,1},
		    {1,0,0,0,1},
		    {1,1,1,1,0}};
		//所有可能
		for(int i = 0;i < 2;i++) {
			for(int i2 = 0;i2 < 2;i2++) {
				for(int i3 = 0;i3 < 2;i3++) {
					for(int i4 = 0;i4 < 2;i4 ++) {
						for(int i5 = 0;i5 < 2;i5++) {
							bestx[0] = i;
							bestx[1] = i2;
							bestx[2] = i3;
							bestx[3] = i4;
							bestx[4] = i5;
							int[] g = new int[5];
							for(int k = 0;k < 5;k++) {
								g[k] = bestx[k];
							}
							//所有可能添加到list里
							list.add(g);		
						}
					}
				}
			}
		}		
		//下面对list进行处理,删除其中不能成团的方案
		for(int i = 0;i < list.size();i++) {
			if(!isOK(list.get(i))) {
				list.remove(i);
				i--;
				continue;
			}
		}
		list = findMax(list);
	}
	
	public int findbestn(ArrayList<int[]> list) {
		for(int i = 0;i < list.size();i++) {
			int temp = 0;
			for(int j = 0;j <list.get(i).length;j++) {
				if(list.get(i)[j] != 0) temp += 1;
			}
			if(temp > bestn) bestn = temp;
		}
		return bestn;
	}
	//删除非最大团
	public ArrayList<int[]> findMax(List<int[]> list){
		int temp = findbestn((ArrayList<int[]>)list);
		for(int i = 0;i < list.size();i++) {
			int tempmax = 0;
			for(int j = 0;j < list.get(i).length;j++) {
				if(list.get(i)[j] == 1) tempmax += 1;
			}
			if(tempmax < temp) {
				list.remove(i);
				i--;
			}
		}
		return (ArrayList<int[]>)list;	
	}
	//判断是否成团
	public boolean isOK(int[] list) {
		for(int i = 0;i < x.length;i++) {
			if(list[i] == 1) {
				for(int j = 0;j < i;j++) {
					//不成团
					if(list[j] == 1 && a[i][j] == 0) 
						return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxClique2 maxClique2 = new MaxClique2();
		maxClique2.maxClique();
		System.out.println("最大团顶点数为： " + maxClique2.list.size());
		System.out.println("最大团方案有：");
		for(int i = 0;i < maxClique2.list.size();i++) {
			for(int j = 0;j < maxClique2.list.get(i).length;j++) {
				System.out.print(maxClique2.list.get(i)[j] + " ");
			}
			System.out.println();
		}
	}
}
