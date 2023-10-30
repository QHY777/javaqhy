package sj4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
 * 一辆汽车加满油后可行驶n千米。旅途中有若干个加油站。
 * 设计一个有效算法,指出应在哪些加油站停靠加油,使沿途加油次数最少。
 * 并证明算法能产生一个最优解。
对于给定的n和e个加油站位置,计算最少加油次数。
由文件input, txt给出输入数据。第1行有2个正整数n和k,表示汽车加满油后可行驶n公里,且旅途中有k个加油站。
第2行中有k+1个整数,表示第k个加油站与第h一1个加油站之间的距离。第0个加油站表示出发地,汽车已加满油。
第k十+1个加油站表示目的地。
结果输出： 将编程计算出的最少加油次数，以及哪些加油站，输出到文件ouput.txt。
如果无法到达目的地,则输出“NoSolution!”。
 */
public class GasStation {

	public static void main(String[] args) {
		Path path = Paths.get("D:\\javaqhy\\input_GasStation.txt");
	    byte[] data;
		try {
			data = Files.readAllBytes(path);
			String str = new String(data , "utf-8");  //读取字符串
			String[] str1=str.split("[\\t \\r\\n]+");     //按空格、换行拆分
			ArrayList<Integer> array=new ArrayList<Integer>();
			for(int i=0;i<str1.length;i++) {
				array.add(Integer.parseInt(str1[i]));
			}
			int n=array.get(0);
			array.remove(0);
			int k=array.get(0);
			array.remove(0);
			int num=0;  //加油次数
			int gas=n; //当前油量
			String result;  //最后输出
			String scheme="";    //经过的加油站
			for(int i=0;i<array.size()-1;i++) {
				//无法到达目的地
				if(array.get(i)>n) {
					result="No Solution";
					break;
				}
				//无需加油，继续行驶
				if(array.get(i)+array.get(i+1)<gas) {
					gas-=array.get(i);
				}else {  //加油
					gas=n;
					num++;
					scheme=scheme+"\n"+"第"+String.valueOf(i+1)+"个加油站 ";
				}
			}
			result=String.valueOf(num);
			//写入文件
			File file=new File("D:\\javaqhy\\output_GasStation.txt");
			FileOutputStream out = new FileOutputStream(file);
			out.write(("最少加油次数："+result).getBytes());   //最少加油次数
			out.write(("\n"+"最佳方案加油经过的加油站："+scheme).getBytes());   //最佳方案
			out.close();
			System.out.println("写入完成!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
