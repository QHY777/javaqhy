package first_Sq_LinkList;

//结点类
public class Node {
         public Object data;
         public Node next;
         public Node(Object data,Node next) {
        	 this.data=data;
        	 this.next=next;
         }
         public Node() {
        	 this(null,null);
         }
         public Node(Object data) {
        	 this(data,null);
         }
}
