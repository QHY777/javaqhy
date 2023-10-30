package fifth_Search;

import java.util.Scanner;


import sixth_Sort.RecordNode;

public class Test_BSTree {
	
	public static void main(String[] args) {
		BSTree T=new BSTree();
		Scanner sc=new Scanner(System.in);
	a:	while(true) {
		    System.out.println("请输入指令：");
		    System.out.println("-----菜单--------");
			System.out.println("1，建立二叉排序树/插入");
			System.out.println("2，查找");
			System.out.println("3，展示");
			System.out.println("4，退出菜单");
			System.out.println("-----------------");
			
			
			int menu=sc.nextInt();
			switch(menu) {
			
			case(1):
				System.out.println("输入结点数：");
			    int i1=sc.nextInt();
			    for(int i=0;i<i1;i++) {
			    	System.out.println("输入第"+i+"个关键字：");
			    	Comparable key=sc.next();
			    	System.out.println("输入第"+i+"个数据元素：");
			    	Object element=sc.next();
			    	T.insertBST(key, element);
			    }
			    break;
			case(2):
				System.out.println("输入关键字：");
	    	    Comparable key=sc.next();
	    	    if(T.searchBST(key)==null) {
	    	    	System.out.println("查找不到");
	    	    }else {
	    	    	System.out.println("key:"+((RecordNode)T.searchBST(key)).key+"    element:"+((RecordNode)T.searchBST(key)).element);
	    	    }
	    	    break;
			case(3):
				System.out.println("展示如下：");
				T.display();
				break;
			case(4):
				break a;
			default:
				System.out.println("输入错误");
			}
		}
	}

}
