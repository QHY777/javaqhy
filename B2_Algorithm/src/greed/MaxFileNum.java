package greed;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
/*
 * 算法实现题4-5 程序存储问题★问题描述
设有n个程序1,2,…,n}要存放在长度为L的磁带上。程序i存放在磁带上的长度是L,1in。
程序存储问题要求确定这n个程序在磁带上的一个存储方案,使得能够在磁带上存储尽可能多的程序。
★算法设计
对于给定的n个程序存放在磁带上的长度,计算磁带上最多可以存储的程序数。
由文件input. txt给出输入数据。第1行是2个正整数,分别表示文件个数n和磁带的长度L。第2行中有n个正整数,表示程序存放在磁带上的长度。
将计算出的最多可以存储的程序数输出到文件output. txt。
 */
public class MaxFileNum {
	
	public static void main(String[] args) {
		Path path = Paths.get("D:\\javaqhy\\input_MaxFileNum.txt");
	    byte[] data;
		try {
			data = Files.readAllBytes(path);
			String str = new String(data , "utf-8");  //读取字符串
			String[] str1=str.split("[\\t \\r\\n]+");     //按空格、换行拆分
			ArrayList<Integer> array=new ArrayList<Integer>();
			for(int i=0;i<str1.length;i++) {
				array.add(Integer.parseInt(str1[i]));
			}
			int n=array.get(0);   //文件数
			int L=array.get(1);   //最大长度
			array.remove(0);  //删除n
			array.remove(0);   //删除L
			Collections.sort(array);    //排序
//			for(int i=0;i<array.size();i++) {
//				System.out.println(array.get(i));
//			}
			int sum=0;   //当前长度
			int maxfile=0;   //最大文件数
			for(int i=0;i<array.size();i++) {
				if(sum+array.get(i)<=L) {
					sum+=array.get(i);
					maxfile++;
				}else
					break;
			}
			//写入文件
			 File file=new File("D:\\javaqhy\\output_MaxFileNum.txt");
			 FileOutputStream out = new FileOutputStream(file);
			 out.write((maxfile + "\r\n").getBytes());
			 out.close();
			 System.out.println("写入完成!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
