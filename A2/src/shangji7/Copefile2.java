package shangji7;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copefile2 {
    public static void main(String[] args) {
        //先创建流
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("D:\\javaqhy\\zuoye\\src\\qhy\\Test1.java");
            fileWriter = new FileWriter("D:\\javaqhy\\zuoye\\src\\shangji7\\copefile2.txt");
            //准备char数组
            char[] chars = new char[4];
            int readCount = 0;
            //边读边写
            while((readCount = fileReader.read(chars)) != -1){
                System.out.print(new String(chars,0,readCount));
                fileWriter.write(chars);
            }
            //刷新
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
 }
