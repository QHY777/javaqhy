package Backtracking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/*
 * 算法实现题5-13 工作分配问题(习题5-22)★问题描述:
设有n件工作分配给n个人。将工作i分配给第j个人所需的费用为c。试设计一个算法，为每一个人都分配1件不同的工作,并使总费用达到最小。
设计一个算法，对于给定的工作费用，计算最佳工作分配方案，使总费用达到最小。★数据输入:
由文件 input. txt 给出输入数据。第1行有1个正整数n (1≤n≤20)。接下来的n行，每行n个数,表示工作费用。
将计算出的最小总费用输出到文件output.txt。
 */
public class WorkAllocation_internet {

	static int n; //工作数
	static int[][] num=new int[n][n]; //费用
	public static int sum = 0;
	public static boolean []  bool= new boolean [n];// 工人工作分配状态
	public static int min = Integer.MAX_VALUE;

	public static void backtrack(int a){
		if(a>n-1){
			if(sum<min){   //当前更佳
				min=sum;
			}
			return;
		}
		for (int i = 0; i <n; i++) {
			if(bool[i]==false){
				sum+=num[a][i];
				bool[i]=true;
				backtrack(a+1);
				sum-=num[a][i];
				bool[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		
		Path path = Paths.get("D:\\javaqhy\\input2.txt");
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
			
			 n=array.get(0);
			 num=new int[n][n];
			 sum = 0;
			 bool= new boolean [n];// 工人工作分配状态
			 min = Integer.MAX_VALUE;
			//将数据存到二维数组里
			 int temp=1;
			 for(int i=0;i<n;i++) {
				 for(int j=0;j<n;j++) {
					 num[i][j]=array.get(temp);
					 temp+=1;
				 }
			 }
			 backtrack(0);
			 System.out.println(min);
			 /*
			 //写入文件
			 File file=new File("D:\\javaqhy\\output2.txt");
			 FileOutputStream out = new FileOutputStream(file);
			 out.write((min + "\r\n").getBytes());
			 System.out.println("找出最优解并写入output2.txt!");
			 out.close();
			 System.out.println("\r" + "写入完成!");
             */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
