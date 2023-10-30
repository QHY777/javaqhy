package fouth_BiTree;

import java.util.Scanner;

public class Test_BiTree {
	
	
          public static void main(String[] args) {
        	System.out.println("输入带#字符串建立二叉树(先根）："); 
        	//AB#D##C##
        	Scanner sc=new Scanner(System.in);
        	String preStr=sc.next();
			BiTree T=new BiTree(preStr);
			sc.close();
			
			System.out.print("递归先根遍历：");
			T.preRootTraverse(T.getRoot());
			System.out.print("\n递归中根遍历：");
			T.inRootTraverse(T.getRoot());
			System.out.print("\n递归后根遍历：");
			T.postRootTraverse(T.getRoot());
			System.out.print("\n非递归先根遍历:");
			T.preRootTraverse(); 
			System.out.print("\n非递归中根遍历:");
			T.inRootTraverse();
			System.out.print("\n非递归后根遍历:");
			T.postRootTraverse(); 

			
			System.out.println("\n深度:"+T.getDepth(T.getRoot()));
			System.out.println("叶子结点数目："+T.countLeafNode(T.getRoot()));
		}
}
