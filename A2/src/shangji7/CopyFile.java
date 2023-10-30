package shangji7;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        //先创建流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\javaqhy\\zuoye\\src\\qhy\\Test1.java");
            fileOutputStream = new FileOutputStream("D:\\javaqhy\\zuoye\\src\\shangji7\\copefile1.txt");
            //边读边拷贝
            //准备byte数组
            byte[] bytes = new byte[4];
            int readCount = 0;
            while((readCount = fileInputStream.read(bytes)) != -1){
                System.out.print(new String(bytes,0,readCount));
                fileOutputStream.write(bytes);
            }
            //最后要记得刷新输出流
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
