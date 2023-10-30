package zuoye;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PageNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num0 = 0;  //用于统计数目的变量
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        int num7 = 0;
        int num8 = 0;
        int num9 = 0;
        try {
        	Path path = Paths.get("D:\\javaqhy\\input.txt");
            byte [] data = Files.readAllBytes(path);
            String str = new String(data , "utf-8");  //读取字符串
            int max = Integer.parseInt(str);       //字符串转化为数字
           
        	for(int i=1;i<=max;i++) {
        		String s = String.valueOf(i);  //将遍历的每个数转化为字符串
        		for(int p=0;p<s.length();p++) {
        			if(s.charAt(p)==49) {
        				num1+=1;
        			}
        			if(s.charAt(p)==50) {
        				num2+=1;
        			}
        			if(s.charAt(p)==51) {
        				num3+=1;
        			}
        			if(s.charAt(p)==52) {
        				num4+=1;
        			}
        			if(s.charAt(p)==53) {
        				num5+=1;
        			}
        			if(s.charAt(p)==54) {
        				num6+=1;
        			}
        			if(s.charAt(p)==55) {
        				num7+=1;
        			}
        			if(s.charAt(p)==56) {
        				num8+=1;
        			}
        			if(s.charAt(p)==57) {
        				num9+=1;
        			}
        			if(s.charAt(p)==48) {
        				num0+=1;
        			}
        		}
        	}
        	String s1 = String.valueOf(num1);  //将统计个数转化为字符串
        	String s2 = String.valueOf(num2); 
        	String s3 = String.valueOf(num3); 
        	String s4 = String.valueOf(num4); 
        	String s5 = String.valueOf(num5); 
        	String s6 = String.valueOf(num6); 
        	String s7 = String.valueOf(num7); 
        	String s8 = String.valueOf(num8); 
        	String s9 = String.valueOf(num9); 
        	String s0 = String.valueOf(num0); 
        	
        	FileWriter fw = new FileWriter("D:\\javaqhy\\output.txt",false);  
              
            fw.write(s1+"\n");     //写入
            fw.write(s2+"\n");
            fw.write(s3+"\n");
            fw.write(s4+"\n");
            fw.write(s5+"\n");
            fw.write(s6+"\n");
            fw.write(s7+"\n");
            fw.write(s8+"\n"); 
            fw.write(s9+"\n");
            fw.write(s0+"\n");
    
            fw.flush();  
            fw.close();  
                

        	System.out.println("运行结束");
        }catch(FileNotFoundException e){
        	System.out.println("can't find file");
        }catch(IOException e){
        	System.out.println("error in input");
        }
      

	}

}
