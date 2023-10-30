package fifth_Search;

import fouth_BiTree.BiTreeNode;
import sixth_Sort.RecordNode;

public class BSTree {
	public BiTreeNode root;   //根结点

    public BSTree() {  //构造空二叉排序树
        root = null;
    }
    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }
    
    public boolean isEmpty() { //判断是否空二叉树
        return this.root == null;
    }

    public void inOrderTraverse(BiTreeNode p) { //中根次序遍历以p结点为根的二叉树
        if (p != null) {
            inOrderTraverse(p.lchild);
            System.out.print(((RecordNode) p.data).toString() + "");
            inOrderTraverse(p.rchild);
        }
    }

    //查找关键字值为key的结点,若查找成功返回结点值，否则返回null
    public Object searchBST(Comparable key) {
        if (key == null || !(key instanceof Comparable)) {
            return null;
        }
        return searchBST(root, key);
    }
    //二叉排序树查找的递归算法
    //在二叉排序树中查找关键字为key的结点。若查找成功则返回结点值，否则返回null
    private Object searchBST(BiTreeNode p, Comparable key) {
        if (p != null) {
            if (key.compareTo(((RecordNode) p.data).key) == 0) //查找成功
            {
                return p.data;
            }
            if (key.compareTo(((RecordNode) p.data).key) < 0) {
                return searchBST(p.lchild, key);     //在左子树中查找
            } else {
                return searchBST(p.rchild, key);    //在右子树中查找
            }
        }
        return null;
    }
    //插入新结点
    //插入成功返回true，不然false
    public boolean insertBST(Comparable key,Object theElement) {
    	if(key==null||!(key instanceof Comparable)) {
    		return false;
    	}
    	if(root==null) {
    		root=new BiTreeNode(new RecordNode(key,theElement));//建立根结点
    		return true;
    	}
    	return insertBST(root,key,theElement);
    }
    //将关键字为key，数据元素theElement结点插入到以p为根结点二叉排序树中（递归）
    private boolean insertBST(BiTreeNode p,Comparable key,Object theElement) {
    	if(key.compareTo(((RecordNode)p.data).key)==0) {
    		return false;           //不插入关键字相同结点
    	}
    	if(key.compareTo(((RecordNode)p.data).key)<0) {
    		if(p.lchild==null) {      //根结点左子树空
    			p.lchild=new BiTreeNode(new RecordNode(key,theElement));
    			return true;
    		}else {                     //根结点左子树不空
    			return insertBST(p.lchild,key,theElement);
    		}
    	}else if(p.rchild==null) {         //根结点右子树空
    		p.rchild=new BiTreeNode(new RecordNode(key,theElement));
    		return true;
    	}else {
    		return insertBST(p.rchild,key,theElement);
    	}
    }
    public void display() {
    	inRootTraverse(root);
    }
    public void inRootTraverse(BiTreeNode T) {
 	   if(T!=null) {
 		   inRootTraverse(T.lchild);
 		   System.out.println("key:"+((RecordNode)T.data).key+"   element:"+((RecordNode)T.data).element);
 		   inRootTraverse(T.rchild);
 	   }
    }

}
