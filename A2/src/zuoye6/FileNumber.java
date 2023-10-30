package zuoye6;

import java.io.File;

public class FileNumber {
	public static void getFileAndDirectory(File file){
		int countDirectory = 0;
		int countFile = 0;
		if(file.isDirectory()){
			File []files = file.listFiles();
		    for(File fileIndex:files){
		   if(fileIndex.isDirectory()){
		      countDirectory++;
		     getFileAndDirectory(fileIndex);
		}else {
		countFile++;
		}
		}
		}
		System.out.println("目录文件数目为："+countDirectory);
		System.out.println("普通文件数目为："+countFile);
		}
public static void main(String[] args) {
	File f=new File("D:\\javaqhy\\zuoye\\src\\zuoye6");
	getFileAndDirectory(f);
}
}
