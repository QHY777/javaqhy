package fouth_BiTree;

import second_Stack_Queue.LinkQueue;
import second_Stack_Queue.LinkStack;

//二叉树
public class BiTree {
           private BiTreeNode root;  //根结点
           public BiTree() {         //构造空树
        	   this.root=null;
           }
           public BiTreeNode getRoot() {
        	   return root;
           }
           public void setRoot(BiTreeNode root) {
        	   this.root=root;
           }
           //由先根遍历和中根遍历序列创建一棵二叉树
           public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count) {
        	   
           }
           //由标明空子树的先根遍历序列建立一棵二叉树，并返回根结点
           private  static int index=0;
           public BiTree(String preStr) {
        	   char c =preStr.charAt(index++);
        	   if(c!='#') {
        		   root =new BiTreeNode(c);
        		   root.lchild=new BiTree(preStr).root;
        		   root.rchild=new BiTree(preStr).root;
        	   }else 
        		   root=null;
        	   
           }
           //先根遍历二叉树的递归算法
           public void preRootTraverse(BiTreeNode T) {
        	   if(T!=null) {
        		   System.out.print(T.data);
        		   preRootTraverse(T.lchild);
        		   preRootTraverse(T.rchild);
        	   }
           }
           //先根遍历二叉树的非递归算法
           public void preRootTraverse() {
        	   BiTreeNode T=root;
        	   if(T!=null) {
        		   LinkStack s=new LinkStack();
        		   s.push(T);           //根结点入栈
        		   while(!s.isEmpty()) {
        			   T=(BiTreeNode)s.pop();      //移除栈顶结点，并返回其值
        			   System.out.print(T.data);     //访问结点
        			   while(T!=null) {
        				   if(T.lchild!=null) {            //访问左孩子
        					   System.out.print(T.lchild.data);      
        				   }
        				   if(T.rchild!=null) {            //右孩子非空入栈
        					   s.push(T.rchild);
        				   }
        				   T=T.lchild;
        			   }
        		   }
        	   }
           }

           //中根遍历二叉树的递归算法
           public void inRootTraverse(BiTreeNode T) {
        	   if(T!=null) {
        		   inRootTraverse(T.lchild);
        		   System.out.print(T.data);
        		   inRootTraverse(T.rchild);
        	   }
           }
           
           //中根遍历二叉树的非递归算法
           public void inRootTraverse() {
        	   BiTreeNode T=root;
        	   if(T!=null) {
        		   LinkStack S=new LinkStack();
        		   S.push(T);                //根结点入栈
        		   while(!S.isEmpty()) {
	        		   while(S.peek() != null) {          //栈顶结点左孩子相继入栈
	        			   S.push(((BiTreeNode)S.peek()).lchild);
	        		   }
	        		   S.pop();    //空结点退栈
	        		   if(!S.isEmpty()) {
	        			   T=(BiTreeNode)S.pop();       //移除栈顶结点，并返回其值
	        			   System.out.print(T.data);
	        			   S.push(T.rchild);         //结点右孩子入栈
	        		   }
	        	   }
               }
           }
           //后根遍历二叉树的递归算法
           public void postRootTraverse(BiTreeNode T) {
        	   if(T!=null) {
        		   postRootTraverse(T.lchild);
        		   postRootTraverse(T.rchild);
        		   System.out.print(T.data);
        	   }
           }
           //后根遍历二叉树的非递归算法
           public void postRootTraverse() {
        	   BiTreeNode T=root;
        	   if(T!=null) {
        		   LinkStack S=new LinkStack();
        		   S.push(T);
        		   Boolean flag;
        		   BiTreeNode p=null;
        		   while(!S.isEmpty()) {
        			   while(S.peek()!=null) {
        				   S.push(((BiTreeNode)S.peek()).lchild);
        			   }
        			   S.pop();
        			   while(!S.isEmpty()) {
        				   T=(BiTreeNode)S.peek();
        				   if(T.rchild==null||T.rchild==p) {
        					   System.out.print(T.data);
        					   S.pop();
        					   p=T;
        					   flag=true;
        				   }else {
        					   S.push(T.rchild);
        					   flag=false;
        				   }
        				   if(!flag) {
        					   break;
        				   }
        			   }
        		   }
        	   }
           }
           //层次遍历（从左向右）
           public void levelTraverse() {
        	     BiTreeNode T=root;
        	     if(T!=null) {
        	    	 LinkQueue L=new LinkQueue();
        	    	 L.offer(T);
        	    	 while(!L.isEmpty()) {
        	    		 T=(BiTreeNode)L.poll();
        	    		 System.out.print(T.data);
        	    		 if(T.lchild!=null) {
        	    			 L.offer(T.lchild);
        	    		 }
        	    		 if(T.rchild!=null) {
        	    			 L.offer(T.rchild);
        	    		 }
        	    	 }
        	     }
           }
           //先根遍历求结点数目
           public int countNode(BiTreeNode T) {
        	   int count=0;
        	   if(T!=null) {
        		   count++;
        		   count+=countNode(T.lchild);
        		   count+=countNode(T.rchild);
        	   }
        	   return count;
           }

           //遍历求树的深度
           public int getDepth(BiTreeNode T) {
        	   if(T!=null) {
        		   int lDepth=getDepth(T.lchild);
        		   int rDepth=getDepth(T.rchild);
        		   return 1+(lDepth>rDepth? lDepth:rDepth);
        	   }
        	   return 0;
           }
           //叶子结点数目
           public int countLeafNode(BiTreeNode T) {
        	   int count=0;
        	   if(T!=null) {
        		   if(T.lchild==null&&T.rchild==null) {
        			   count++;
        		   }
        		   count+=countLeafNode(T.lchild);
        		   count+=countLeafNode(T.rchild);
        	   }
        	   return count;
           }
}
