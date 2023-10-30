package zuoye6;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            FileInputStream fin;
            FileOutputStream fout;
            int ch;//声明一个整数变量读入输入字符
            try {
            	fin=new FileInputStream("D:\\javaqhy\\zuoye\\src\\qhy\\Test1.java");
            	fout =new FileOutputStream("D:\\javaqhy\\zuoye\\src\\zuoye6\\cope2.java");
           
                while((ch=fin.read())!=-1) {
             	   fout.write(ch);
                    } 
                fin.close();
         	   fout.close();
         	   System.out.println("success");
        	   fin=new FileInputStream("D:\\javaqhy\\zuoye\\src\\qhy\\Test1.java");
        	   fout = new FileOutputStream(FileDescriptor.out);
        	   while((ch=fin.read())!=-1) {
            	   fout.write(ch);
                   } 
               fin.close();
        	   fout.close();
            }catch(FileNotFoundException e){
            	System.out.println("can't find file");
            }catch(IOException e){
            	System.out.println("error in input");
            }
          
	}

}
