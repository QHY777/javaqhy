package dp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
 * 给定一个由n行数字组成的数字三角形如图3-2所示。试设计一个算法,计算出从三角形的顶至底的一条路径,
 * 使该路径经过的数字总和最大。
对于给定的由n行数字组成的数字三角形,计算从三角形的顶至底的路径经过的数字和的最大值。
由文件input.txt提供输入数据。文件的第1行是数字三角形
的行数n,l<n≤100,接下来n行是数字三角形各行中的数字,所有图3-2 数字三角形数字为0～99。
 */
public class MaxPath {

	int[][] a;
	int n;      //数据行数
	public int MaxSum(int i, int j){
		if(i==n) {
			return a[i][j];
		}
		int x = MaxSum(i+1,j);    //下左
		int y = MaxSum(i+1,j+1);    //下右
		return Math.max(x,y)+a[i][j];
	}
	
	//构造函数
	public MaxPath(int n) {
		this.n=n;
	}
	public static void main(String[] args) {
		
		Path path = Paths.get("D:\\javaqhy\\input3.txt");
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
			 MaxPath p=new MaxPath(array.get(0));
			 
			//将数据存到二维数组里
			 int temp=1;
			 int m=0;
			 p.a=new int[p.n+1][p.n+1];
			 for(int i=1;i<=p.n;i++) {
				 m++;
				 for(int j=1;j<=m;j++) {
					 p.a[i][j]=array.get(temp);
					 //System.out.println(array.get(temp));
					 temp+=1;
				 }
			 }
			 System.out.println("最大路径"+p.MaxSum(1, 1));
			 //写入文件
			 File file=new File("D:\\javaqhy\\output3.txt");
			 FileOutputStream out = new FileOutputStream(file);
			 out.write((String.valueOf(p.MaxSum(1, 1))).getBytes());
			 out.close();
			 System.out.println("写入完成!");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
