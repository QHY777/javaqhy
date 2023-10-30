package sj1;

import java.util.Scanner;

public class Test_Sort {
	
	public static void main(String[] args) {
		
		
		Sort L=new Sort();
		System.out.println("1，输入数据");
		System.out.println("2，选择排序并输出");
		System.out.println("3，堆排序并输出");
		System.out.println("4, 退出");
		
	a:	while(true) {
			
			
			System.out.println("请输入指令：");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			
			switch(n) {
			
			case(1):
				System.out.println("输入数据个数：");
				int num=sc.nextInt();
				System.out.println("请输入数据：");
				L.S=new int[num];   //构建存放num个数的数组
				for(int i=0;i<num;i++) {
					L.S[i]=sc.nextInt();
				}
				System.out.println("输入完毕！");
				break;
			
			case(2):
				long startTime = System.nanoTime(); //获取开始时间
			    L.selectSort();     //选择
			    long endTime = System.nanoTime(); //获取结束时间
				System.out.println("程序运行时间：" + (endTime - startTime) + "ns"); //输出程序运行时间
				System.out.print("选择排序结果为：");
			    for(int i=0;i<L.S.length;i++) {
			    	System.out.print(L.S[i]+" ");
			    }
			    System.out.println();
			    break;
			    
			case(3):
				long startTime2 = System.nanoTime(); //获取开始时间
			    L.heapSort();   //堆
			    long endTime2 = System.nanoTime(); //获取结束时间
				System.out.println("程序运行时间：" + (endTime2 - startTime2) + "ns"); //输出程序运行时间
				System.out.print("堆排序结果为：");
			    for(int i=0;i<L.S.length;i++) {
			    	System.out.print(L.S[i]+" ");
			    }
			    System.out.println();
			    break;
			    
			case(4):
				System.out.println("结束");
				sc.close();
				break a;
			}
		}
		
	}

}
