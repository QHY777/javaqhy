package shangji7;

import java.io.*;

class MyFileOutput {
	public static void main(String args[]){
		FileInputStream fin;
		FileOutputStream fout;
		int ch;     //声明一个整数变量用来读入用户输入 字符
		try{
     //以标准输入设备为输入文件
	     fin=new FileInputStream(FileDescriptor.in); 
//以D:\javaqhy\zuoye\src\shangji7\copefile.txt为输出文件   		
 fout=new FileOutputStream("D:\\javaqhy\\zuoye\\src\\shangji7\\copefile.txt");		 
 System.out.println("Please input a line of characters:");
	while((ch=fin.read()) !='\r') //反复读输入流，直到输入回车符为止
		 fout.write(ch);
		 fin.close();                       //关闭输入和输出流
		 fout.close();
		 System.out.println("Success!");
			}
		catch(FileNotFoundException e){
			 System.out.println("can not create a file.");
			}
		catch(IOException e){
			System.out.println("error in input stream");
			}
				}
}
