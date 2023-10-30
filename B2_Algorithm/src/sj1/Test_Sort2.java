package sj1;

import java.util.Scanner;

public class Test_Sort2 {

	public static void main(String[] args) {
		
		Sort L=new Sort();

		Scanner sc=new Scanner(System.in);
        for(int i=0;i<10;i++) {
        	
        	System.out.println("输入数据个数：");
    		int num=sc.nextInt();
    		System.out.println("请输入数据：");
    		L.S=new int[num];   //构建存放num个数的数组

    		long startTime = System.nanoTime(); //获取开始时间
    	    L.selectSort();     //选择
    	    long endTime = System.nanoTime(); //获取结束时间
    		System.out.println("程序运行时间：" + (endTime - startTime) + "ns"); //输出程序运行时间

    		long startTime2 = System.nanoTime(); //获取开始时间
    	    L.heapSort();   //堆
    	    long endTime2 = System.nanoTime(); //获取结束时间
    		System.out.println("程序运行时间：" + (endTime2 - startTime2) + "ns"); //输出程序运行时间
        }
		
	    sc.close();
	}		
}
