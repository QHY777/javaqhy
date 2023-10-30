package sj2;

import java.util.ArrayList;
import java.util.List;

public class MaxCliqueStrength {

	int n;
	int[][] x;
	int[] y;
	int[] yTemp;
	List<int[]> all = new ArrayList<int[]>();
	int best;
	int num = 0;
	int number = 0;
	
	//暴力法
	public void maxClique() {
		n = 5;
		x = new int[5][5];
		y = new int[5];
		x[0][0] = 0;
		x[0][1] = 1;
		x[0][2] = 0;
		x[0][3] = 1;
		x[0][4] = 1;
		x[1][0] = 1;
		x[1][1] = 0;
		x[1][2] = 1;
		x[1][3] = 0;
		x[1][4] = 1;
		x[2][0] = 0;
		x[2][1] = 1;
		x[2][2] = 0;
		x[2][3] = 0;
		x[2][4] = 1;
		x[3][0] = 1;
		x[3][1] = 0;
		x[3][2] = 0;
		x[3][3] = 0;
		x[3][4] = 1;
		x[4][0] = 1;
		x[4][1] = 1;
		x[4][2] = 1;
		x[4][3] = 1;
		x[4][4] = 0;
		for(int i = 0;i < 2;i++) {
			for(int i2 = 0;i2 < 2;i2++) {
				for(int i3 = 0;i3 < 2;i3++) {
					for(int i4 = 0;i4 < 2;i4 ++) {
						for(int i5 = 0;i5 < 2;i5++) {
							y[0] = i;
							y[1] = i2;
							y[2] = i3;
							y[3] = i4;
							y[4] = i5;
//							//打印所有可能的方案
//							for(int j = 0;j < 5;j++) {
//								System.out.print(y[j] + " ");
//							}
//							System.out.println("");
							int[] g = new int[5];
							for(int k = 0;k < 5;k++) {
								g[k] = y[k];
							}
							all.add(g);
							
						}
					}
				}
			}
		}
//		//打印所有的组合个数
//		System.out.println(all.size());
//		
		//下面对all进行处理,删除其中不能成团的方案
		for(int i = 0;i < all.size();i++) {
			if(isOK(all.get(i))) {
//				//如果组合可以构成团，则打印
//				for(int j = 0;j < all.get(i).length;j++) {
//					System.out.print(all.get(i)[j] + " ");
//				}
//				System.out.println();
			}
			else{
				all.remove(i);
				i--;
				continue;
			}
		}
		
		all = findMax(all);
		System.out.println("最大团顶点数为： " + all.size());
	}
	
	public int findbest(ArrayList<int[]> list) {
		for(int i = 0;i < list.size();i++) {
			int temp = 0;
			for(int j = 0;j <list.get(i).length;j++) {
				if(list.get(i)[j] != 0) temp += 1;
			}
			if(temp > best) best = temp;
		}
		return best;
	}
	
	public ArrayList<int[]> findMax(List<int[]> list){
		int temp = findbest((ArrayList<int[]>)list);
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
	
	public boolean isOK(int[] list) {
		for(int i = 0;i < x.length;i++) {
			if(list[i] != 0) {
				for(int j = 0;j < i;j++) {
					if(list[j] != 0 && x[i][j] != 1) return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxCliqueStrength maxCliqueStrength = new MaxCliqueStrength();
		maxCliqueStrength.maxClique();
		System.out.println("最大团方案有：");
		for(int i = 0;i < maxCliqueStrength.all.size();i++) {
			for(int j = 0;j < maxCliqueStrength.all.get(i).length;j++) {
				System.out.print(maxCliqueStrength.all.get(i)[j] + " ");
			}
			System.out.println();
		}
	}

}
