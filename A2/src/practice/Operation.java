package practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Operation extends Book {

	//查询书籍信息
	public static void find(Book[] books) {
        System.out.println("请输入书名进行查询：");;
        @SuppressWarnings("resource")
		String name = new Scanner(System.in).next();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals(name)) {
                System.out.println("找到了");
                System.out.println("书籍信息为：（书名-作者-分类-状态）");
                System.out.println(books[i].getName() + "   "+books[i].getAuthor() + "   "+books[i].getCategory() + "   "+books[i].getState());
                break;
            }
            while (i== books.length-1) {            
             	 System.out.println("未查询到此书！");
             	 break;
            }
        }
    }

	//根据书的name排序
     public static void sort(Book[] books) {
    	
    	
        Book[] book =books;
     	int k ;
     	for(int i = 0; i < books.length-1; i ++){
     		k=i;
     		for( int j = i+1 ; j <books.length-1; j ++){
     			if( books[j].getName().compareTo(books[i].getName()) < 0){
     			k=j;
     			}
     		if(k!=i) { 
     			 book[1]=books[i];
     		     books[i]=books[k];
     		     books[k]=book[1];
     		     }
     		}	
     	}
     }

     
	  //删除书籍信息
    public static void delete(Book[] books) {
        System.out.println("请输入要删除的书名:");

        @SuppressWarnings("resource")
		String str = new Scanner(System.in).next();
        if(str != null) {
        	//for循环遍历找到所要删除的书籍并将其删除
            for(int i = 0;i<books.length;i++) {
                if(books[i].getName().equals(str)) {
                    books[i] = null;
                    System.out.println("删除成功！");
                  break;
                }
            }
        }
    }

           //添加书籍信息
    @SuppressWarnings("resource")
	public static void add(Book[] books) {
        System.out.println("请输入书名：");
		String name = new Scanner(System.in).next();
        System.out.println("请输入作者：");
        String author = new Scanner(System.in).next();
        System.out.println("请输入分类：");
        String category = new Scanner(System.in).next();
      //for循环找到空处，将书籍信息添加进去
            for (int i = 0; i < books.length; i++) {   
                if (books[i].getName() == null) {
                    books[i].setName(name);
                    books[i].setAuthor(author);
                    books[i].setCategory(category);
                    books[i].setState(true);
                    System.out.println("添加成功");
                    break;
                }
            }
        }
    //展示所有书籍信息
        public static void list (Book[]books){
            System.out.println("图书列表如下：（书名-作者-分类-状态）");  //打印Book数组
            for (int i = 0; i < books.length; i++) {
                if (books[i] != null) {
                    System.out.println(books[i].getName() + "   " + books[i].getAuthor() + "   "  + books[i].getCategory() + "   " + books[i].getState());
                }
            }

        }

        public static void main(String[] args) throws IOException {
        	
        a:    while(true) { 
            System.out.print("请输入确认操作:1 整理排序 2 查询  3添加  4删除 5 全部展示  6操作结束");
           
            @SuppressWarnings("resource")
			int i=new Scanner(System.in).nextInt();
  
        	   switch (i) {
                case 1://排序 
                    sort(books);
                    break;
                   
                case 2://查找
                    find(books);
                    break;
                case 3://添加
                    add(books);
                    break;
                case 4://删除
                    delete(books);
                    break;
                case 5://输出所有书信息
                    list(books);
                    break;
                case 6:// 跳出循环，结束操作
                	break a;
                default:
                    System.out.println("输入有误！");
                    break;
              }
            }
            //将书籍信息输出到D:\a.txt
         FileWriter fw = new FileWriter("D:/a.txt");
            String str = " ";
           for(int i=0;i<books.length-1;i++){ 
        	   str += books[i].getName() + " " + books[i].getAuthor() + " "  + books[i].getCategory() + " " + books[i].getState() + ",  ";}
              fw.write(str);  //写入
              fw.flush();  //刷新缓冲区
              fw.close();
          }
      	}
		


