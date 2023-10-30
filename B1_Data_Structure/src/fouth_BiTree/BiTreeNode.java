package fouth_BiTree;

           // 二叉链式结点
public class BiTreeNode {
            
	       public Object data;     //结点的数据域
	       public BiTreeNode lchild,rchild;      //左右孩子域
	       //构造空结点
	       public BiTreeNode() {
	    	   this(null);
	       }
	       //左右数据域为空
	       public BiTreeNode(Object data) {
	    	   this(data,null,null);
	       }
	       //均不为空
	       public BiTreeNode(Object data,BiTreeNode lchild,BiTreeNode rchild) {
	    	   this.data=data;
	    	   this.lchild=lchild;
	    	   this.rchild=rchild;
	       }
}
