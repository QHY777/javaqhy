package first_Sq_LinkList;

import java.util.Scanner;

public class RemoveSelect_LinkList {
	
       public static void remove_Select(LinkList L,int mink,int maxk) {
    	   Node p=L.head.next;
    	   Node q=L.head;
    	   while(p!=null) {
    		   if(Integer.parseInt(p.data.toString())<maxk&&Integer.parseInt(p.data.toString())>mink) {
    			   p=p.next; //删除该结点
    			   q.next=p;
    		   }else {
    			   q=p;          //后移一个
    			   p=p.next;
    		   }
    	   }
       }
       @SuppressWarnings("resource")
	public static void main(String[] args) {
    	   System.out.println("输入mink");
    	   int i=new Scanner(System.in).nextInt();
    	   System.out.println("输入maxk");
    	   int n=new Scanner(System.in).nextInt();
    		try {
    			LinkList L = new LinkList(10,false);
    			System.out.println("处理前：");
    			L.display();
    			remove_Select(L,i,n);
    			System.out.println();
    			System.out.println("处理后:");
    			L.display();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    	  
   
	}
}
