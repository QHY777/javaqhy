package first_Sq_LinkList;

import java.util.Scanner;

public class Test2 {
	       public static void main(String[] args) throws Exception {
			
		
	LinkList L=new LinkList();

 a:    while(true) { 
        System.out.print("请输入确认操作: 1 查询内容   2 查询位置  3插入  4删除 5 全部展示  6操作结束");
       
        @SuppressWarnings("resource")
			int i=new Scanner(System.in).nextInt();

    	   switch (i) {
            case 1:     //查询内容
           	 System.out.println("输入下标");
           	 int n=new Scanner(System.in).nextInt();
			try {
				System.out.println(L.get(n));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                break;
                
                
            case 2:  //查询位置
           	 System.out.println("输入查找的元素");
           	 Object p=new Scanner(System.in).next();
           	System.out.println("结果为"+L.getIndex(p)); 
           	    break;
           	
            case 3://插入
           	 System.out.println("输入插入位置");
           	 int m=new Scanner(System.in).nextInt();
           	 System.out.println("输入插入的元素");
           	 Object n1=new Scanner(System.in).next();
			try {
				L.insert(m, n1);
			} catch (Exception e) {
				e.printStackTrace();
			}
                break;
                
                
            case 4:         //删除
           	 System.out.println("输入删除的下标");
           	 int n2=new Scanner(System.in).nextInt();
			try {
				L.remove(n2);
			} catch (Exception e) {
				e.printStackTrace();
			}
                break;
            case 5:
            	
               L.display();
               System.out.println();
                break;
    
            case 6:// 跳出循环，结束操作
            	break a;
            default:
                System.out.println("输入有误！");
                break;
          }
        }
	  }
}
