package zuoye6;

import java.io.File;

public class cope2 {
	public static void main(String[] args) {
        File file =new File("Test1.java");
        System.out.println("当前工作目录是 " + file.getAbsolutePath());
    }

}
