package zuoye;

public class Bag {

	private int[] weight;
	private int[] values;
	private double[] b;
	private int max;
	private int num;
	private int[] c;
	private int maxvalue;
	
	public boolean takeit(int k) {
		int sum = 0;
		int value = 0;
		for(int i = 0;i <= k;i++) {
			if(c[i] == 1) {
				sum += weight[i];
				value += values[i];
			}
		}
		int last = 0;
		for(int i = k+1; i < weight.length;i++) {
			last += values[i];
		}
		if(sum > max || value+last<maxvalue) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void backtrack(int k) {
		if(k > 6) {
			num++;
			int all = 0;
			int[] g = new int[7];
			for(int i = 0;i < weight.length ;i++) {
				if(c[i] == 1) all += values[i];
			}
			for(int i = 0;i < 7;i++) {
				g[i] = c[i];
			}
			if(all > maxvalue) {
				maxvalue = all;
				for(int i : g)System.out.print(i + " ");
				System.out.println();
			}
			
			return;
		}else {
			for(int i = 1;i >= 0;i--) {
				c[k] = i;
				if(takeit(k)) {
					backtrack(k+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag B = new Bag();
		B.max = 150;
		B.weight = new int[] {35,30,60,50,40,10,25};
		B.values = new int[] {10,40,30,50,35,40,30};
		B.b = new double[B.weight.length];
		B.c = new int[7];
		B.maxvalue = 0;
		B.backtrack(0);
		System.out.println("经历过的方案有：" + B.num + "种");
		System.out.println("背包能装的最大物品价值为：" + B.maxvalue);
	}

}
