package zuoye;

import java.util.Scanner;

/*习题2-11 O(1)空间子数组换位算法
设a[0:n-1]是一个有n个元素的数组，k(1≤k≤n-1)是一个非负整数。
试设计一个算法将子数组a[0:k-1]与a[k＋1:n一1]换位。
要求算法在最坏情况下耗时O(n)，且只用到O(1)的辅助空间。
*/
public class Converse {

	int n;
	int[] a=new int[n];
	int temp;

	public  Object converse(int k,int left,int right) {
		
		while(left<right) {
			
			if(k-left==right-k) {          //一样长
				for(int i=0;i<right-k;i++) {
					temp=a[left+i];
					a[left+i]=a[k+i+1];
					a[k+i+1]=temp;
				}
          //最后调整k的位置
				if(k<=(n-1)/2) {     //左短右长
					temp=a[k];
					for(int i=k;i<n-1-k;i++) {
						a[i]=a[1+i];     //前移
					}
					a[n-1-k]=temp;       //将k放到正确位置
				}	else {     //左长右短
					temp=a[k];
					for(int i=k;i>n-1-k;i++) {
						a[i]=a[i-1];           //后移
					}
					a[n-1-k]=temp;       //将k放到正确位置
				}
				return "结束";
			}
			
			
			if(k-left>right-k) {          //a[left:k-1]长
				for(int i=0;i<right-k;i++) {
					temp=a[left+i];
					a[i+left]=a[k+i];
					a[k+left+i]=temp;
				}	
				return converse(k,right-k,right);
			}else {      //a[k＋1:right]长
				for(int i=0;i<k-left;i++) {
					temp=a[left+i];
					a[left+i]=a[right-(k-left)+1+i];
					a[right-(k-left)+1+i]=temp;
				}
				return converse(k,left,right-(k-left));
			}
		}
		return "left>right";
		
	}
	//测试
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("输入n:");
		Converse L=new Converse();
		L.n=sc.nextInt();
		L.a=new int[L.n];
		System.out.println("输入"+L.n+"个数据");
		for(int i=0;i<L.n;i++) {
			L.a[i]=sc.nextInt();
		}
		
		System.out.println("输入k:");
		int k=sc.nextInt();
		L.converse(k,0, L.n-1);
		
		System.out.print("展示结果：");
		for(int i=0;i<L.n;i++) {
			System.out.print(L.a[i]+"  ");
		}
		sc.close();
	}
}
