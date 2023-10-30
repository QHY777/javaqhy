package zuoye;
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
         
         //中根遍历二叉树的递归算法
         public void inRootTraverse(BiTreeNode T) {
      	   if(T!=null) {
      		   inRootTraverse(T.lchild);
      		   System.out.print(T.data);
      		   inRootTraverse(T.rchild);
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
         //获取各层结点数最大值
         int[] count2 = new int[100];
     	 int max = -1;
     	 public int FindWidth(BiTreeNode T,int k) {
     		 if(T == null) return 0;
     	 	 count2[k]++;
     		 if(max < count2[k]) max = count2[k];
     		 FindWidth(T.lchild,k+1);
     		 FindWidth(T.rchild,k+1);
     		 return max;
     	 }
     	 
     	public static void main(String[] args) {
    		String preStr = "AB#D##C##";
    		BiTree T = new BiTree(preStr);   //建立二叉树
    		BiTreeNode root = T.getRoot();
    		int n = T.getDepth(root);
    		System.out.println("二叉树的深度为：" + n);
    		System.out.println("二叉树的最大宽度为：" + T.FindWidth(root, 0));
    		System.out.println("二叉树的繁茂度为：" + n*T.max);
    	}
}
