package Backtracking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/*
 * 算法实现题5-3最小重量机器设计问题★问题描述
设某一机器由n个部件组成,每一种部件都可以从m个不同的供应尚处购得。设u,是从供应商j处购得的部件i的重量，c,是相应的价格。
T。..naLysa r
试设计一个算法,给出总价格不超过c的最小重量机器设计。
★算法设计
对于给定的机器部件重量和机器部件价格,计算总价格不超过d的最小重量机器设计。
★数据输入
由文件 input. txt给出输入数据。第1行有3个正整数n,m和d。接下来的2n行,每行n个数。前n行是c,后n行是w。
★结果输出
将计算出的最小重量,以及每个部件的供应商输出到文件 output. txt。
 */
public class MinWeight {
	 static int n; //部件数
	 static int m; //供应商数
	 static int d;  //总价格不超过d
	 static int[] x=new int[n];   //存放当前方案数组
	 static int[] best=new int[n];   //存放最佳方案数组
	 static int[][] c=new int[n][m]; //价格
	 static int[][] w=new int[n][m]; //重量
	 static int min;      //最小重量
	 

	 //检测每个结点可行性
	 private boolean place(int k) {
		 int cost=0;
		 for(int j=0;j<k;j++) {
		 	cost+=c[j][x[j]];
			
		 }
		 if(cost>d){
		 	return false;
		 }
	 	 return true;
	 }
	 //递归回溯搜索
	 private void backtrack(int t) {
	 	 if(t>n-1) {
	 		 int weight=0;         //当前方案总重量
			 for(int j=0;j<n;j++) {
			 	weight+=c[j][x[j]];	
			 }
			 if(weight<min) { //当前方案更佳
				 min=weight;
				 for(int i=0;i<x.length;i++) {
					 best[i]=x[i];
				 }
			 }
		 }else {
			 for(int i=0;i<m;i++) {
				 x[t]=i;
				 if(place(t)) {
					 backtrack(t+1);
				 }
			 }
		 }
	 }

	public static void main(String[] args) {
		
		Path path = Paths.get("D:\\javaqhy\\input.txt");
	    byte[] data;
		try {
			 data = Files.readAllBytes(path);
			 String str = new String(data , "utf-8");  //读取字符串
			 String[] str1=str.split("[\\t \\r\\n]+");     //按空格、换行拆分
			 ArrayList<Integer> array=new ArrayList<Integer>(); //将读取的所有数添加到array里
			 for(int i=0;i<str1.length;i++) {
				 int str_int=Integer.parseInt(str1[i]);
				 array.add(str_int);
			 }
			 //输出array数据
	//			 System.out.println("array:");
	//			 for(int i=0;i<array.size();i++) {
	//				 System.out.println(array.get(i));
	//			 }
			 MinWeight mw=new MinWeight();
			 n=array.get(0);  //部件数
			 m=array.get(1);   //供应商数
			 d=array.get(2);   //总价格不超过d
			 x=new int[n];   //存放当前方案数组
			 best=new int[n];   //存放最佳方案数组
			 c=new int[n][m]; //价格
			 w=new int[n][m]; //重量
			 //将数据存到二维数组里
			 int temp=3;
			 for(int i=0;i<n;i++) {
				 for(int j=0;j<m;j++) {
					 c[i][j]=array.get(temp);
					 temp+=1;
				 }
			 }
			 for(int i=0;i<n;i++) {
				 for(int j=0;j<m;j++) {
					 w[i][j]=array.get(temp);
					 temp+=1;
				 }
			 }
			 //初始化min,全部用第一家的
			 for(int j=0;j<n;j++) {
				 min+=c[j][x[j]];	
			 }
			 mw.backtrack(0);
			 
//			 for(int i=0;i<best.length;i++) {
//				 System.out.print(best[i]+" ");
//			 }
			 //写入文件
			 File file=new File("D:\\javaqhy\\output.txt");
			 FileOutputStream out = new FileOutputStream(file);
			 out.write((min + "\r\n").getBytes());
			 System.out.println("找出最优解并写入output.txt!");
			 System.out.println(min);
			 for(int i:best) {
			 	 System.out.print((i+1) + " ");
				 out.write(((i+1) + " ").getBytes());
			 }
			 out.close();
			 System.out.println("\r" + "写入完成!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
