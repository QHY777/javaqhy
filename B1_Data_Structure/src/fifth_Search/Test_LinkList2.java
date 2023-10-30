package fifth_Search;

import java.util.Scanner;

import sixth_Sort.RecordNode;

public class Test_LinkList2 {
    public static void main(String[] args) throws Exception {
    	LinkList2 L=new LinkList2();
    	
    	Scanner sc=new Scanner(System.in);

    	 a:    while(true) { 
    		    System.out.println("--------菜单---------");
    	        System.out.println("请输入确认操作:");
    	        System.out.println("1 建立链表");
    	        System.out.println("2 查找（成功则返回并删除，失败则添加）");
    	        System.out.println("3 全部展示");
    	        System.out.println("4 操作结束");
    	        System.out.println("---------------------");
    			   int i=sc.nextInt();

    	    	   switch (i) {
    	
    	               
    	            case 1:
	    	             System.out.println("输入元素个数以建立链表：");
	    	             int m=new Scanner(System.in).nextInt();
	    	             for(int i1=0;i1<m;i1++) {
	    	            	 System.out.println("输入第"+i1+"个结点关键字：");
		    			     Comparable key=sc.next();
		    			     System.out.println("输入第"+i1+"个结点数据：");
		    			     Object element=sc.next();
		    			     RecordNode r=new RecordNode(key,element);
		    			     
		    				 try {
		    					L.insert(i1, r);
		    				 } catch (Exception e) {
		    					e.printStackTrace();
		    				 }
	    	             }
    	                break;
    	            case 2:
    	            	System.out.println("输入查找关键字：");
    	            	Comparable key1=sc.next();
    	            	if(L.seqSearch(key1)!=-1) {
    	            		System.out.println("查找成功");
    	            		System.out.println("key:"+key1+"   element："+L.get(L.seqSearch(key1)).element);
    	            		L.remove(L.seqSearch(key1));
    	            		System.out.println("删除成功");
    	            	}else {
    	            		System.out.println("查找失败");
    	    			    System.out.println("输入结点数据：");
    	    			    Object data1=sc.next();
    	    			    RecordNode r1=new RecordNode(key1,data1);
    	    			     
    	    			     try {
    	    					L.insert(L.getLength(), r1);
    	    				    System.out.println("添加成功");
    	    				 } catch (Exception e) {
    	    					e.printStackTrace();
    	    				 }
    	            	}
    	            	break;
    	            
    	            case 3:
    	            	System.out.println("展示：");
    	                L.display();
    	                System.out.println();
    	                break;
    	    
    	            case 4:// 跳出循环，结束操作
    	            	sc.close();
    	            	System.out.println("结束");
    	            	break a;
    	            default:
    	                System.out.println("输入有误！");
    	                break;
    	
              }
    	 }
      }
	
}

	

